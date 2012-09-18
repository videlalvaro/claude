(ns claude.postgresql-test
  (:use clojure.test
        claude.core)
  (:require [claude.postgresql :as cfp]))

(defn mock-vcap-env []
  (constantly (slurp (clojure.java.io/resource "json/1.json"))))

(deftest pname
  (with-redefs [get-vcap-env (mock-vcap-env)]
    (is (= "test-name"
           (cfp/name)))
    ))

(deftest host
  (with-redefs [get-vcap-env (mock-vcap-env)]
    (is (= "172.30.48.121"
           (cfp/host)))
    ))

(deftest hostname
  (with-redefs [get-vcap-env (mock-vcap-env)]
    (is (= "172.30.48.121"
           (cfp/hostname)))
    ))

(deftest port
  (with-redefs [get-vcap-env (mock-vcap-env)]
    (is (= 5432
           (cfp/port)))
    ))

(deftest user
  (with-redefs [get-vcap-env (mock-vcap-env)]
    (is (= "test-username"
           (cfp/user)))
    ))

(deftest username
  (with-redefs [get-vcap-env (mock-vcap-env)]
    (is (= "test-username"
           (cfp/username)))
    ))

(deftest password
  (with-redefs [get-vcap-env (mock-vcap-env)]
    (is (= "test-password"
           (cfp/password)))
    ))