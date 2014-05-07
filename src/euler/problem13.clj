 (def list-of-numbers-as-string (re-seq #"\d+" (slurp "resources/numbers.txt") ))

(reduce + (for [st list-of-numbers-as-string]
  (read-string st)))
