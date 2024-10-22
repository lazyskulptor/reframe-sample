(ns web-client.views
  (:require
   [re-frame.core :as re-frame]
   [web-client.events :as events]
   [web-client.routes :as routes]
   [web-client.home]))

;; about
(defmethod routes/panels :about-panel []
  [:div
   [:h1 "This is the About Page."]

   [:div
    [:a {:on-click #(re-frame/dispatch [::events/navigate :home])}
     "go to Home Page"]]])
