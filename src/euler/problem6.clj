(ns euler.problem6
  (:require [euler.core :refer :all]))



(- (let [s (apply + (take 100 natural-numbers))] (* s s))
   (reduce + (map #(* % %) (take 100 natural-numbers))))


(defn sum-square-difference [coll]
  (let [s (apply + coll)]
    (- (* s s)
       (apply + (map #(* % %) coll)))))

(sum-square-difference (take 100 natural-numbers))
