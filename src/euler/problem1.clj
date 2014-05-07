;; Find the sum of all the multiples of 3 or 5 below 1000
(defn numbers-below-n [n] (range 0 n))

(apply +
       (filter #(or(= 0 (mod % 3))
                   (= 0 (mod % 5))) (numbers-below-n 1000)))

