(ns day06.core
  (:require
    [clojure.test :refer :all]
    [clojure.string :refer :all]))

(defn circular-index
  {:test #(do
            (is (circular-index [1 2 3 4] 4) 0)
            (is (circular-index [1 2 3 4] 5) 1))}
  [vector index]
  (mod index (count vector)))

(defn clean-input
  {:test #(do
            (is (= (clean-input "5\t-5") [5 -5])))}
  [input-str]
  (map read-string (split input-str #"\t")))

(defn redistribute
  {:test #(do
            (is (= (redistribute [0 2 7 0]) [2 4 1 2])))}
  [memory-vector-in]
  (loop [memory-vector (assoc (vec memory-vector-in) (.indexOf memory-vector-in (apply max memory-vector-in)) 0)
         index (inc (.indexOf memory-vector-in (apply max memory-vector-in)))
         count (apply max memory-vector-in)]
    (if (zero? count)
      memory-vector
    (recur
      (assoc (vec memory-vector) (circular-index memory-vector index) (inc (nth memory-vector (circular-index memory-vector index))))
      (inc index)
      (dec count)))))

(defn runs-before-termination-a
  {:test #(do
      (is (= (runs-before-termination-a "0\t2\t7\t0") 5))
      (is (= (runs-before-termination-a "14\t0\t15\t12\t11\t11\t3\t5\t1\t6\t8\t4\t9\t1\t8\t4") 11137)))}
  [memory-vector-raw]
  (loop [memory-vector (clean-input memory-vector-raw)
         history []]
    (if (pos? (.indexOf history memory-vector))
      (count history)
      (recur
        (redistribute memory-vector)
        (conj history memory-vector)))))

(defn runs-before-termination-b
  {:test #(do
            (is (= (runs-before-termination-b "0\t2\t7\t0") 4))
            (is (= (runs-before-termination-b "14\t0\t15\t12\t11\t11\t3\t5\t1\t6\t8\t4\t9\t1\t8\t4") 1037))
            )}
  [memory-vector-raw]
  (loop [memory-vector (clean-input memory-vector-raw)
         history []
         count 0]
    (if (pos? (.indexOf history memory-vector))
      (- count (.indexOf history memory-vector))
      (recur
        (redistribute memory-vector)
        (conj history memory-vector)
        (inc count)))))

