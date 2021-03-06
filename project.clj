(defproject euler "0.1.0-SNAPSHOT"
  :description "Collection of solutions for the Project Euler challenges"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/test.check "0.9.0"]
                 [expectations "2.1.9"]]
  :plugins [[lein-autoexpect "1.2.2"]
            [lein-ancient "0.5.5"]])
