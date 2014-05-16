(ns euler.core)

(defmacro dbg[x] `(let [x# ~x] (println '~x "=" x#) x#))

(def natural-numbers (iterate inc 1))

(defn- factors [n candidate]
   (cond (< n candidate) []
        (zero? (rem n candidate)) (cons candidate (factors (/ n candidate) candidate))
        :else (factors n (inc candidate))))

(defn prime-factors [n]
  (factors n 2))


(defn largest-prime [n]
  (apply max (prime-factors n)))
