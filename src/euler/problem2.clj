;; By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
(defn fibo []
  (map first (iterate (fn [[a b]] [b (+ a b)])
                      [0N 1N])))

(number? (first (fibo)))

(< (last (take 35 (fibo))) 4000000)

(apply + (filter even? (take 34 (fibo))))

