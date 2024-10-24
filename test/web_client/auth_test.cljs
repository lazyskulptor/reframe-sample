(ns web-client.auth-test
  (:require
   [cljs.test :refer-macros [deftest testing is]]
   [re-frame.registrar :refer [get-handler]]
   [web-client.events :as events]))

(defn event-handler [id]
  (-> (filter #(= :fx-handler (:id %))
              (get-handler :event id))
      first :before))

(defn success-event [interceptor]
  (-> (interceptor {} [])
      :effects :http-xhrio :on-success first))

(defn failure-event [interceptor]
  (-> (interceptor {} [])
      :effects :http-xhrio :on-failure first))

(deftest auth-events
  (testing "sequence of events"
    (let [f (event-handler ::events/signin)]
      (is (= ::events/signin-response (success-event f)))
      (is (= ::events/signin-failure (failure-event f)))
      (is (instance? events/SigninDTO (-> (f {} []) :effects :http-xhrio :params))))

    (let [f (event-handler ::events/signin-response)]
      (is (= [:dispatch ::events/navigate :home] (-> (f {} []) :effects :fx first))))
    ))

