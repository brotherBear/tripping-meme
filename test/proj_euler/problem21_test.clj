(ns proj-euler.problem21-test
  (:require [expectations :refer :all]
            [proj-euler.problem21 :refer :all]))

;; expect proper divisors of 220
(expect [1 2 4 5 10 11 20 22 44 55  110] (divisor 220))

(expect [1 2 5] (divisor 10))

(expect [1 73 137] (divisor 10001))

(expect [1 2 4 5 8 10 16 20 25 40 50 80 100 125 200 250 400 500 625 1000 1250 2000 2500 5000] (divisor 10000))

(expect 14211 (sum-divisors 10000))

(expect 284 (sum-divisors 220))

(expect 220 (sum-divisors 284))

(expect 36 (sum-divisors 24))

(expect 28 (sum-divisors 28))

(expect [] (amicable 100))

(expect [[220 284]] (ami-memo 1000))

(expect [[220 284] [1184 1210] [2620 2924] [5020 5564] [6232 6368]] (ami-memo 9225))

(expect 31626 (reduce + (flatten (ami-memo 9225))))
