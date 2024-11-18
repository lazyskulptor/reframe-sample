(ns web-client.core
  (:require
   [reagent.dom :as rdom]
   [re-frame.core :as re-frame]
   ;; [day8.re-frame.http-fx]
   [web-client.events.core-spec]
   [web-client.events.core :as events]
   [web-client.subs :as subs]
   [web-client.base.layout :refer [panels]]
   [web-client.routes :as routes]
   [web-client.config :as config]
   ))

(defn- main-panel []
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
    (panels @active-panel)))

(def print-http-fx
  (re-frame.core/->interceptor
   :id :debug-http-fx
   :before (fn [context]
             (let [trim-fn (fn [event] (-> event rest vec))]
               (println context)
               ;; (update-in context [:coeffects :event] trim-fn)
               context))))

(defn dev-setup []
  (when config/debug?
    (println "dev mode"))
  (when config/server-mock?
    (re-frame.core/reg-fx :http-xhrio
                          (fn [value]
                               (println value))))
  (when config/server-mock?
    (re-frame.core/reg-global-interceptor
     print-http-fx)
    (println "mocking")))

(defn ^:dev/after-load mount-root []
  (re-frame/clear-subscription-cache!)
  (let [root-el (.getElementById js/document "app")]
    (rdom/unmount-component-at-node root-el)
    (rdom/render [main-panel] root-el)))

(defn init []
  (routes/start!)
  (re-frame/dispatch-sync [::events/initialize-db])
  (dev-setup)
  (mount-root))
