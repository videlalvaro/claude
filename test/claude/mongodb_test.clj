(ns claude.mongodb-test
  (:use clojure.test
        claude.core)
  (:require [claude.mongodb :as cfm]))

(defn mock-vcap-env []
  (constantly (slurp (clojure.java.io/resource "json/1.json"))))

(deftest host
  (with-redefs [get-vcap-env (mock-vcap-env)]
    (is (= "172.30.48.66"
           (cfm/host)))
    ))

(deftest port
  (with-redefs [get-vcap-env (mock-vcap-env)]
    (is (= 25186
           (cfm/port)))
    ))

(deftest username
  (with-redefs [get-vcap-env (mock-vcap-env)]
    (is (= "test-username"
           (cfm/username)))
    ))

(deftest password
  (with-redefs [get-vcap-env (mock-vcap-env)]
    (is (= "test-password"
           (cfm/password)))
    ))

(deftest mname
  (with-redefs [get-vcap-env (mock-vcap-env)]
    (is (= "test-name"
           (cfm/name)))
    ))

(deftest db
  (with-redefs [get-vcap-env (mock-vcap-env)]
    (is (= "db"
           (cfm/db)))
    ))

(deftest hostname
  (with-redefs [get-vcap-env (mock-vcap-env)]
    (is (= "172.30.48.66" (cfm/hostname)))
    ))

(deftest url
  (with-redefs [get-vcap-env (mock-vcap-env)]
    (is (= "mongodb://test-username:test-password@172.30.48.66:25186/db"
           (cfm/url)))
    ))