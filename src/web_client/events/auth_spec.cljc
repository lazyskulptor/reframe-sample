(ns web-client.events.auth-spec
  (:require
   [cljs.spec.alpha :as s]
   [web-client.events.auth :as auth]
   [web-client.events.core-spec :as c]))

;;
;; Sign in
;;
(s/def ::username string?)
(s/def ::password string?)
(s/def ::username-err string?)
(s/def ::password-err string?)

(s/def :signin/on-success (s/cat :first ::auth/authenticated))
(s/def :signin/on-failure (s/cat :first ::auth/signin-failure))
(s/def :signin/params (s/keys :req-un [::username ::password]))

(s/def :signin/http-xhrio
  (c/spec-http :signin/on-success :signin/on-failure :signin/params))

(s/def :signin/view-model
  (s/keys :opt-un [::username ::username-err ::password-err]))

(s/fdef auth/signin-req 
  :args (c/def-param (s/keys :req-un [::username ::password]))
  ;; :fn
  :ret (c/http-ret :signin/http-xhrio))


(s/fdef auth/signin-fail
  :args (c/def-data :signin/view-model)
  :ret (c/db-ret :signin/view-model))


;;
;; Sign up
;;
(s/def ::pwd-confirm ::password)
(s/def ::email string?)
(s/def ::name string?)
(s/def ::phone string?)

(s/def :signup/on-success (s/cat :first ::auth/signup-response))
(s/def :signup/on-failure (s/cat :first ::auth/signup-failure))
(s/def :signup/params (s/keys :opt-un [::username ::password ::email ::name ::phone]))
(s/def :signup/vm (s/merge (s/keys :opt-un [::pwd-confirm]) :signup/params))
(s/def :signup/error-msg :signup/vm)
(s/def :signup/view-model (s/keys :req-un [:signup/vm :signup/error-msg]))

(s/def :signup/http-xhrio
  (c/spec-http :signup/on-success :signup/on-failure :signup/params))

(s/def :signup-fail/fx (s/tuple (s/tuple #{:dispatch} #{::auth/signup-failure} :signup/view-model)))



(s/fdef auth/signup-req
  :args (c/def-param :signup/vm)
  :ret (s/or :success (c/http-ret :signup/http-xhrio)
             :fail (s/keys :req-un [::c/db :signup-fail/fx])))

(s/fdef auth/signup-fail
  :args (c/def-data :signup/view-model)
  :ret (c/db-ret :signup/view-model))

;;
;; commons
;;
(s/def ::token string?)
(s/def :signin/data (s/keys :req-un [::token]))
(s/def :signin/db (s/merge ::c/db :signin/data))
(s/def :signin/fx (s/tuple (c/spec-nav :home)))

(s/fdef auth/authenticated
  :args (c/def-data :signin/data)
  :ret (s/keys :req-un [:signin/db :signin/fx]))
