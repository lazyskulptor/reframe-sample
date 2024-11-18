(ns web-client.events.auth 
  (:require
   [re-frame.core :refer [reg-event-db reg-event-fx]]
   [day8.re-frame.tracing :refer-macros [fn-traced]]
   [web-client.events.core :as c]))

;;; Sign in 
(defn signin-req [{:keys [db]} [_ {:keys [username password]}]]
  {:db (assoc db :is-loading true)
   :http-xhrio (c/rest-req :signin :post [::authenticated] [::signin-failure]
                         {:username username :password password})})


(defn signin-fail [db [_ {:keys [data]}]]
  (assoc db :is-loading false :view-model
           {:username (:username data)
            :username-err (:username-err data)
            :password-err (:password-err data)}))


(reg-event-fx ::signin signin-req)
(reg-event-db ::signin-failure signin-fail)


;;; Sign Up
(defn signup-req [{:keys [db]} [_ {:keys [username password pwd-confirm email name phone]}]]
  {:db (assoc db :is-loading true)
   :http-xhrio
   (c/rest-req :signup :post [::authenticated] [::signup-failure]
               {:username username
             :password password
             :email email
             :name name
             :phone phone})})


(defn signup-fail [db [_ {:keys [data]}]]
  (assoc db :is-loading false :view-model
           {:username (:username data)
            :username-err (:username-err data)
            :password-err (:password-err data)}))


(reg-event-fx ::signup signup-req)
(reg-event-db ::signup-failure signup-fail)


(defn authenticated [{:keys [db]} [_ {:keys [data]}]]
  {:db (assoc db :is-loading false :token (:token data))
   :fx [[:dispatch ::c/navigate :home]]})

(reg-event-fx ::authenticated authenticated)
