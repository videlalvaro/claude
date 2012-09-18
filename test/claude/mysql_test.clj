(ns claude.mysql-test
  (:use clojure.test
        claude.core)
  (:require [claude.mysql :as cfmy]))

(defn mock-vcap-env []
  (constantly (slurp (clojure.java.io/resource "json/1.json"))))

(deftest mname
  (with-redefs [get-vcap-env (mock-vcap-env)]
    (is (= "test-name"
           (cfmy/name)))
    ))

(deftest hostname
  (with-redefs [get-vcap-env (mock-vcap-env)]
    (is (= "172.30.48.26" (cfmy/hostname)))
    ))

(deftest host
  (with-redefs [get-vcap-env (mock-vcap-env)]
    (is (= "172.30.48.26"
           (cfmy/host)))
    ))

(deftest port
  (with-redefs [get-vcap-env (mock-vcap-env)]
    (is (= 3306
           (cfmy/port)))
    ))

(deftest user
  (with-redefs [get-vcap-env (mock-vcap-env)]
    (is (= "test-username"
           (cfmy/user)))
    ))

(deftest username
  (with-redefs [get-vcap-env (mock-vcap-env)]
    (is (= "test-username"
           (cfmy/username)))
    ))

(deftest password
  (with-redefs [get-vcap-env (mock-vcap-env)]
    (is (= "test-password"
           (cfmy/password)))
    ))