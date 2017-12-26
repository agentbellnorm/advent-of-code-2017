(ns day03.core
  (:require [clojure.test :refer :all]
            [day03.core :refer :all]
            [clojure.string :refer :all]))

(defn exp [x n]
  (if (zero? n) 1
                (* x (exp x (dec n)))))

(defn number-is-in-correct-circle?
  {:test #(do
            (is (number-is-in-correct-circle? 2 1))
            (is (number-is-in-correct-circle? 4 1))
            (is (number-is-in-correct-circle? 9 3))
            (is (number-is-in-correct-circle? 25 5))
            (is (number-is-in-correct-circle? 24 5))
            (is (number-is-in-correct-circle? 49 7))
            (is (number-is-in-correct-circle? 48 5))
            (is (number-is-in-correct-circle? 24 3))
            (is (number-is-in-correct-circle? 81 9))
            (is (number-is-in-correct-circle? 80 7))
            (is (not (number-is-in-correct-circle? 82 3)))
            (is (not (number-is-in-correct-circle? 10 1)))
            )}
  [number base]
  (and (> number 2)) (<= number (exp (+ base 2) 2)))

(defn get-side-length-internal
  [number base]
  (if (= number 1)
    1
    (if (number-is-in-correct-circle? number base)
      (+ base 2)
      (get-side-length-internal number (+ base 2)))))

(defn get-side-length
  {:test #(do
            (is (= (get-side-length 1) 1))
            (is (= (get-side-length 8) 3))
            (is (= (get-side-length 9) 3))
            (is (= (get-side-length 10) 5))
            (is (= (get-side-length 24) 5))
            (is (= (get-side-length 48) 7))
            (is (= (get-side-length 49) 7))
            (is (= (get-side-length 50) 9))
            (is (= (get-side-length 80) 9))
            (is (= (get-side-length 81) 9))
            (is (= (get-side-length 82) 11))
            )}
  [number]
  (get-side-length-internal number 1))

;; Get side length

(defn get-bottom-right-corner
  [number]
  (exp (get-side-length number) 2))

(defn get-corner
  {:test #(do
            (is (= (get-corner 8 1) 7))
            (is (= (get-corner 8 0) 9))
            (is (= (get-corner 24 1) 21))
            )}
  [number corner-number]
  (- (get-bottom-right-corner number) (* corner-number (dec (get-side-length number)))))

(defn get-four-corners
  {:test #(do
            (is (= (get-four-corners 8) #{9 5 7 3}))
            (is (= (get-four-corners 10) #{13 17 21 25}))
            )}
  [number]
  (into #{}
        (map (fn[x] (get-corner number x)) (range 0 4))))

;; to get all four corners of a number

(defn get-cross-numbers
  {:test #(do
            (is (= (get-cross-numbers 10 ) #{23 15 19 11}))
            (is (= (get-cross-numbers 8 ) #{8 6 4 2}))
            )}
  [number]
  (into #{}
        (map (fn[corner] (- corner (/ (dec (get-side-length number)) 2))) (get-four-corners number))
        )
  )

;; get the cross values of one number

(defn get-smallest-distance
  {:test #(do
            (is (= (get-smallest-distance 8) 0))
            (is (= (get-smallest-distance 9 )1))
            (is (= (get-smallest-distance 12 )1))
            (is (= (get-smallest-distance 17) 2))
            (is (= (get-smallest-distance 23) 0))
            (is (= (get-smallest-distance 49) 3))
            )}
  [number]
  (apply min (map (fn[cross] (Math/abs(- cross number))) (get-cross-numbers number)))
  )
;;Get the smallest distance from the number to a cross value

(defn get-distance
  {:test #(do
            (is (= (get-distance 1) 0))
            (is (= (get-distance 12) 3))
            (is (= (get-distance 23) 2))
            (is (= (get-distance 1024) 31))
            (is (= (get-distance 361527) 326))
            )}
  [number]
  (+
    (/ (dec (get-side-length number)) 2)
    (get-smallest-distance number)
    )
)

;;Get distance from number to middle