(ns claude.redis
  (:use claude.core)
  (:refer-clojure :exclude [name]))

(expose-service "redis-2.2"
                ["hostname" "host" "port" "password" "name"])