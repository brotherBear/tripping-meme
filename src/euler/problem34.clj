(ns euler.problem34
  (:require [euler.core :refer :all]))

;; 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
;; Find the sum of all numbers which are equal to the sum of the factorial of their digits.
;; Note: as 1! = 1 and 2! = 2 are not sums they are not included.

(defn- fact
  ([n] (fact n 1 1))
  ([n i prod]
   (cond
    (zero? n) 1
    (= n i) (* i prod)
    :else (fact n (inc i) (* prod i)))))

(defn digitize-as-keywords
  [number]
  (map #(keyword (str %))
       (for [d (re-seq #"\d" (str number))]
         (read-string d))))

;; A couple of helper definitions
(def single-digits (range 10))

(def fact-sequence (for [n single-digits] (fact n)))

(def keywords (map #(keyword (str %)) single-digits))

(def mapped-fact (apply hash-map(interleave keywords fact-sequence)))



;; Test whether the number is a 'curious' number (a.k.a. factorion)
(defn curious?
  [number]
  (cond (= number
           (apply + (map #(% mapped-fact) (digitize-as-keywords number)))) true
    :else false))

;; Sum them up..
;; Only multiple digit numbers are of interest.
(apply + (filter #(curious? %) (range 10 100000)))

