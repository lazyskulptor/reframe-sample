(ns web-client.home
  (:require
   [re-frame.core :as re-frame]
   [web-client.subs :as subs]))

(defn home-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div {:class "h-screen flex flex-row flex-wrap"}
     [:div {:class "bg-gray-100 flex-1 p-6 md:mt-16"}
      (str "Hello from " @name ". This is the Home Page")]
     ]))
