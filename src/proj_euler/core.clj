(ns proj-euler.core)

(defn- factors [n candidate]
   (cond (< n candidate) []
        (zero? (rem n candidate)) (cons candidate (factors (/ n candidate) candidate))
        :else (factors n (inc candidate))))

(defn prime-factors [n]
  (factors n 2))

(defn largest-prime [n]
  (apply max (prime-factors n)))


