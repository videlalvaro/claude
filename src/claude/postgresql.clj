(ns claude.postgresql
  (:use claude.core)
  (:refer-clojure :exclude [name]))

(expose-service "postgresql-9.0"
                ["name" "host" "hostname" "port" "user" "username" "password"])