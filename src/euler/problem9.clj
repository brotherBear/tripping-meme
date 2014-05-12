(ns euler.problem9
  (:require [euler.core :refer :all]))

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
