(ns web-client.subs
  (:require
   [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::name
 (fn [db]
   (:name db)))

(re-frame/reg-sub
 ::theme
 (fn [db]
   (:theme (:browser db))))

(re-frame/reg-sub
 ::sidebar
 (fn [db _]
   (:sidebar db)))


(re-frame/reg-sub
 ::active-panel
 (fn [db _]
   (:active-panel db)))

