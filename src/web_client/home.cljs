(ns web-client.home
  (:require
   [re-frame.core :as re-frame]
   [web-client.subs :as subs]))

(defn- navbar []
  [:div
   {:class
    "md:fixed md:w-full md:top-0 md:z-20 flex flex-row flex-wrap items-center bg-white p-6 border-b border-gray-300"}
   (comment "logo")
   [:div
    {:class "flex-none w-56 flex flex-row items-center"}
    [:img {:src "img/logo.png", :class "w-10 flex-none"}]
    [:strong {:class "capitalize ml-1 flex-1"} "cleopatra"]
    [:button
     {:id "sliderBtn",
      :class "flex-none text-right text-gray-900 hidden md:block"}
     [:i {:class "fad fa-list-ul"}]]]
   (comment "end logo")
   (comment "navbar content toggle")
   [:button
    {:id "navbarToggle", :class "hidden md:block md:fixed right-0 mr-6"}
    [:i {:class "fad fa-chevron-double-down"}]]
   (comment "end navbar content toggle")
   (comment "navbar content")
   [:div
    {:id "navbar",
     :class
     "animated md:hidden md:fixed md:top-0 md:w-full md:left-0 md:mt-16 md:border-t md:border-b md:border-gray-200 md:p-10 md:bg-white flex-1 pl-3 flex flex-row flex-wrap justify-between items-center md:flex-col md:items-center"}
    (comment "left")
    [:div
     {:class
      "text-gray-600 md:w-full md:flex md:flex-row md:justify-evenly md:pb-10 md:mb-10 md:border-b md:border-gray-200"}
     [:a
      {:class
       "mr-2 transition duration-500 ease-in-out hover:text-gray-900",
       :href "#",
       :title "email"}
      [:i {:class "fad fa-envelope-open-text"}]]
     [:a
      {:class
       "mr-2 transition duration-500 ease-in-out hover:text-gray-900",
       :href "#",
       :title "email"}
      [:i {:class "fad fa-comments-alt"}]]
     [:a
      {:class
       "mr-2 transition duration-500 ease-in-out hover:text-gray-900",
       :href "#",
       :title "email"}
      [:i {:class "fad fa-check-circle"}]]
     [:a
      {:class
       "mr-2 transition duration-500 ease-in-out hover:text-gray-900",
       :href "#",
       :title "email"}
      [:i {:class "fad fa-calendar-exclamation"}]]]
    (comment "end left")
    (comment "right")
    [:div
     {:class "flex flex-row-reverse items-center"}
     (comment "user")
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
      [:button
       {:class
        "hidden fixed top-0 left-0 z-10 w-full h-full menu-overflow"}]
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
       (comment "end item")]]
     (comment "end user")
     (comment "notifcation")
     [:div
      {:class "dropdown relative mr-5 md:static"}
      [:button
       {:class
        "text-gray-500 menu-btn p-0 m-0 hover:text-gray-900 focus:text-gray-900 focus:outline-none transition-all ease-in-out duration-300"}
       [:i {:class "fad fa-bells"}]]
      [:button
       {:class
        "hidden fixed top-0 left-0 z-10 w-full h-full menu-overflow"}]
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
       (comment "end bottom")]]
     (comment "end notifcation")
     (comment "messages")
     [:div
      {:class "dropdown relative mr-5 md:static"}
      [:button
       {:class
        "text-gray-500 menu-btn p-0 m-0 hover:text-gray-900 focus:text-gray-900 focus:outline-none transition-all ease-in-out duration-300"}
       [:i {:class "fad fa-comments"}]]
      [:button
       {:class
        "hidden fixed top-0 left-0 z-10 w-full h-full menu-overflow"}]
      [:div
       {:class
        "menu hidden md:w-full md:right-0 rounded bg-white shadow-md absolute z-20 right-0 w-84 mt-5 py-2 animated faster"}
       (comment "top")
       [:div
        {:class
         "px-4 py-2 flex flex-row justify-between items-center capitalize font-semibold text-sm"}
        [:h1 "messages"]
        [:div
         {:class
          "bg-teal-100 border border-teal-200 text-teal-500 text-xs rounded px-1"}
         [:strong "3"]]]
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
          "w-10 h-10 rounded-full overflow-hidden mr-3 bg-gray-100 border border-gray-300"}
         [:img
          {:class "w-full h-full object-cover",
           :src "img/user1.jpg",
           :alt ""}]]
        [:div
         {:class "flex-1 flex flex-rowbg-green-100"}
         [:div
          {:class "flex-1"}
          [:h1 {:class "text-sm font-semibold"} "mohamed said"]
          [:p {:class "text-xs text-gray-500"} "yeah i know"]]
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
          "w-10 h-10 rounded-full overflow-hidden mr-3 bg-gray-100 border border-gray-300"}
         [:img
          {:class "w-full h-full object-cover",
           :src "img/user2.jpg",
           :alt ""}]]
        [:div
         {:class "flex-1 flex flex-rowbg-green-100"}
         [:div
          {:class "flex-1"}
          [:h1 {:class "text-sm font-semibold"} "sull goldmen"]
          [:p {:class "text-xs text-gray-500"} "for sure"]]
         [:div
          {:class "text-right text-xs text-gray-500"}
          [:p "1 day ago"]]]]
       [:hr]
       (comment "end item")
       (comment "item")
       [:a
        {:class
         "flex flex-row items-center justify-start px-4 py-4 block capitalize font-medium text-sm tracking-wide bg-white hover:bg-gray-200 transition-all duration-300 ease-in-out",
         :href "#"}
        [:div
         {:class
          "w-10 h-10 rounded-full overflow-hidden mr-3 bg-gray-100 border border-gray-300"}
         [:img
          {:class "w-full h-full object-cover",
           :src "img/user3.jpg",
           :alt ""}]]
        [:div
         {:class "flex-1 flex flex-rowbg-green-100"}
         [:div
          {:class "flex-1"}
          [:h1 {:class "text-sm font-semibold"} "mick"]
          [:p {:class "text-xs text-gray-500"} "is typing ...."]]
         [:div
          {:class "text-right text-xs text-gray-500"}
          [:p "31 feb"]]]]
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
       (comment "end bottom")]]
     (comment "end messages")]
    (comment "end right")]
   (comment "end navbar content")])

