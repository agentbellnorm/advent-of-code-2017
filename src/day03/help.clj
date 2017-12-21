(ns day03.help)

(defn exp [x n]
  (if (zero? n) 1
                (* x (exp x (dec n)))))