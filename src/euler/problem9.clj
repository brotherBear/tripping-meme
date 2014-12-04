(ns euler.problem9
  (:require [euler.core :refer :all]))

;; A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

;; a2 + b2 = c2
;; For example, 32 + 42 = 9 + 16 = 25 = 52.

;; There exists exactly one Pythagorean triplet for which a + b + c = 1000.
;; Find the product abc.

(defn sum-nums [nums limit]
  (for [a nums
        b nums
        :let [c (- limit a b)]
        :when (and (= (* c c)
                      (+ (* a a)
                         (* b b)))
                   (< a b c))]
    [a b c (* a b c)]))

(def lim 1000)
(sum-nums (take lim natural-numbers) lim)

(time (sum-nums (range 1000) 1000))
