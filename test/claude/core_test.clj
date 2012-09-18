(ns claude.core-test
  (:use clojure.test
        claude.core))

(defn mock-vcap-env []
  (constantly (slurp (clojure.java.io/resource "json/1.json"))))

(deftest is-cloudfoundry-no
  (is (not (claude.core/cloudfoundry?))))

;; alter get-vcap-env to return mock data.
;; maybe this should be moved into its own test macro
(deftest is-cloudfoundry-yes
  (with-redefs [get-vcap-env mock-vcap-env]
    (is (cloudfoundry?))
    ))

(deftest labels
  (with-redefs [get-vcap-env (mock-vcap-env)]
    (is (= '("mongodb-2.0" "postgresql-9.0" "blob-0.51" "mysql-5.1" "rabbitmq-2.4" "redis-2.2")
           (services-labels)))
    ))