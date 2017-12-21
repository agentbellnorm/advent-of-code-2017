(ns day03.core
  (:require [clojure.test :refer :all]
            [day03.core :refer :all]
            [clojure.string :refer :all]))

(defn number-is-in-correct-circle?
  [number base]
  (and (> number 2)) (<= number (day03.help/exp (+ base 2) 2)))

(defn get-side-length-internal
  [number base]
  (if (= number 1)
    1
    (if (number-is-in-correct-circle? number base)
      (+ base 2)
      (get-side-length-internal number (+ base 2)))))

(defn get-side-length
  [number]
  (get-side-length-internal number 1))

;; Get side length

(defn get-bottom-right-corner
  [number]
  (day03.help/exp (get-side-length number) 2))

(defn get-corner
  [number corner-number]
  (- (get-bottom-right-corner number) (* corner-number (dec (get-side-length number)))))

(defn get-four-corners
  [number]
  (into #{}
        (map (fn[x] (get-corner number x)) (range 0 4))))

;; to get all four corners of a number

(defn get-cross-numbers
  [number]
  (into #{}
        (map (fn[corner] (- corner (/ (dec (get-side-length number)) 2))) (get-four-corners number))
        )
  )

;; get the cross values of one number

(defn get-smallest-distance
  [number]
  (apply min (map (fn[cross] (Math/abs(- cross number))) (get-cross-numbers number)))
  )
;;Get the smallest distance from the number to a cross value

(defn get-distance
  [number]
  (+
    (/ (dec (get-side-length number)) 2)
    (get-smallest-distance number)
    )
)

;;Get distance from number to middle