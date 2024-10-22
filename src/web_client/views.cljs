(ns web-client.views
  (:require
   [re-frame.core :as re-frame]
   [web-client.events :as events]
   [web-client.home :refer [home-panel]]
   [web-client.routes :as routes]
   [web-client.subs :as subs]))

(defmethod routes/panels :home-panel [] [home-panel])

;; about

(defn about-panel []
  [:div
   [:h1 "This is the About Page."]

   [:div
    [:a {:on-click #(re-frame/dispatch [::events/navigate :home])}
     "go to Home Page"]]])

(defmethod routes/panels :about-panel [] [about-panel])

;; main

(defn main-panel []
  (let [active-panel (re-frame/subscribe [::subs/active-panel])]
    (routes/panels @active-panel)))
