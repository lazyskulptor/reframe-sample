(ns web-client.home
  (:require
   [re-frame.core :as re-frame]
   [web-client.subs :as subs]))

(defn home-panel []
  [:h1 {:class "text-3xl font-bold underline"}
   "Hello World!"])