(defn- wrapper []
  [:div
   {:class "h-screen flex flex-row flex-wrap"}
   (comment "start sidebar")
   [:div
    {:id "sideBar",
     :class
     "relative flex flex-col flex-wrap bg-white border-r border-gray-300 p-6 flex-none w-64 md:-ml-64 md:fixed md:top-0 md:z-30 md:h-screen md:shadow-xl animated faster"}
    (comment "sidebar content")
    [:div
     {:class "flex flex-col"}
     (comment "sidebar toggle")
     [:div
      {:class "text-right hidden md:block mb-4"}
      [:button
       {:id "sideBarHideBtn"}
       [:i {:class "fad fa-times-circle"}]]]
     (comment "end sidebar toggle")
     [:p
      {:class "uppercase text-xs text-gray-600 mb-4 tracking-wider"}
      "homes"]
     (comment "link")
     [:a
      {:href "./index.html",
       :class
       "mb-3 capitalize font-medium text-sm hover:text-teal-600 transition ease-in-out duration-500"}
      [:i {:class "fad fa-chart-pie text-xs mr-2"}]
      "Analytics dashboard"]
     (comment "end link")
     (comment "link")
     [:a
      {:href "./index-1.html",
       :class
       "mb-3 capitalize font-medium text-sm hover:text-teal-600 transition ease-in-out duration-500"}
      [:i {:class "fad fa-shopping-cart text-xs mr-2"}]
      "ecommerce dashboard"]
     (comment "end link")
     [:p
      {:class "uppercase text-xs text-gray-600 mb-4 mt-4 tracking-wider"}
      "apps"]
     (comment "link")
     [:a
      {:href "./email.html",
       :class
       "mb-3 capitalize font-medium text-sm hover:text-teal-600 transition ease-in-out duration-500"}
      [:i {:class "fad fa-envelope-open-text text-xs mr-2"}]
      "email"]
     (comment "end link")
     (comment "link")
     [:a
      {:href "#",
       :class
       "mb-3 capitalize font-medium text-sm hover:text-teal-600 transition ease-in-out duration-500"}
      [:i {:class "fad fa-comments text-xs mr-2"}]
      "chat"]
     (comment "end link")
     (comment "link")
     [:a
      {:href "#",
       :class
       "mb-3 capitalize font-medium text-sm hover:text-teal-600 transition ease-in-out duration-500"}
      [:i {:class "fad fa-shield-check text-xs mr-2"}]
      "todo"]
     (comment "end link")
     (comment "link")
     [:a
      {:href "#",
       :class
       "mb-3 capitalize font-medium text-sm hover:text-teal-600 transition ease-in-out duration-500"}
      [:i {:class "fad fa-calendar-edit text-xs mr-2"}]
      "calendar"]
     (comment "end link")
     (comment "link")
     [:a
      {:href "#",
       :class
       "mb-3 capitalize font-medium text-sm hover:text-teal-600 transition ease-in-out duration-500"}
      [:i {:class "fad fa-file-invoice-dollar text-xs mr-2"}]
      "invoice"]
     (comment "end link")
     (comment "link")
     [:a
      {:href "#",
       :class
       "mb-3 capitalize font-medium text-sm hover:text-teal-600 transition ease-in-out duration-500"}
      [:i {:class "fad fa-folder-open text-xs mr-2"}]
      "file manager"]
     (comment "end link")
     [:p
      {:class "uppercase text-xs text-gray-600 mb-4 mt-4 tracking-wider"}
      "UI Elements"]
     (comment "link")
     [:a
      {:href "./typography.html",
       :class
       "mb-3 capitalize font-medium text-sm hover:text-teal-600 transition ease-in-out duration-500"}
      [:i {:class "fad fa-text text-xs mr-2"}]
      "typography"]
     (comment "end link")
     (comment "link")
     [:a
      {:href "./alert.html",
       :class
       "mb-3 capitalize font-medium text-sm hover:text-teal-600 transition ease-in-out duration-500"}
      [:i {:class "fad fa-whistle text-xs mr-2"}]
      "alerts"]
     (comment "end link")
     (comment "link")
     [:a
      {:href "./buttons.html",
       :class
       "mb-3 capitalize font-medium text-sm hover:text-teal-600 transition ease-in-out duration-500"}
      [:i {:class "fad fa-cricket text-xs mr-2"}]
      "buttons"]
     (comment "end link")
     (comment "link")
     [:a
      {:href "#",
       :class
       "mb-3 capitalize font-medium text-sm hover:text-teal-600 transition ease-in-out duration-500"}
      [:i {:class "fad fa-box-open text-xs mr-2"}]
      "Content"]
     (comment "end link")
     (comment "link")
     [:a
      {:href "#",
       :class
       "mb-3 capitalize font-medium text-sm hover:text-teal-600 transition ease-in-out duration-500"}
      [:i {:class "fad fa-swatchbook text-xs mr-2"}]
      "colors"]
     (comment "end link")
     (comment "link")
     [:a
      {:href "#",
       :class
       "mb-3 capitalize font-medium text-sm hover:text-teal-600 transition ease-in-out duration-500"}
      [:i {:class "fad fa-atom-alt text-xs mr-2"}]
      "icons"]
     (comment "end link")
     (comment "link")
     [:a
      {:href "#",
       :class
       "mb-3 capitalize font-medium text-sm hover:text-teal-600 transition ease-in-out duration-500"}
      [:i {:class "fad fa-club text-xs mr-2"}]
      "card"]
     (comment "end link")
     (comment "link")
     [:a
      {:href "#",
       :class
       "mb-3 capitalize font-medium text-sm hover:text-teal-600 transition ease-in-out duration-500"}
      [:i {:class "fad fa-cheese-swiss text-xs mr-2"}]
      "Widgets"]
     (comment "end link")
     (comment "link")
     [:a
      {:href "#",
       :class
       "mb-3 capitalize font-medium text-sm hover:text-teal-600 transition ease-in-out duration-500"}
      [:i {:class "fad fa-computer-classic text-xs mr-2"}]
      "Components"]
     (comment "end link")]
    (comment "end sidebar content")]
   (comment "end sidbar")
   (comment "strat content")
   [:div
    {:class "bg-gray-100 flex-1 p-6 md:mt-16"}
    (comment "General Report")
    [:div
     {:class "grid grid-cols-4 gap-6 xl:grid-cols-1"}
     (comment "card")
     [:div
      {:class "report-card"}
      [:div
       {:class "card"}
       [:div
        {:class "card-body flex flex-col"}
        (comment "top")
        [:div
         {:class "flex flex-row justify-between items-center"}
         [:div {:class "h6 text-indigo-700 fad fa-shopping-cart"}]
         [:span
          {:class "rounded-full text-white badge bg-teal-400 text-xs"}
          "12%"
          [:i {:class "fal fa-chevron-up ml-1"}]]]
        (comment "end top")
        (comment "bottom")
        [:div
         {:class "mt-8"}
         [:h1 {:class "h5 num-4"}]
         [:p "items sales"]]
        (comment "end bottom")]]
      [:div
       {:class
        "footer bg-white p-1 mx-4 border border-t-0 rounded rounded-t-none"}]]
     (comment "end card")
     (comment "card")
     [:div
      {:class "report-card"}
      [:div
       {:class "card"}
       [:div
        {:class "card-body flex flex-col"}
        (comment "top")
        [:div
         {:class "flex flex-row justify-between items-center"}
         [:div {:class "h6 text-red-700 fad fa-store"}]
         [:span
          {:class "rounded-full text-white badge bg-red-400 text-xs"}
          "6%"
          [:i {:class "fal fa-chevron-down ml-1"}]]]
        (comment "end top")
        (comment "bottom")
        [:div
         {:class "mt-8"}
         [:h1 {:class "h5 num-4"}]
         [:p "new orders"]]
        (comment "end bottom")]]
      [:div
       {:class
        "footer bg-white p-1 mx-4 border border-t-0 rounded rounded-t-none"}]]
     (comment "end card")
     (comment "card")
     [:div
      {:class "report-card"}
      [:div
       {:class "card"}
       [:div
        {:class "card-body flex flex-col"}
        (comment "top")
        [:div
         {:class "flex flex-row justify-between items-center"}
         [:div {:class "h6 text-yellow-600 fad fa-sitemap"}]
         [:span
          {:class "rounded-full text-white badge bg-teal-400 text-xs"}
          "72%"
          [:i {:class "fal fa-chevron-up ml-1"}]]]
        (comment "end top")
        (comment "bottom")
        [:div
         {:class "mt-8"}
         [:h1 {:class "h5 num-4"}]
         [:p "total Products"]]
        (comment "end bottom")]]
      [:div
       {:class
        "footer bg-white p-1 mx-4 border border-t-0 rounded rounded-t-none"}]]
     (comment "end card")
     (comment "card")
     [:div
      {:class "report-card"}
      [:div
       {:class "card"}
       [:div
        {:class "card-body flex flex-col"}
        (comment "top")
        [:div
         {:class "flex flex-row justify-between items-center"}
         [:div {:class "h6 text-green-700 fad fa-users"}]
         [:span
          {:class "rounded-full text-white badge bg-teal-400 text-xs"}
          "150%"
          [:i {:class "fal fa-chevron-up ml-1"}]]]
        (comment "end top")
        (comment "bottom")
        [:div
         {:class "mt-8"}
         [:h1 {:class "h5 num-4"}]
         [:p "new Visitor"]]
        (comment "end bottom")]]
      [:div
       {:class
        "footer bg-white p-1 mx-4 border border-t-0 rounded rounded-t-none"}]]
     (comment "end card")]
    (comment "End General Report")
    (comment "strat Analytics")
    [:div
     {:class "mt-6 grid grid-cols-2 gap-6 xl:grid-cols-1"}
     (comment "update section")
     [:div
      {:class "card bg-teal-400 border-teal-400 shadow-md text-white"}
      [:div
       {:class "card-body flex flex-row"}
       (comment "image")
       [:div
        {:class "img-wrapper w-40 h-40 flex justify-center items-center"}
        [:img {:src "./img/happy.svg", :alt "img title"}]]
       (comment "end image")
       (comment "info")
       [:div
        {:class "py-2 ml-10"}
        [:h1 {:class "h6"} "Good Job, Mohamed!"]
        [:p
         {:class "text-white text-xs"}
         "You&#39;ve finished all of your tasks for this week."]
        [:ul
         {:class "mt-4"}
         [:li
          {:class "text-sm font-light"}
          [:i {:class "fad fa-check-double mr-2 mb-2"}]
          "Finish Dashboard Design"]
         [:li
          {:class "text-sm font-light"}
          [:i {:class "fad fa-check-double mr-2 mb-2"}]
          "Fix Issue #74"]
         [:li
          {:class "text-sm font-light"}
          [:i {:class "fad fa-check-double mr-2"}]
          "Publish version 1.0.6"]]]
       (comment "end info")]]
     (comment "end update section")
     (comment "carts")
     [:div
      {:class "flex flex-col"}
      (comment "alert")
      [:div
       {:class "alert alert-dark mb-6"}
       "Hi! Wait A Minute . . . . . . Follow Me On Twitter"
       [:a
        {:class "ml-2",
         :target "_blank",
         :href "https://twitter.com/MohamedSaid__"}
        "@moesaid"]]
      (comment "end alert")
      (comment "charts")
      [:div
       {:class "grid grid-cols-2 gap-6 h-full"}
       [:div
        {:class "card"}
        [:div
         {:class "py-3 px-4 flex flex-row justify-between"}
         [:h1
          {:class "h6"}
          [:span {:class "num-4"}]
          "k"
          [:p "page view"]]
         [:div
          {:class
           "bg-teal-200 text-teal-700 border-teal-300 border w-10 h-10 rounded-full flex justify-center items-center"}
          [:i {:class "fad fa-eye"}]]]
        [:div {:class "analytics_1"}]]
       [:div
        {:class "card"}
        [:div
         {:class "py-3 px-4 flex flex-row justify-between"}
         [:h1
          {:class "h6"}
          [:span {:class "num-2"}]
          "k"
          [:p "Unique Users"]]
         [:div
          {:class
           "bg-indigo-200 text-indigo-700 border-indigo-300 border w-10 h-10 rounded-full flex justify-center items-center"}
          [:i {:class "fad fa-users-crown"}]]]
        [:div {:class "analytics_1"}]]]
      (comment "charts")]
     (comment "end charts")]
    (comment "end Analytics")
    (comment "Sales Overview")
    [:div
     {:class "card mt-6"}
     (comment "header")
     [:div
      {:class "card-header flex flex-row justify-between"}
      [:h1 {:class "h6"} "Sales Overview"]
      [:div
       {:class "flex flex-row justify-center items-center"}
       [:a {:href ""} [:i {:class "fad fa-chevron-double-down mr-6"}]]
       [:a {:href ""} [:i {:class "fad fa-ellipsis-v"}]]]]
     (comment "end header")
     (comment "body")
     [:div
      {:class "card-body grid grid-cols-2 gap-6 lg:grid-cols-1"}
      [:div
       {:class "p-8"}
       [:h1 {:class "h2"} "5,337"]
       [:p {:class "text-black font-medium"} "Sales this month"]
       [:div
        {:class "mt-20 mb-2 flex items-center"}
        [:div
         {:class "py-1 px-3 rounded bg-green-200 text-green-900 mr-3"}
         [:i {:class "fa fa-caret-up"}]]
        [:p
         {:class "text-black"}
         [:span {:class "num-2 text-green-400"}]
         [:span {:class "text-green-400"} "% more sales"]
         "in comparison to last month."]]
       [:div
        {:class "flex items-center"}
        [:div
         {:class "py-1 px-3 rounded bg-red-200 text-red-900 mr-3"}
         [:i {:class "fa fa-caret-down"}]]
        [:p
         {:class "text-black"}
         [:span {:class "num-2 text-red-400"}]
         [:span {:class "text-red-400"} "% revenue per sale"]
         "in comparison to last month."]]
       [:a {:href "#", :class "btn-shadow mt-6"} "view details"]]
      [:div {:class ""} [:div {:id "sealsOverview"}]]]
     (comment "end body")]
    (comment "end Sales Overview")
    (comment "start numbers")
    [:div
     {:class "grid grid-cols-5 gap-6 xl:grid-cols-2"}
     (comment "card")
     [:div
      {:class "card mt-6"}
      [:div
       {:class "card-body flex items-center"}
       [:div
        {:class "px-3 py-2 rounded bg-indigo-600 text-white mr-3"}
        [:i {:class "fad fa-wallet"}]]
       [:div
        {:class "flex flex-col"}
        [:h1 {:class "font-semibold"} [:span {:class "num-2"}] "Sales"]
        [:p {:class "text-xs"} [:span {:class "num-2"}] "payments"]]]]
     (comment "end card")
     (comment "card")
     [:div
      {:class "card mt-6"}
      [:div
       {:class "card-body flex items-center"}
       [:div
        {:class "px-3 py-2 rounded bg-green-600 text-white mr-3"}
        [:i {:class "fad fa-shopping-cart"}]]
       [:div
        {:class "flex flex-col"}
        [:h1 {:class "font-semibold"} [:span {:class "num-2"}] "Orders"]
        [:p {:class "text-xs"} [:span {:class "num-2"}] "items"]]]]
     (comment "end card")
     (comment "card")
     [:div
      {:class "card mt-6 xl:mt-1"}
      [:div
       {:class "card-body flex items-center"}
       [:div
        {:class "px-3 py-2 rounded bg-yellow-600 text-white mr-3"}
        [:i {:class "fad fa-blog"}]]
       [:div
        {:class "flex flex-col"}
        [:h1 {:class "font-semibold"} [:span {:class "num-2"}] "posts"]
        [:p {:class "text-xs"} [:span {:class "num-2"}] "active"]]]]
     (comment "end card")
     (comment "card")
     [:div
      {:class "card mt-6 xl:mt-1"}
      [:div
       {:class "card-body flex items-center"}
       [:div
        {:class "px-3 py-2 rounded bg-red-600 text-white mr-3"}
        [:i {:class "fad fa-comments"}]]
       [:div
        {:class "flex flex-col"}
        [:h1
         {:class "font-semibold"}
         [:span {:class "num-2"}]
         "comments"]
        [:p {:class "text-xs"} [:span {:class "num-2"}] "approved"]]]]
     (comment "end card")
     (comment "card")
     [:div
      {:class "card mt-6 xl:mt-1 xl:col-span-2"}
      [:div
       {:class "card-body flex items-center"}
       [:div
        {:class "px-3 py-2 rounded bg-pink-600 text-white mr-3"}
        [:i {:class "fad fa-user"}]]
       [:div
        {:class "flex flex-col"}
        [:h1 {:class "font-semibold"} [:span {:class "num-2"}] "memebrs"]
        [:p {:class "text-xs"} [:span {:class "num-2"}] "online"]]]]
     (comment "end card")]
    (comment "end nmbers")
    (comment "start quick Info")
    [:div
     {:class "grid grid-cols-3 gap-6 mt-6 xl:grid-cols-1"}
     (comment "Browser Stats")
     [:div
      {:class "card"}
      [:div {:class "card-header"} "Browser Stats"]
      (comment "brawser")
      [:div
       {:class
        "p-6 flex flex-row justify-between items-center text-gray-600 border-b"}
       [:div
        {:class "flex items-center"}
        [:i {:class "fab fa-chrome mr-4"}]
        [:h1 "google chrome"]]
       [:div [:span {:class "num-2"}] "%"]]
      (comment "end brawser")
      (comment "brawser")
      [:div
       {:class
        "p-6 flex flex-row justify-between items-center text-gray-600 border-b"}
       [:div
        {:class "flex items-center"}
        [:i {:class "fab fa-firefox mr-4"}]
        [:h1 "firefox"]]
       [:div [:span {:class "num-2"}] "%"]]
      (comment "end brawser")
      (comment "brawser")
      [:div
       {:class
        "p-6 flex flex-row justify-between items-center text-gray-600 border-b"}
       [:div
        {:class "flex items-center"}
        [:i {:class "fab fa-internet-explorer mr-4"}]
        [:h1 "internet explorer"]]
       [:div [:span {:class "num-2"}] "%"]]
      (comment "end brawser")
      (comment "brawser")
      [:div
       {:class
        "p-6 flex flex-row justify-between items-center text-gray-600 border-b-0"}
       [:div
        {:class "flex items-center"}
        [:i {:class "fab fa-safari mr-4"}]
        [:h1 "safari"]]
       [:div [:span {:class "num-2"}] "%"]]
      (comment "end brawser")]
     (comment "end Browser Stats")
     (comment "Start Recent Sales")
     [:div
      {:class "card col-span-2 xl:col-span-1"}
      [:div {:class "card-header"} "Recent Sales"]
      [:table
       {:class "table-auto w-full text-left"}
       [:thead
        [:tr
         [:th {:class "px-4 py-2 border-r"}]
         [:th {:class "px-4 py-2 border-r"} "product"]
         [:th {:class "px-4 py-2 border-r"} "price"]
         [:th {:class "px-4 py-2"} "date"]]]
       [:tbody
        {:class "text-gray-600"}
        [:tr
         [:td
          {:class
           "border border-l-0 px-4 py-2 text-center text-green-500"}
          [:i {:class "fad fa-circle"}]]
         [:td
          {:class "border border-l-0 px-4 py-2"}
          "Lightning to USB-C Adapter Lightning."]
         [:td
          {:class "border border-l-0 px-4 py-2"}
          "$"
          [:span {:class "num-2"}]]
         [:td
          {:class "border border-l-0 border-r-0 px-4 py-2"}
          [:span {:class "num-2"}]
          "minutes ago"]]
        [:tr
         [:td
          {:class
           "border border-l-0 px-4 py-2 text-center text-yellow-500"}
          [:i {:class "fad fa-circle"}]]
         [:td {:class "border border-l-0 px-4 py-2"} "Apple iPhone 8."]
         [:td
          {:class "border border-l-0 px-4 py-2"}
          "$"
          [:span {:class "num-2"}]]
         [:td
          {:class "border border-l-0 border-r-0 px-4 py-2"}
          [:span {:class "num-2"}]
          "minutes ago"]]
        [:tr
         [:td
          {:class
           "border border-l-0 px-4 py-2 text-center text-green-500"}
          [:i {:class "fad fa-circle"}]]
         [:td
          {:class "border border-l-0 px-4 py-2"}
          "Apple MacBook Pro."]
         [:td
          {:class "border border-l-0 px-4 py-2"}
          "$"
          [:span {:class "num-2"}]]
         [:td
          {:class "border border-l-0 border-r-0 px-4 py-2"}
          [:span {:class "num-2"}]
          "minutes ago"]]
        [:tr
         [:td
          {:class "border border-l-0 px-4 py-2 text-center text-red-500"}
          [:i {:class "fad fa-circle"}]]
         [:td
          {:class "border border-l-0 px-4 py-2"}
          "Samsung Galaxy S9."]
         [:td
          {:class "border border-l-0 px-4 py-2"}
          "$"
          [:span {:class "num-2"}]]
         [:td
          {:class "border border-l-0 border-r-0 px-4 py-2"}
          [:span {:class "num-2"}]
          "minutes ago"]]
        [:tr
         [:td
          {:class
           "border border-l-0 px-4 py-2 text-center text-yellow-500"}
          [:i {:class "fad fa-circle"}]]
         [:td
          {:class "border border-l-0 px-4 py-2"}
          "Samsung Galaxy S8 256GB."]
         [:td
          {:class "border border-l-0 px-4 py-2"}
          "$"
          [:span {:class "num-2"}]]
         [:td
          {:class "border border-l-0 border-r-0 px-4 py-2"}
          [:span {:class "num-2"}]
          "minutes ago"]]
        [:tr
         [:td
          {:class
           "border border-l-0 border-b-0 px-4 py-2 text-center text-green-500"}
          [:i {:class "fad fa-circle"}]]
         [:td
          {:class "border border-l-0 border-b-0 px-4 py-2"}
          "apple watch."]
         [:td
          {:class "border border-l-0 border-b-0 px-4 py-2"}
          "$"
          [:span {:class "num-2"}]]
         [:td
          {:class "border border-l-0 border-b-0 border-r-0 px-4 py-2"}
          [:span {:class "num-2"}]
          "minutes ago"]]]]]
     (comment "End Recent Sales")]
    (comment "end quick Info")]
   (comment "end content")])

(defn home-panel []
  [:div [navbar] [wrapper]])
