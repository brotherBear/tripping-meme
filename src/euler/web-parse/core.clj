(ns euler.web-parse.core
  (:require [clojure.string :as str]))


(defn localize [localname urn]
  (spit localname
        (slurp urn)))

(localize "resources/bass.html" "http://www.bigbasstabs.com/sixpence_none_the_richer_bass_tabs/kiss_me.html")
