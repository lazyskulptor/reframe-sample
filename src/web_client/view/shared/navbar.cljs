(ns web-client.view.shared.navbar
  (:require
   [web-client.base.layout :as l]
   [web-client.base.component :refer [l-btn hide-overflow]]))

(defn- email [] (l-btn "#" "email" "fad fa-envelope-open-text"))

(defn- reply [] (l-btn "#" "comment" "fa-comments-alt"))

(defn- todo [] (l-btn "#" "" "fa-check-circle"))

(defn- calendar [] (l-btn "#" "email" "fa-calendar-exclamation"))

(defn- profile []
  [:div
   {:class "dropdown relative md:static"}
   [:button
    {:class
     "menu-btn focus:outline-none focus:shadow-outline flex flex-wrap items-center"}
    [:div
     {:class "w-8 h-8 overflow-hidden rounded-full"}
     [:img
      {:class "w-full h-full object-cover", :src "img/user.svg"}]]
    [:div
     {:class "ml-2 capitalize flex"}
     [:h1
      {:class
       "text-sm text-gray-800 font-semibold m-0 p-0 leading-none"}
      "moeSaid"]
     [:i {:class "fad fa-chevron-down ml-2 text-xs leading-none"}]]]

   [hide-overflow]

   [:div
    {:class
     "text-gray-500 menu hidden md:mt-10 md:w-full rounded bg-white shadow-md absolute z-20 right-0 w-40 mt-5 py-2 animated faster"}
    (comment "item")
    [:a
     {:class
      "px-4 py-2 block capitalize font-medium text-sm tracking-wide bg-white hover:bg-gray-200 hover:text-gray-900 transition-all duration-300 ease-in-out",
      :href "#"}
     [:i {:class "fad fa-user-edit text-xs mr-1"}]
     "edit my profile"]
    (comment "end item")
    (comment "item")
    [:a
     {:class
      "px-4 py-2 block capitalize font-medium text-sm tracking-wide bg-white hover:bg-gray-200 hover:text-gray-900 transition-all duration-300 ease-in-out",
      :href "#"}
     [:i {:class "fad fa-inbox-in text-xs mr-1"}]
     "my inbox"]
    (comment "end item")
    (comment "item")
    [:a
     {:class
      "px-4 py-2 block capitalize font-medium text-sm tracking-wide bg-white hover:bg-gray-200 hover:text-gray-900 transition-all duration-300 ease-in-out",
      :href "#"}
     [:i {:class "fad fa-badge-check text-xs mr-1"}]
     "tasks"]
    (comment "end item")
    (comment "item")
    [:a
     {:class
      "px-4 py-2 block capitalize font-medium text-sm tracking-wide bg-white hover:bg-gray-200 hover:text-gray-900 transition-all duration-300 ease-in-out",
      :href "#"}
     [:i {:class "fad fa-comment-alt-dots text-xs mr-1"}]
     "chats"]
    (comment "end item")
    [:hr]
    (comment "item")
    [:a
     {:class
      "px-4 py-2 block capitalize font-medium text-sm tracking-wide bg-white hover:bg-gray-200 hover:text-gray-900 transition-all duration-300 ease-in-out",
      :href "#"}
     [:i {:class "fad fa-user-times text-xs mr-1"}]
     "log out"]
    (comment "end item")]])

