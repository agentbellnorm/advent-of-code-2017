(ns day02.core
  (:require [clojure.test :refer :all]
            [day02.core :refer :all]
            [clojure.string :refer :all]
            [clojure.math.combinatorics :refer :all]))

(defn in?
  "true if coll contains elm"
  [coll elm]
  (some #(= elm %) coll))


(defn split-into-rows [table]
  (split (trim table) #"\n"))

(defn parse-int [s]
  (Integer. (re-find  #"\d+" s )))

(defn split-into-columns [row]
  (map parse-int (split (trim row) #"\t+")))

(defn get-min-and-max-diff [clean-row]
  (- (apply max clean-row) (apply min clean-row)))

(defn checksum
  [table]
  (apply +
         (map get-min-and-max-diff
              (map split-into-columns
                   (split-into-rows table)))))

(defn captcha2
  [table]
  (apply +(map sum-of-rows (map split-into-columns (split-into-rows table)))))

(defn pair-fraction [pair]
  (quot (reduce max pair) (reduce min pair)))


(defn pair-modulo
  "docstring"
  [pair]
  (mod (reduce max pair) (reduce min pair)))

(defn one-evenly-divides-the-other?
  [pair]
  (or))

(defn valid-fraction? [pair]
  (and (= (pair-modulo pair) 0) (not (= (pair-fraction pair) 1)) (not (in? pair 1))))

(defn sum-of-rows
  [clean-row]
  (pair-fraction (first (filter valid-fraction? (combinations clean-row 2))))
  )
