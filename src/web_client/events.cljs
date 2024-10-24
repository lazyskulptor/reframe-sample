(ns web-client.events
  (:require
   [re-frame.core :refer [reg-event-db reg-event-fx]]
   [ajax.core :as ajax]
   [web-client.db :as db]
   [day8.re-frame.tracing :refer-macros [fn-traced]]
   ))

(defrecord SigninDTO [username password])
(defrecord SigninVM [username username-err password-err])

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

(defn base-req [path s f]
  {:uri (str "" path)
   :timeout 5000
   :response-format (ajax/json-response-format {:keywords? true})
   :on-success s
   :on-failure f})

(defn post-req [params req]
  (assoc req :method :post :params params))

(reg-event-fx
  ::signin
  (fn-traced [{:keys [db]} [_ username password]]
             {:db (assoc db :is-loading true)
              :http-xhrio (post-req
                           (->SigninDTO username password)
                           (base-req "" [::signin-response] [::signin-failure]))}))

(reg-event-fx
  ::signin-response
  (fn [{:keys [db]} [_ result]]
    {:db (assoc db :is-loading false :token (:token result))
     :fx [[:dispatch ::navigate :home]]}))

(reg-event-db
  ::signin-failure
  (fn [db [_ result]]
    (assoc db :is-loading false :view-model (map->SigninVM result))))

