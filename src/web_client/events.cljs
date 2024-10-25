(ns web-client.events
  (:require
   [re-frame.core :refer [reg-event-db reg-event-fx]]
   [ajax.core :as ajax]
   [web-client.db :as db]
   [day8.re-frame.tracing :refer-macros [fn-traced]]
   ))

(defn rest-req 
  ([path method on-success on-fail] (rest-req path method on-success on-fail nil))
  ([path method on-success on-fail params]
  (let [template
        {:uri (str "" path)
         :method method
         :timeout 5000
         :response-format (ajax/json-response-format {:keywords? true})
         :on-success on-success
         :on-failure on-fail}]
    (when params
      (assoc template :params params)))))

(reg-event-db
 ::initialize-db
 (fn-traced [_ _]
   db/default-db))

(reg-event-fx
  ::navigate
  (fn-traced [_ [_ handler]]
   {:navigate handler}))

(reg-event-fx
 ::set-active-panel
 (fn-traced [{:keys [db]} [_ active-panel]]
   {:db (assoc db :active-panel active-panel)}))

;;; Sign in 
(defn sign-req [username password]
  (rest-req :signin :post [::signin-response] [::signin-failure]
            {:username username :password password}))

(reg-event-fx
 ::signin
 (fn-traced [{:keys [db]} [_ username password]]
            {:db (assoc db :is-loading true)
             :http-xhrio (sign-req username password)}))

(defn signin-view [res]
  (let [vm (:data res)]
    {:username (:username vm)
     :username-err (:username-err vm)
     :password-err (:password-err vm)}))

(reg-event-fx
 ::signin-response
 (fn [{:keys [db]} [_ result]]
   {:db (assoc db :is-loading false :token (:token result))
    :fx [[:dispatch ::navigate :home]]}))

(reg-event-db
  ::signin-failure
  (fn [db [_ res]]
    (assoc db :is-loading false :view-model (signin-view res))))

