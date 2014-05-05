(ns proj-euler.problem21)

(defn divisor
  "Returns the proper divisors of number n"
  ([n] (divisor n 1))
  ([n candidate]
   (cond (< (/ n 2) candidate) []
         (zero? (rem n candidate)) (cons candidate (divisor n (inc candidate)))
         :else (divisor n (inc candidate)))))

(def div-memo (memoize divisor))

(defn sum-divisors [number]
  (apply + (divisor number)))

(def sum-memo (memoize sum-divisors))

(defn amicable
  "list amicable numbers lower than number"
  [number]
  (distinct
   (for [x (range 2 number 2)
         :let [dx (sum-memo x)]
         :let [dy (sum-memo dx)]
         :when (and (= x dy) (not= dx dy))]
     (sort [x dx]))))

(def ami-memo (memoize amicable))