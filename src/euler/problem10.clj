;; Sum all the primes < 2000000
(def primes
  (concat
   [2 3 5 7]
   (lazy-seq
    (let [primes-from
          (fn primes-from[n [f & r]]
            (if (some #(zero? (rem n %))
                      (take-while #(<= (* % %) n) primes))
              (recur (+ n f) r)
              (lazy-seq (cons n (primes-from (+ n f) r)))))
          wheel (cycle [2 4 2 4 6 2 6 4 2 4 6 6 2 6 4 2
                        6 4 6 8 4 2 4 2 4 8 6 4 6 2 4 6
                        2 6 6 4 2 4 6 2 6 4 2 4 2 10 2 10])]
      (primes-from 11 wheel)))))

;; The solution
(time (reduce + (take-while #(<= % 2000000) primes)))


(def ordinals-and-primes (map vector (iterate inc 1) primes))


(time (take 5 (drop 145000 ordinals-and-primes)))

(time (take 5 (drop 145000 primes)))

