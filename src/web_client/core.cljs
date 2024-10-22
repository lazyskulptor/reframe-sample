(ns web-client.core
  (:require
   [reagent.dom :as rdom]
   [re-frame.core :as re-frame]
   [web-client.events :as events]
   [web-client.routes :as routes]
   [web-client.subs :as subs]
   [web-client.views]
   [web-client.config :as config]
   ))

(defn- main-panel []
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
    (routes/panels @active-panel)))

(defn dev-setup []
  (when config/debug?
    (println "dev mode")))

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
