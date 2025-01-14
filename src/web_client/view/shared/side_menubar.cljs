(ns web-client.view.shared.side-menubar
  (:require
   [reagent.core :as r]
   [re-frame.core :refer [subscribe dispatch]]
   [web-client.base.layout :as l]))

(defn submenu [visible]
  [:ul
   {;; :x-transition:enter "transition-all ease-in-out duration-300",
    ;; :x-transition:enter-start "opacity-25 max-h-0",
    ;; :x-transition:enter-end "opacity-100 max-h-xl",
    ;; :x-transition:leave "transition-all ease-in-out duration-300",
    ;; :x-transition:leave-start "opacity-100 max-h-xl",
    ;; :x-transition:leave-end "opacity-0 max-h-0",
    :class (str (when (not @visible) "hidden ")
                "p-2 mt-2 space-y-2 overflow-hidden text-sm font-medium text-gray-500 rounded-md shadow-inner bg-gray-50 dark:text-gray-400 dark:bg-gray-900"), :aria-label "submenu"}
   [:li
    {:class
     "px-2 py-1 transition-colors duration-150 hover:text-gray-800 dark:hover:text-gray-200"}
    [:a {:class "w-full", :href "pages/login.html"} "Login"]]
   [:li
    {:class
     "px-2 py-1 transition-colors duration-150 hover:text-gray-800 dark:hover:text-gray-200"}
    [:a
     {:class "w-full", :href "pages/create-account.html"}
     "Create account"]]
   [:li
    {:class
     "px-2 py-1 transition-colors duration-150 hover:text-gray-800 dark:hover:text-gray-200"}
    [:a
     {:class "w-full", :href "pages/forgot-password.html"}
     "Forgot password"]]
   [:li
    {:class
     "px-2 py-1 transition-colors duration-150 hover:text-gray-800 dark:hover:text-gray-200"}
    [:a {:class "w-full", :href "pages/404.html"} "404"]]
   [:li
    {:class
     "px-2 py-1 transition-colors duration-150 hover:text-gray-800 dark:hover:text-gray-200"}
    [:a {:class "w-full", :href "pages/blank.html"} "Blank"]]])

(defn menu [active to icon name]
  (fn []
  [:li
   {:class "relative px-6 py-3"}
   (when active
     [:span
      {:class
       "absolute inset-y-0 left-0 w-1 bg-purple-600 rounded-tr-lg rounded-br-lg",
       :aria-hidden "true"}])
   [:a
    {:class (if active
              "inline-flex items-center w-full text-sm font-semibold text-gray-800 transition-colors duration-150 hover:text-gray-800 dark:hover:text-gray-200 dark:text-gray-100"
              "inline-flex items-center w-full text-sm font-semibold transition-colors duration-150 hover:text-gray-800 dark:hover:text-gray-200"),
     :href to}
    icon
    [:span {:class "ml-4"} name]]]))

