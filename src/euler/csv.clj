(ns euler.csv
  (:require [clojure.string :as str]))

(def csv (slurp "resources/sample.csv"))

(def lines (str/split-lines csv))

(defn make-records [lines]
  (for [l lines]
    ;; Deconstructing the line into fields
    (let [[emp n a t f2013 f2014] (re-seq #"[^;]+" l)]
      {:ansatt emp
       :navn n
       :avdeling a
       :timebank (read-string t)
       :ferie2013 (read-string f2013)
       :ferie2014 (read-string f2014)})))


(def stavanger (filter #(= (:avdeling %) "4441") (make-records (drop 2 lines))))

(def stavanger-med-ferie (filter #(< 0 (:ferie2014 %)) stavanger))

(count stavanger-med-ferie)

(drop 30 stavanger)

(filter #(< 0 (:ferie2013 %)) stavanger)

(for [a (filter #(< 0 (:timebank %)) stavanger)] [(:navn a) (:timebank a)])
