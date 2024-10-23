(ns web-client.view.panels.about
  (:require
   [re-frame.core :as re-frame]
   [web-client.events :as events]
   [web-client.base.layout :as layout]))

(defn- panel []
  [:div
   [:h1 "This is the About Page."]

   [:div
    [:a {:on-click #(re-frame/dispatch [::events/navigate :home])}
     "go to Home Page"]]])

(defmethod layout/panels :about-panel []
  [layout/wrapper panel])