(defmethod l/side-menus :default []
  [(menu
       true
       "index.html"
       [:svg
         {:class "w-5 h-5",
          :aria-hidden "true",
          :fill "none",
          :stroke-linecap "round",
          :stroke-linejoin "round",
          :stroke-width "2",
          :viewBox "0 0 24 24",
          :stroke "currentColor"}
         [:path
          {:d
           "M3 12l2-2m0 0l7-7 7 7M5 10v10a1 1 0 001 1h3m10-11l2 2m-2-2v10a1 1 0 01-1 1h-3m-6 0a1 1 0 001-1v-4a1 1 0 011-1h2a1 1 0 011 1v4a1 1 0 001 1m-6 0h6"}]]
       "Dashboard")

      (menu
       false
       "forms.html"
       [:svg
         {:class "w-5 h-5",
          :aria-hidden "true",
          :fill "none",
          :stroke-linecap "round",
          :stroke-linejoin "round",
          :stroke-width "2",
          :viewBox "0 0 24 24",
          :stroke "currentColor"}
         [:path
          {:d
           "M9 5H7a2 2 0 00-2 2v12a2 2 0 002 2h10a2 2 0 002-2V7a2 2 0 00-2-2h-2M9 5a2 2 0 002 2h2a2 2 0 002-2M9 5a2 2 0 012-2h2a2 2 0 012 2m-3 7h3m-3 4h3m-6-4h.01M9 16h.01"}]]
       "Forms")

      (menu
       false
       "cards.html"
       [:svg
         {:class "w-5 h-5",
          :aria-hidden "true",
          :fill "none",
          :stroke-linecap "round",
          :stroke-linejoin "round",
          :stroke-width "2",
          :viewBox "0 0 24 24",
          :stroke "currentColor"}
         [:path
          {:d
           "M19 11H5m14 0a2 2 0 012 2v6a2 2 0 01-2 2H5a2 2 0 01-2-2v-6a2 2 0 012-2m14 0V9a2 2 0 00-2-2M5 11V9a2 2 0 012-2m0 0V5a2 2 0 012-2h6a2 2 0 012 2v2M7 7h10"}]]
       "Cards")

      (menu
       false
       "charts.html"
       [:svg
         {:class "w-5 h-5",
          :aria-hidden "true",
          :fill "none",
          :stroke-linecap "round",
          :stroke-linejoin "round",
          :stroke-width "2",
          :viewBox "0 0 24 24",
          :stroke "currentColor"}
         [:path {:d "M11 3.055A9.001 9.001 0 1020.945 13H11V3.055z"}]
         [:path {:d "M20.488 9H15V3.512A9.025 9.025 0 0120.488 9z"}]]
       "Charts")

      (menu
       false
       "charts.html"
       [:svg
         {:class "w-5 h-5",
          :aria-hidden "true",
          :fill "none",
          :stroke-linecap "round",
          :stroke-linejoin "round",
          :stroke-width "2",
          :viewBox "0 0 24 24",
          :stroke "currentColor"}
         [:path {:d "M11 3.055A9.001 9.001 0 1020.945 13H11V3.055z"}]
         [:path {:d "M20.488 9H15V3.512A9.025 9.025 0 0120.488 9z"}]]
       "Charts")
   (fn []

(let [collapased (r/atom false)]
      [:li
       {:class "relative px-6 py-3"}
         [:button
        {:class
         "inline-flex items-center justify-between w-full text-sm font-semibold transition-colors duration-150 hover:text-gray-800 dark:hover:text-gray-200",
         :on-click #(swap! collapased (fn [_] (not @collapased))),
         :aria-haspopup "true"}
        [:span
         {:class "inline-flex items-center"}
         [:svg
          {:class "w-5 h-5",
           :aria-hidden "true",
           :fill "none",
           :stroke-linecap "round",
           :stroke-linejoin "round",
           :stroke-width "2",
           :viewBox "0 0 24 24",
           :stroke "currentColor"}
          [:path
           {:d
            "M4 5a1 1 0 011-1h14a1 1 0 011 1v2a1 1 0 01-1 1H5a1 1 0 01-1-1V5zM4 13a1 1 0 011-1h6a1 1 0 011 1v6a1 1 0 01-1 1H5a1 1 0 01-1-1v-6zM16 13a1 1 0 011-1h2a1 1 0 011 1v6a1 1 0 01-1 1h-2a1 1 0 01-1-1v-6z"}]]
         [:span {:class "ml-4"} "Pages"]]
        [:svg
         {:class "w-4 h-4",
          :aria-hidden "true",
          :fill "currentColor",
          :viewBox "0 0 20 20"}
         [:path
          {:fill-rule "evenodd",
           :d
           "M5.293 7.293a1 1 0 011.414 0L10 10.586l3.293-3.293a1 1 0 111.414 1.414l-4 4a1 1 0 01-1.414 0l-4-4a1 1 0 010-1.414z",
           :clip-rule "evenodd"}]]]
       [:div
        [submenu collapased]]])

     )

   ])

(defmethod l/action-menus :default []
  [(fn []

     [:div
      {:class "px-6 my-6"}
      [:button
       {:class
        "flex items-center justify-between w-full px-4 py-2 text-sm font-medium leading-5 text-white transition-colors duration-150 bg-purple-600 border border-transparent rounded-lg active:bg-purple-600 hover:bg-purple-700 focus:outline-none focus:shadow-outline-purple"}
       "Create account"
       [:span {:class "ml-2", :aria-hidden "true"} "+"]]])])
