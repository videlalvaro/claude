(ns claude.core
  (:use [clojure.data.json :only [read-json]]))

(defn get-vcap-env []
  (System/getenv "VCAP_SERVICES"))

(defn get-vcap-services []
  (if-let [services (get-vcap-env)]
    (read-json services false)))

(defn cloudfoundry? []
  (not (nil? (get-vcap-env))))

(defn service-config [label key]
    (let [services-dict (get-vcap-services)]
      (-> services-dict
          (get label)
          first ;; maybe in the future allow to use multiple services
          (get "credentials")
          (get key))))

(defn services-labels []
  (keys (get-vcap-services)))

(defmacro service-value [service key]
  `(defn ~(symbol key) [] (service-config ~service ~key)))

(defmacro expose-service [service keys]
  `(do
     ~@(map #(list 'service-value service %) keys)))