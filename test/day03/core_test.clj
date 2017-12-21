(ns day03.core-test
  (:require [clojure.test :refer :all]
            [day03.core :refer :all]))

;(deftest get-distance-test
;  (testing "get-distance")
;  (is (= (day03.core/get-distance ) 4)))

(deftest get-side-length-test
  (testing "get-side-length")
  (is (= (day03.core/get-side-length 1) 1))
  (is (= (day03.core/get-side-length 8) 3))
  (is (= (day03.core/get-side-length 9) 3))
  (is (= (day03.core/get-side-length 10) 5))
  (is (= (day03.core/get-side-length 24) 5))
  (is (= (day03.core/get-side-length 48) 7))
  (is (= (day03.core/get-side-length 49) 7))
  (is (= (day03.core/get-side-length 50) 9))
  (is (= (day03.core/get-side-length 80) 9))
  (is (= (day03.core/get-side-length 81) 9))
  (is (= (day03.core/get-side-length 82) 11))
  )

(deftest number-is-in-correct-circle?-test
  (testing "number-is-in-correct-circle")
  (is (day03.core/number-is-in-correct-circle? 2 1))
  (is (day03.core/number-is-in-correct-circle? 4 1))
  (is (day03.core/number-is-in-correct-circle? 9 3))
  (is (day03.core/number-is-in-correct-circle? 25 5))
  (is (day03.core/number-is-in-correct-circle? 24 5))
  (is (day03.core/number-is-in-correct-circle? 49 7))
  (is (day03.core/number-is-in-correct-circle? 48 5))
  (is (day03.core/number-is-in-correct-circle? 24 3))
  (is (day03.core/number-is-in-correct-circle? 81 9))
  (is (day03.core/number-is-in-correct-circle? 80 7))
  (is (not (day03.core/number-is-in-correct-circle? 82 3)))
  (is (not (day03.core/number-is-in-correct-circle? 10 1)))
  )

(deftest get-corner-test
  (testing "get-corner")
  (is (= (day03.core/get-corner 8 1) 7))
  (is (= (day03.core/get-corner 8 0) 9))
  (is (= (day03.core/get-corner 24 1) 21))
  )

(deftest get-four-corners-test
  (testing "get-four-corners")
  (is (= (day03.core/get-four-corners 8) #{9 5 7 3}))
  (is (= (day03.core/get-four-corners 10) #{13 17 21 25}))
  )

(deftest get-cross-numbers-test
  (testing "get-cross-numbers")
  (is (= (day03.core/get-cross-numbers 10 ) #{23 15 19 11}))
  (is (= (day03.core/get-cross-numbers 8 ) #{8 6 4 2}))
  )

(deftest get-smallest-distance-test
  (testing "get-smallest-distance")
  (is (= (day03.core/get-smallest-distance 8) 0))
  (is (= (day03.core/get-smallest-distance 9 )1))
  (is (= (day03.core/get-smallest-distance 12 )1))
  (is (= (day03.core/get-smallest-distance 17) 2))
  (is (= (day03.core/get-smallest-distance 23) 0))
  (is (= (day03.core/get-smallest-distance 49) 3))
  )

(deftest get-distance-test
  (testing "get-distance")
  (is (= (day03.core/get-distance 1) 0))
  (is (= (day03.core/get-distance 12) 3))
  (is (= (day03.core/get-distance 23) 2))
  (is (= (day03.core/get-distance 1024) 31))
  (is (= (day03.core/get-distance 361527) 326))
  )
