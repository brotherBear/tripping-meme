(ns euler.problem4-test
  (:require [expectations :refer :all]
            [euler.problem4 :refer :all]))

;; Flip a couple of numbers
(expect 242 (flip 242))
(expect 245 (flip 542))

;; Strip leading zero from flip result
(expect 23 (flip 320))
(expect 10201 (flip 10201))
(expect 7 (flip 70000))

;; 98 is not a palindrome
(expect false (is-palindrome? 98))

;; 99 is a palindrome
(expect true (is-palindrome? 99))

;; 141 is a palindrome
(expect true (is-palindrome? 141))

(expect 906609 (apply max (filter #(is-palindrome? %) products)))
