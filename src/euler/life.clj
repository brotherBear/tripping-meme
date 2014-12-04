;; cell
[1 2]

;; World
(def world #{ [1 0] [1 1] [1 2]})

;; compute neighbors of a cell
(defn neighbors [[x y]]
  (for [dx [-1 0 1]
        dy (if (zero? dx)
             [-1 1]
             [-1 0 1])]
    [(+ x dx) (+ y dy)]))

(neighbors [1 1])


(def blinker world)

(map neighbors blinker)

(mapcat neighbors blinker)

(frequencies (mapcat neighbors blinker))

(defn live [n alive?]
  (or (= n 3)
      (and (= n 2) alive?)))

(live 2 false)
(live 3 false)
(live 2 true)
(live 0 true)

;; putting it all together

(defn step [world]
  (set
   (for [ [cell n] (frequencies (mapcat neighbors world))
          :when (live n (world cell))]
     cell)))

(step blinker)
(step (step blinker))
(step (step (step blinker)))


(defn life [initial-world]
  (iterate step initial-world))

(take 5 (life blinker))


(def glider #{[0 1] [1 2] [2 0] [2 1] [2 2]})

(take 5 (life glider))