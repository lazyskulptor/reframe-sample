(ns web-client.reframe-utils
  (:require
   [re-frame.registrar :refer [get-handler]]))

(defn exec-body [args]
  {:coeffects {:db {} :event (cons nil args)}})

(defn event-handler [id]
  (-> (filter #(or (= :fx-handler (:id %))
                   (= :db-handler (:id %)))
              (get-handler :event id))
      first :before))

(defn success-event [interceptor & args]
  (-> (interceptor (exec-body args))
      :effects :http-xhrio :on-success first))


(defn failure-event [interceptor & args]
  (-> (interceptor (exec-body args))
      :effects :http-xhrio :on-failure first))
