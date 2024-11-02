(ns web-client.events-spec
  (:require
   [cljs.spec.alpha :as s]
   [web-client.events :as events]
   [ajax.interceptors]))

(def rest-methods #{:get :post})


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

(s/def ::request (s/keys :req-un [::uri ::method ::timeout ::response-format ::on-success ::on-failure]))

(s/def ::response (s/keys :req-un [::code ::path ::message ::queries]))

(s/fdef events/rest-req
  :args (s/cat :path keyword?
               :method ::method
               :on-success ::res-event
               :on-failure ::res-event
               :params (s/or :defined ::params :undefined nil?))

  :fn (s/and #(.startsWith (-> :ret :uri %) "http"))
  :ret ::request)

(s/def ::username string?)
(s/def ::password string?)
(s/def :signin-vm/data (s/keys :req-un [::username ::username-err ::password-err]))
(s/def :signin-dto/params (s/keys :req-un [::username ::password]))

(s/def ::signin-dto (s/merge ::request
                             (s/keys :req-un [:signin-dto/params])))

(s/def ::signin-vm (s/merge ::response
                            (s/keys :opt-un [:signin-vm/data])))

(s/fdef events/sign-req
  :args (s/and (s/cat :username string? :password string?))
  :ret ::signin-dto)

(s/fdef events/signin-view
  :args ::signin-vm
  :ret (s/keys :opt-un [::username ::username-err ::password-err]))

