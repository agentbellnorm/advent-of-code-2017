(ns day07.core
  (:require
    [clojure.test :refer :all]
    [clojure.string :refer :all]))

(defn parse-input-line
  {:test #(do
            (is (= (parse-input-line "pbga (66) ") {:name "pbga" :weight 66 :children #{} }))
            (is (= (parse-input-line "fwft (72) -> ktlj, cntj, xhth") {:name "fwft" :weight 72 :children #{"ktlj" "cntj" "xhth"} }))
            )
   }
  [line]
  (let [args (split line #" ")]
    (println args)
  {
   :name (first args)
   :weight (Integer. (re-find #"\d+" (second args)))
   :children (if (.contains args "->")
     (set (split (re-find #"(?<=-> ).*" line) #", "))
     #{})
   }
  )
  )

