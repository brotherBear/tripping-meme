(ns euler.problem12
  (:require [euler.core :refer [prime-factors]]))


;; What is the value of the first triangle number to have over five hundred divisors?

(defn triangle-number [n] (apply + (range (inc n))))
(def tns (memoize triangle-number))

;; (triangle-number 6)

(defn count-factors [n] (count (prime-factors (triangle-number n))))

;; (triangle-number 135)

(defn- count-occurrences
  "For a given collection, return a list of the occurrences of each element"
  [coll]
  (for [x (set coll)]
    (count (filter #{x} coll))))

;; (count-occurrences [:a 1 1 2 2 :a :b 1 :c :c :c])

(defn number-of-factors
  [number]
  (reduce *
          (map inc
               (count-occurrences
                (prime-factors number)))))


(def tri-nums-with-factors-up-to-500
  (for [n (range 11000 13000)
        :let [t (triangle-number n)
              f (number-of-factors t)]
        :while (<= f 590)]
    [n t f]))



;;(filter (fn [[_ _ f]] (>= f 90)) tri-nums-with-factors-up-to-500)

;;(count tri-nums-with-factors-up-to-500)

(first (reverse (sort-by last tri-nums-with-factors-up-to-500)))

; (reverse (sort-by first tri-nums-with-factors-up-to-500))
;; (factors (triangle-number 104))
;; (count-factors 104)
;; (number-of-factors (triangle-number 104))
