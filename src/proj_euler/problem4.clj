(ns proj-euler.problem4)

;; A palindromic number reads the same both ways. The largest palindrome
;; made from the product of two 2-digit numbers is 9009 = 91 × 99.
;;
;; Find the largest palindrome made from the product of two 3-digit numbers.

;; (apply read-string (re-seq #"[^0]+" (reverse (str 450))))
(defn flip [number]
  (apply read-string (re-seq #"[^0]+\d*"
                             (reduce str
                                     (reverse (str number))))))

(defn is-palindrome?
  "Given the number, return true if the number reads the same both backwards and forwards."
  [number]
  (cond (= number (flip number)) true
        :else false))

(def three-digit-numbers  (reverse (range 900 1000)))

(def products (for [a three-digit-numbers
                    b three-digit-numbers
                    :when (< a b)]
                (* a b)))
