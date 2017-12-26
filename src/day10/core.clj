(ns day10.core
  (:require
    [clojure.test :refer :all]
    [clojure.string :refer [split]]
    ))

(def input "34,88,2,222,254,93,150,0,199,255,39,32,137,136,1,167")

(defn number-vector
  [input]
  (->> input
       (#(-> (split % #",")))
       (map read-string)
       )
  )

(defn circular-subvector
  {:test #(do
            (is (= (circular-subvector [2 1 0 3 4] 3 4) [3 4 2 1]))
            (is (= (circular-subvector [1 2 3] 0 3) [1 2 3]))
            (is (= (circular-subvector [1 2 3] 1 1) [2]))
            (is (= (circular-subvector [1 2 3] 1 0) []))
            )}
  [vector start-index subvector-length]
  (if (< (+ start-index subvector-length) (count vector))
      (subvec vector start-index (+ start-index subvector-length))
      (concat (subvec vector start-index (count vector)) (subvec vector 0 (mod (+ start-index subvector-length) (count vector))))
    )
  )

(defn reverse-circular-subvector
  {:test #(do
            (is (= (reverse-circular-subvector [1 2 3] 0 3) [3 2 1]))
            (is (= (reverse-circular-subvector [1 2 3] 1 2) [1 3 2]))
            (is (= (reverse-circular-subvector [4 3 0 1 2] 3 4) [2 1 0 3 4]))
            )
   }
  [vector start-index subvector-length]
  (let [reverse-subvector (reverse (circular-subvector vector start-index subvector-length))]
    (loop [modification-vector vector
           [number & numbers] reverse-subvector
           current-index start-index]
      (if (nil? number)
        modification-vector
        (recur
          (assoc modification-vector (mod current-index (count vector)) number)
          numbers
          (inc current-index)
          )
        )
      )
    )
  )

(defn multiply-first-two-elements
  [seq]
  (* (first seq) (second seq)))

(defn tie-knot
  {:test #(do
            (is (= (multiply-first-two-elements (tie-knot [3 4 1 5] 5)) 12))
            (is (= (multiply-first-two-elements (tie-knot (number-vector input) 256))) 54675) ; first answer

            )}
  [lengths sequence-size]
  (loop
    [[length & lengths] lengths
     number-list (vec (range 0 sequence-size))
     current-pos 0
     skip-size 0]
    (if (nil? length)
      number-list
      (recur
        lengths
        (reverse-circular-subvector number-list current-pos length)
        (mod (+ length skip-size current-pos) sequence-size)
        (inc skip-size)
        )
      )
    )
  )

(defn knot-hash-256
  {:test #(do
            (is (= (knot-hash-256 "") "a2582a3a0e66e6e86e3812dcb672a272"))
            (is (= (knot-hash-256 "AoC 2017") "33efeb34ea91902bb2f59c9920caa6cd"))
            (is (= (knot-hash-256 "1,2,3") "3efbe78a8d82f29979031a4aa0b16a9d"))
            (is (= (knot-hash-256 "1,2,4") "63960835bcdc130f0b66d7ff4f6a5a8e"))
            (is (= (knot-hash-256 input) "a7af2706aa9a09cf5d848c1e6605dd2a")) ;second answer
            )}
  [input]
  (->> input
       (map int)
       (#(-> (concat % [17 31 73 47 23])))
       (repeat 64)
       (reduce concat [])                                   ;prepared input
       (#(-> (tie-knot % 256)))                             ;sparse hash
       (partition 16)
       (map #(-> (apply bit-xor %)))                        ;dense hash
       (map #(-> (format "%02x" %)))
       (apply str)                                          ;knot-hash
       )
  )