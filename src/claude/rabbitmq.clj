(ns claude.rabbitmq
  (:use claude.core)
  (:refer-clojure :exclude [name]))

(expose-service "rabbitmq-2.4"
                ["name" "hostname" "host" "port" "vhost"
                 "username" "user" "password" "pass" "url"])