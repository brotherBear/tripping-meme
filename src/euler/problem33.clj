;; The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it
;; may incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.

;; We shall consider fractions like, 30/50 = 3/5, to be trivial examples.

;; There are exactly four non-trivial examples of this type of fraction,
;; less than one in value, and containing two digits in the numerator and denominator.

;; If the product of these four fractions is given in its lowest common terms, find the value of the denominator.


;; BAT: consider the following patterns:

;; ab/ac = b/c
;; ab/ca = b/c
;; ab/bc = a/c
;; ab/cb = a/c

;; ac/ab = c/b (fails because c > b)
;; ac/ba = c/b (fails because c > b)
;; ac/bc = a/b
;; ac/cb = a/b

;; ba/ac = b/c
;; ba/ca = b/c
;; ba/bc = a/c
;; ba/cb = a/c

;; bc/ab = c/a (fails because c > a)
;; bc/ba = c/a (fails because c > a)
;; bc/ca = b/a (fails because b > a)
;; bc/ac = b/a (fails because b > a)

;; ca/ab = c/b (fails because c > b)
;; ca/ba = c/b (fails because c > b)
;; ca/bc = a/b
;; ca/cb = a/b

;; cb/ab = c/a (fails because c > a)
;; cb/ba = c/a (fails because c > a)
;; cb/ca = b/a (fails because b > a)
;; cb/ac = b/a (fails because b > a)

;; where each of a/b/c is a digit 1-9 (0 is left out as trivial)
;; also, a/c < 1 AND b/c < 1
;; and a <> b <> c


(def digits (range 1 10))

(defn comb [a b]
  (+ b (* a 10)))


(def sets (for [a digits
                b digits
                c digits
                :when  (< a b c)]
            [a b c ]))

(defn gen-fractions [a b c]
  (let [t (comb a b)
        u (comb b c)
        v (/ t u)
        all #{a b c}]
    (if (and (< v 1)
             (= v (/ a c)))
      v)))


(defn permute [[x y z]]
  (remove nil? [(gen-fractions x y z)
                (gen-fractions y z x)
                (gen-fractions z x y)
                (gen-fractions x z y)
                (gen-fractions z y x)
                (gen-fractions y x z)]))


(time
 (denominator (apply * (flatten (for [v sets]
                                  (permute v))))))

(flatten (for [v sets]
  (permute v)))
