(ns euler.problem12-test
  (:require [expectations :refer :all]
            [euler.problem12 :refer :all]))

(expect 28 (triangle-number 7))
(expect 66 (triangle-number 11))

(expect 4 (number-of-factors 6))
(expect 4 (number-of-factors 8))
(expect 6 (number-of-factors (triangle-number 7)))

(expect 48 (number-of-factors (triangle-number 104)))

(expect 45129750 (triangle-number 9500))
(expect 45158256 (triangle-number 9503))
(expect 320 (number-of-factors (triangle-number 9503)))
