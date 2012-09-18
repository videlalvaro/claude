(defproject claude "0.1.0-SNAPSHOT"
  :description "Utilities to connect Clojure apps to Cloud Foundry"
  :url "http://example.com/FIXME"
  :license {:name "Apache 2.0 License"
            :url "http://www.apache.org/licenses/LICENSE-2.0.html"}
  :profiles {:dev {:resource-paths ["test/resources"]}}
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [org.clojure/data.json "0.1.3"]]
  :plugins [[lein-swank "1.4.4"]])
