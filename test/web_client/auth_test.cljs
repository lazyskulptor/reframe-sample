(ns web-client.auth-test
  (:require
   [cljs.spec.alpha :as s]
   [cljs.spec.test.alpha :as stest]
   [cljs.spec.gen.alpha :as gen]
   [clojure.test.check.generators]
   [clojure.test.check]
   [clojure.test.check.properties]
   [cljs.test :refer-macros [deftest testing is]]
   [web-client.reframe-utils :refer [event-handler success-event failure-event exec-body]]
   [web-client.events :as events]
   [web-client.events-spec :as spec]
   ))


(deftest auto-tests
  (testing "generated"
    (is (stest/check `events/rest-req))
    (is (stest/check `events/sign-req))))

(deftest auth-events
  (testing "sequence of events"
    (let [f (event-handler ::events/signin)]
      (is (= ::events/signin-response (success-event f "U" "P")))
      (is (= ::events/signin-failure (failure-event f "" "")))
      (is (s/valid? ::spec/signin-dto (-> (exec-body ["" ""]) f :effects :http-xhrio))))


    (let [f (event-handler ::events/signin-response)]
      (is (= [:dispatch ::events/navigate :home]
             (-> (exec-body {}) f :effects :fx first))))

    (let [f (event-handler ::events/signin-failure)]
      (is (s/valid? :signin-vm/data (-> (exec-body [{:data {:username "HI"}}]) f :effects :db :view-model))))
    ))

