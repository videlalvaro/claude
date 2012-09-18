(ns claude.mongodb
  (:use claude.core)
  (:refer-clojure :exclude [name]))

(expose-service "mongodb-2.0"
                ["host" "port" "username" "password"
                 "name" "db" "hostname" "url"])