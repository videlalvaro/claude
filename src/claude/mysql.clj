(ns claude.mysql
  (:use claude.core)
  (:refer-clojure :exclude [name]))

(expose-service "mysql-5.1"
                ["name" "hostname" "host" "port" "user"
                 "username" "password" "db" "url"])