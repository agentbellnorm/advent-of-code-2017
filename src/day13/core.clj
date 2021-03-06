(ns day13.core
  (:require
    [clojure.test :refer :all]
    [clojure.string :refer [split]]
    ))

(def firewall
  (->> "0: 3\n1: 2\n2: 4\n4: 4\n6: 5\n8: 6\n10: 8\n12: 8\n14: 6\n16: 6\n18: 9\n20: 8\n22: 6\n24: 10\n26: 12\n28: 8\n30: 8\n32: 14\n34: 12\n36: 8\n38: 12\n40: 12\n42: 12\n44: 12\n46: 12\n48: 14\n50: 12\n52: 12\n54: 10\n56: 14\n58: 12\n60: 14\n62: 14\n64: 14\n66: 14\n68: 14\n70: 14\n72: 14\n74: 20\n78: 14\n80: 14\n90: 17\n96: 18"
    (#(-> (split % #"\n")))
    (map #(-> (split % #": ")))
    (map #(-> {(read-string (first %)) (read-string (second %))}))
    (reduce into {})
  )
)

(def dev-firewall
  (->> "0: 3\n1: 2\n4: 4\n6: 4"
       (#(-> (split % #"\n")))
       (map #(-> (split % #": ")))
       (map #(-> {(read-string (first %)) (read-string (second %))}))
       (reduce into {})
       )
  )

(defn printret
  [v]
  (println v)
  v)

(defn scaner-pos
  {:test #(do
            (is (= (scaner-pos 3 0) 0))
            (is (= (scaner-pos 3 1) 1))
            (is (= (scaner-pos 3 2) 2))
            (is (= (scaner-pos 3 3) 1))
            (is (= (scaner-pos 3 4) 0))
            (is (= (scaner-pos 3 5) 1))
            (is (= (scaner-pos 3 6) 2))
            )}
  [depth clock]
  (let [depth-index (dec depth)]
    (if (= 0 (mod (quot clock depth-index) 2))
      (mod clock depth-index)
      (- depth-index (mod clock depth-index))
      )))

(defn caught?
  {:test #(do
            (is (= (caught? dev-firewall 0 0) true))
            (is (= (caught? dev-firewall 6 0) true))
            (is (= (caught? dev-firewall 1 0) false))
            (is (= (caught? dev-firewall 2 0) false))
            (is (= (caught? dev-firewall 3 0) false))
            (is (= (caught? dev-firewall 4 0) false))
            (is (= (caught? dev-firewall 5 0) false))
            (is (= (caught? dev-firewall 0 1) false))
            (is (= (caught? dev-firewall 6 1) false))
            )}
  [firewall clock wait]
  (if (nil? (get firewall clock))
    false
      (= 0 (scaner-pos (get firewall clock) (+ wait clock)))))

(defn severity
  {:test #(do
            (is (= (severity dev-firewall 0 0) 1))
            (is (= (severity dev-firewall 1 0) 0))
            (is (= (severity dev-firewall 2 0) 0))
            (is (= (severity dev-firewall 3 0) 0))
            (is (= (severity dev-firewall 4 0) 0))
            (is (= (severity dev-firewall 5 0) 0))
            (is (= (severity dev-firewall 6 0) 24))
            )}
  [firewall clock wait]
  (cond
    (caught? firewall clock wait) (let [severity (* (get firewall clock) clock)]
                                      (if (zero? severity)
                                        (inc severity)
                                        severity))
    (nil? (get firewall clock)) 0
    :else 0))

(defn trip-severity
  {:test #(do
            (is (= (dec (trip-severity dev-firewall 0)) 24))  ;meh
            (is (= (dec (trip-severity firewall 0)) 2384))          ; first answer
            )}
  [firewall wait]
  (->> firewall
       (keys)
       (map #(-> (severity firewall % wait)) )
       (apply +)))

(trip-severity dev-firewall 1)


(defn min-wait
  {:test #(do
            (is (= (min-wait dev-firewall) 10))
            (is (= (min-wait firewall) 3921270))            ;second answer
            )}
  [firewall]
  (loop [wait 10]
    (if (zero? (trip-severity firewall wait))
      wait
        (recur (inc wait)))))
