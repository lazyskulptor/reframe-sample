(ns web-client.view.shared.side-menubar
  (:require
   [web-client.base.layout :as l]
   [web-client.base.component :refer [side-menu subhead]]))

(defmethod l/side-menubar :default []
  [:div
   {:id "sideBar",
    :class
    "relative flex flex-col flex-wrap bg-white border-r border-gray-300 p-6 flex-none w-64 md:-ml-64 md:fixed md:top-0 md:z-30 md:h-screen md:shadow-xl animated faster"}
   [:div ;; sidebar content
    {:class "flex flex-col"}
    (comment "sidebar toggle")
    [:div
     {:class "text-right hidden md:block mb-4"}
     [:button
      {:id "sideBarHideBtn"}
      [:i {:class "fad fa-times-circle"}]]]
    (comment "end sidebar toggle")

    [subhead "homes" false]
    [side-menu "./analytics" "fa-chart-pie" "Analytics dashboard"]

    [subhead "apps"]
    [side-menu "./email.html" "fa-envelope-open-text" "email"]
    [side-menu "#""fa-comments""chat"]
    [side-menu "#" "fa-shield-check" "todo"]
    [side-menu "#" "fa-calendar-edit" "calendar"]
    [side-menu "#" "fa-file-invoice-dollar" "invoice"]
    [side-menu "#" "fa-folder-open" "file manager"]

    [subhead "UI Elements"]
    [side-menu "./typography.html" "fa-text" "typography"]
    [side-menu "./alert.html" "fa-whistle" "alerts"]
    [side-menu "./buttons.html" "fa-cricket" "buttons"]
    [side-menu "#" "fa-box-open" "Content"]
    [side-menu "#" "fa-swatchbook" "colors"]
    [side-menu "#" "fa-atom-alt" "icons"]
    [side-menu "#" "fa-club" "card"]
    [side-menu "#" "fa-cheese-swiss" "Widgets"]
    [side-menu "#" "fa-computer-classic" "Components"]]])
