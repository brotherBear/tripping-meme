;; Find the greatest product of five consecutive digits in the 1000-digit number.
;; Load the number
(def digits (map #(read-string %)
                 (re-seq #"\d" (slurp "resources/euler1000digit.txt"))))

(time (apply max
       (map #(apply * %)
            (partition 5 1 digits))))

