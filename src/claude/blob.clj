(ns claude.blob
  (:use claude.core)
  (:refer-clojure :exclude [name]))

(expose-service "blob-0.51"
                ["hostname" "host" "port" "username" "password" "name"])