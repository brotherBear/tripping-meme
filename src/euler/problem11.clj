;; Problem #11 project Euler
;; What is the greatest product of four adjacent numbers in the same direction (up, down, left, right, or diagonally) in the 20×20 grid?
(def grid-numbers
   (slurp "resources/number-grid.txt") )

(def grid (map #(read-string %)(re-seq #"[1-9]\d|\d[ \n]" grid-numbers)))

(apply max (map #(apply * %)
                (apply concat
                       (for [n (partition 20 grid)]
                         (partition 4 1 n)))))

(->> grid
     (partition 4 1)
     (map #(apply * %))
     (apply max))

(partition 4 1 (take-nth 20 grid))
(take-nth 21 (drop 2 grid))
(partition-all 4 1 (drop 1 (take-nth 19 grid)))

(->> grid
     #_(drop 1)
     (take-nth 19)
     (drop 1)
     (partition 4 1))

(take 5 (drop 15 (partition 4 grid)))