(defn- notifications []
  [:div
   {:class "dropdown relative mr-5 md:static"}
   [:button
    {:class
     "text-gray-500 menu-btn p-0 m-0 hover:text-gray-900 focus:text-gray-900 focus:outline-none transition-all ease-in-out duration-300"}
    [:i {:class "fad fa-bells"}]]

   [hide-overflow]

   [:div
    {:class
     "menu hidden rounded bg-white md:right-0 md:w-full shadow-md absolute z-20 right-0 w-84 mt-5 py-2 animated faster"}
    (comment "top")
    [:div
     {:class
      "px-4 py-2 flex flex-row justify-between items-center capitalize font-semibold text-sm"}
     [:h1 "notifications"]
     [:div
      {:class
       "bg-teal-100 border border-teal-200 text-teal-500 text-xs rounded px-1"}
      [:strong "5"]]]
    [:hr]
    (comment "end top")
    (comment "body")
    (comment "item")
    [:a
     {:class
      "flex flex-row items-center justify-start px-4 py-4 block capitalize font-medium text-sm tracking-wide bg-white hover:bg-gray-200 transition-all duration-300 ease-in-out",
      :href "#"}
     [:div
      {:class
       "px-3 py-2 rounded mr-3 bg-gray-100 border border-gray-300"}
      [:i {:class "fad fa-birthday-cake text-sm"}]]
     [:div
      {:class "flex-1 flex flex-rowbg-green-100"}
      [:div
       {:class "flex-1"}
       [:h1 {:class "text-sm font-semibold"} "poll.."]
       [:p {:class "text-xs text-gray-500"} "text here also"]]
      [:div
       {:class "text-right text-xs text-gray-500"}
       [:p "4 min ago"]]]]
    [:hr]
    (comment "end item")
    (comment "item")
    [:a
     {:class
      "flex flex-row items-center justify-start px-4 py-4 block capitalize font-medium text-sm tracking-wide bg-white hover:bg-gray-200 transition-all duration-300 ease-in-out",
      :href "#"}
     [:div
      {:class
       "px-3 py-2 rounded mr-3 bg-gray-100 border border-gray-300"}
      [:i {:class "fad fa-user-circle text-sm"}]]
     [:div
      {:class "flex-1 flex flex-rowbg-green-100"}
      [:div
       {:class "flex-1"}
       [:h1 {:class "text-sm font-semibold"} "mohamed.."]
       [:p {:class "text-xs text-gray-500"} "text here also"]]
      [:div
       {:class "text-right text-xs text-gray-500"}
       [:p "78 min ago"]]]]
    [:hr]
    (comment "end item")
    (comment "item")
    [:a
     {:class
      "flex flex-row items-center justify-start px-4 py-4 block capitalize font-medium text-sm tracking-wide bg-white hover:bg-gray-200 transition-all duration-300 ease-in-out",
      :href "#"}
     [:div
      {:class
       "px-3 py-2 rounded mr-3 bg-gray-100 border border-gray-300"}
      [:i {:class "fad fa-images text-sm"}]]
     [:div
      {:class "flex-1 flex flex-rowbg-green-100"}
      [:div
       {:class "flex-1"}
       [:h1 {:class "text-sm font-semibold"} "new imag.."]
       [:p {:class "text-xs text-gray-500"} "text here also"]]
      [:div
       {:class "text-right text-xs text-gray-500"}
       [:p "65 min ago"]]]]
    [:hr]
    (comment "end item")
    (comment "item")
    [:a
     {:class
      "flex flex-row items-center justify-start px-4 py-4 block capitalize font-medium text-sm tracking-wide bg-white hover:bg-gray-200 transition-all duration-300 ease-in-out",
      :href "#"}
     [:div
      {:class
       "px-3 py-2 rounded mr-3 bg-gray-100 border border-gray-300"}
      [:i {:class "fad fa-alarm-exclamation text-sm"}]]
     [:div
      {:class "flex-1 flex flex-rowbg-green-100"}
      [:div
       {:class "flex-1"}
       [:h1 {:class "text-sm font-semibold"} "time is up.."]
       [:p {:class "text-xs text-gray-500"} "text here also"]]
      [:div
       {:class "text-right text-xs text-gray-500"}
       [:p "1 min ago"]]]]
    (comment "end item")
    (comment "end body")
    (comment "bottom")
    [:hr]
    [:div
     {:class "px-4 py-2 mt-2"}
     [:a
      {:href "#",
       :class
       "border border-gray-300 block text-center text-xs uppercase rounded p-1 hover:text-teal-500 transition-all ease-in-out duration-500"}
      "view all"]]
    (comment "end bottom")]])

(defmethod l/left-nav-items :default []
  (fn []
    [:div
     {:class
      "text-gray-600 md:w-full md:flex md:flex-row md:justify-evenly md:pb-10 md:mb-10 md:border-b md:border-gray-200"}
     [email] [reply] [todo] [calendar]]))

(defmethod l/right-nav-items :default []
  (fn []
    [:div
     {:class "flex flex-row-reverse items-center"}
     [profile]
     [notifications]]))
