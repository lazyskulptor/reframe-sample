(ns web-client.events.core-spec
  (:require
   [cljs.spec.alpha :as s]
   [web-client.events.core :as events]
   [ajax.interceptors])
  (:require-macros [web-client.events.core-spec]))

(def rest-methods #{:get :post})
(s/def ::is-loading boolean?)
(s/def ::db (s/keys :req-un [::is-loading]))
(s/def ::ctx (s/keys :req-un [::db]))

(s/def ::res-event (s/and sequential? #(qualified-keyword? (first %))))
(s/def ::uri string?)
(s/def ::method (s/with-gen #(rest-methods %)
                  #(s/gen rest-methods)))
(s/def ::timeout int?)
(s/def ::response-format #(instance? ajax.interceptors.ResponseFormat %))
(s/def ::on-success ::res-event)
(s/def ::on-failure ::res-event)
(s/def ::params map?)

(s/def ::code int?)
(s/def ::path string?)
(s/def ::message string?)
(s/def ::queries map?)

(s/def ::http-xhrio (s/keys :req-un [::uri ::method ::timeout ::response-format]))
(s/def ::request (s/keys :req-un [::uri ::method ::timeout ::response-format ::on-success ::on-failure]))

(s/def ::response (s/keys :req-un [::code ::path ::message ::queries]))

(defn spec-http
  ([success failure] (spec-http success failure nil))
  ([success failure params]
   (s/merge ::http-xhrio
            (if params
              (s/keys :req-un [success failure params])
              (s/keys :req-un [success failure])))))

(s/fdef events/rest-req
  :args (s/cat :path keyword?
               :method ::method
               :on-success ::res-event
               :on-failure ::res-event
               :params (s/or :defined ::params :undefined nil?))

  :fn (s/and #(.startsWith (-> :ret :uri %) "http"))
  :ret ::request)

