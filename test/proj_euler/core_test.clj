(ns proj-euler.core-test
  (:require [expectations :refer :all]
            [proj-euler.core :refer :all]))

;; The prime factor of nothing
(expect [] (prime-factors 0))

;; The prime factor of 1
(expect [] (prime-factors 1))

;; The prime factor of 2
(expect [2] (prime-factors 2))

;; The prime factor of 3
(expect [3] (prime-factors 3))

;; The prime factors of 4
(expect [2 2] (prime-factors 4))

;; The prime factor of 5
(expect [5] (prime-factors 5))

;; The prime factors of 6
(expect [2 3] (prime-factors 6))

;; The prime factor of 7
(expect [7] (prime-factors 7))

;; The prime factors of 8
(expect [2 2 2] (prime-factors 8))

;; The prime factors of 9
(expect [3 3] (prime-factors 9))

;; The prime factors of 10
(expect [2 5] (prime-factors 10))

;; The prime factors of 25
(expect [5 5] (prime-factors 25))

;; The prime factors of 21
(expect [3 7] (prime-factors 21))

;; The prime factors of 64
(expect [2 2 2 2 2 2] (prime-factors 64))

;; The prime factors of 63
(expect [3 3 7] (prime-factors 63))

;; Largest prime factor of 63
(expect 7 (largest-prime 63))

;; Prime of 5143
(expect 139 (largest-prime 5143))

(largest-prime (/ 600851475143 6857 1471 839))
(prime-factors 71)
(prime-factors 600851475143)
