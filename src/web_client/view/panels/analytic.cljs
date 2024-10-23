(ns web-client.view.panels.analytic
  (:require
   [web-client.base.layout :as l]))

(defn general-report []
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
   (comment "end card")])

(defn analytics []
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
   (comment "end charts")])

(defn sales []
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
    [:div {:class ""} [:div#sealsOverview]]]
   (comment "end body")])

(defn numbers []
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
   (comment "end card")])

(defn quick-info []
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
   (comment "End Recent Sales")])

(defmethod l/panels :analytics-panel []
  [l/wrapper general-report analytics sales numbers quick-info])
