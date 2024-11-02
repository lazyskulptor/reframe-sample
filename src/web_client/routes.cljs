(ns web-client.routes
  (:require
   [bidi.bidi :as bidi]
   [pushy.core :as pushy]
   [re-frame.core :as re-frame]
   [web-client.events :as events]
   [web-client.base.layout]
   [web-client.view.shared.header]
   [web-client.view.shared.side-menubar]
   [web-client.view.panels.home]
   [web-client.view.panels.about]
   ))

(def ^:private routes
  (atom
    ["/" {""      :home
          "home" :home
          "about" :about
          }]))

(defn- parse
  [url]
  (bidi/match-route @routes url))

(defn- url-for
  [& args]
  (apply bidi/path-for (into [@routes] args)))

(defn- dispatch
  [route]
  (let [panel (keyword (str (name (:handler route)) "-panel"))]
    (re-frame/dispatch [::events/set-active-panel panel])))

(defonce ^:private history
  (pushy/pushy dispatch parse))

(defn- navigate!
  [handler]
  (pushy/set-token! history (url-for handler)))

(defn start!
  []
  (pushy/start! history))

(re-frame/reg-fx
  :navigate
  (fn [handler]
    (navigate! handler)))
