(ns claude.core
  (:use [clojure.data.json :only [read-json]]))

(defn cloudfoundry? []
  (not (nil? (System/getenv "VCAP_SERVICES"))))

(defn service-config [label key]
  (if-let [services (System/getenv "VCAP_SERVICES")]
    (let [services-dict (read-json services false)]
      (-> services-dict
          (get label)
          first ;; maybe in the future allow to use multiple services
          (get "credentials")
          (get key)))))

(defn mongo-config [key]
  (service-config "mongodb-2.0" key))

(defn rabbit-config [key]
  (service-config "rabbitmq-2.4" key))

(defn redis-config [key]
  (service-config "redis-2.2" key))

(defn mongo-url []
  (mongo-config "url"))

(defn rabbit-url []
  (rabbit-config "url"))