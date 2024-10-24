(ns web-client.rest-api-test
  (:require
   [ajax.core :as ajax]
   [cljs.core.async :refer [go]]
   [cljs.core.async.interop :refer [<p!]]
   [cljs.test :refer-macros [deftest testing is async]]
   [re-frame.core  :refer [reg-event-db reg-event-fx reg-sub dispatch-sync reg-sub subscribe]]
   [web-client.events :as events]
   [web-client.test-utils :refer [wait]]))

(defn http-handler [{:keys [db]} _]
  {:db (assoc db :is-loading true)
   :http-xhrio {:method :get
                :uri "https://api.github.com/orgs/day8"
                :response-format (ajax/json-response-format {:keywords? true})
                :on-success [::good-http-result]
                :on-failure [::bad-http-result]}})

(reg-event-fx ::handler-with-http http-handler)

(reg-event-db
  ::good-http-result
  (fn [db [_ result]]
    (assoc db :is-loading false :success-http-result result)))

(reg-event-db
  ::bad-http-result
  (fn [db [_ result]]
    ;; result is a map containing details of the failure
    (assoc db :is-loading false :failure-http-result result)))

(reg-sub
 ::success-http-result
 (fn [db _]
   (:success-http-result db)))

(reg-sub
 ::is-loading
 (fn [db _]
   (:is-loading db)))


(deftest http-test
  (testing "public api test"
    (dispatch-sync [::events/initialize-db])
    (dispatch-sync [::handler-with-http])

    (async done
      (go
        (<p! (wait (fn [] @(subscribe [::is-loading])) false))

        (is (= false @(subscribe [::is-loading])))
        (is (= "https://github.com/day8" (:html_url @(subscribe [::success-http-result]))))
        (done)))
    ))
