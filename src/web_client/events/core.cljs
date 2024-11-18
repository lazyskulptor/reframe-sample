(ns web-client.events.core
  (:require
   [re-frame.core :refer [reg-event-db reg-event-fx]]
   [ajax.core :as ajax]
   [web-client.db :as db]
   [day8.re-frame.tracing :refer-macros [fn-traced]]
   ))

(defn rest-req 
  ([path method on-success on-fail] (rest-req path method on-success on-fail nil))
  ([path method on-success on-fail params]
  (let [template
        {:uri (str "" path)
         :method method
         :timeout 5000
         :response-format (ajax/json-response-format {:keywords? true})
         :on-success on-success
         :on-failure on-fail}]
    (if params
      (assoc template :params params)
      template))))

(reg-event-db
 ::initialize-db
 (fn-traced [_ _]
   db/default-db))

(reg-event-db
 ::toggle-sidebar
 (fn-traced [db _]
   (assoc-in db [:browser :sidebar] (not (:sidebar (:browser db))))))

(reg-event-db
 ::toggle-theme
 (fn-traced [db _]
            (assoc-in db [:browser :theme]
                      (let [body (.-body js/document)]
                      (if (= (:theme (:browser db)) "dark")
                        (do
                          (.remove (.-classList body) "theme-dark")
                          "light")
                        (do
                          (.add (.-classList body) "theme-dark")
                          "dark"))))))

(reg-event-fx
  ::navigate
  (fn-traced [_ [_ handler]]
   {:navigate handler}))

(reg-event-fx
 ::set-active-panel
 (fn-traced [{:keys [db]} [_ active-panel]]
   {:db (assoc db :active-panel active-panel)}))

