(ns web-client.base.layout)

(defn- l-btn [to title icon]
  [:a
   {:class
    "mr-2 transition duration-500 ease-in-out hover:text-gray-900",
    :href to,
    :title title}
   [:i {:class (str "fad " icon)}]])

(defn- email [] (l-btn "#" "email" "fad fa-envelope-open-text"))

(defn- reply [] (l-btn "#" "comment" "fa-comments-alt"))

(defn- todo [] (l-btn "#" "" "fa-check-circle"))

(defn- calendar [] (l-btn "#" "email" "fa-calendar-exclamation"))

(defn- left-content [& items]
  (fn [] [:div
          {:class
           "text-gray-600 md:w-full md:flex md:flex-row md:justify-evenly md:pb-10 md:mb-10 md:border-b md:border-gray-200"}
          (for [item items] ^{key item} [item])]))

(defn- hide-overflow []
  [:button
    {:class
     "hidden fixed top-0 left-0 z-10 w-full h-full menu-overflow"}])

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

(defn- right-content [& items]
  (fn []
    [:div
     {:class "flex flex-row-reverse items-center"}
     (for [item items] ^{:key item} [item])]))

(defn- navbar [left-items right-items]
  [:div
   {:class
    "md:fixed md:w-full md:top-0 md:z-20 flex flex-row flex-wrap items-center bg-white p-6 border-b border-gray-300"}

   [:div ;; logo
    {:class "flex-none w-56 flex flex-row items-center"}
    [:img {:src "img/logo.png", :class "w-10 flex-none"}]
    [:strong {:class "capitalize ml-1 flex-1"} "cleopatra"]
    [:button
     {:id "sliderBtn",
      :class "flex-none text-right text-gray-900 hidden md:block"}
     [:i {:class "fad fa-list-ul"}]]]

   [:button ;; navbar content toggle
    {:id "navbarToggle", :class "hidden md:block md:fixed right-0 mr-6"}
    [:i {:class "fad fa-chevron-double-down"}]]

   (comment "navbar content")
   [:div
    {:id "navbar",
     :class
     "animated md:hidden md:fixed md:top-0 md:w-full md:left-0 md:mt-16 md:border-t md:border-b md:border-gray-200 md:p-10 md:bg-white flex-1 pl-3 flex flex-row flex-wrap justify-between items-center md:flex-col md:items-center"}

    [left-items]
    [right-items]]
   (comment "end navbar content")])

(defn- side-menu [to icon name]
  [:a
   {:href to,
    :class
    "mb-3 capitalize font-medium text-sm hover:text-teal-600 transition ease-in-out duration-500"}
   [:i {:class (str "fad text-xs mr-2 " icon)}]
   name])

(defn- subhead 
  ([name] (subhead name true))
  ([name upper-margin]
   [:p
    {:class (str "uppercase text-xs text-gray-600 mb-4 tracking-wider"
                 (when upper-margin " mt-4"))}
    name]))

(defn- sidebar []
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
    [side-menu "./index.html" "fa-chart-pie" "Analytics dashboard"]
    [side-menu "./index-1.html" "fa-shopping-cart" "ecommerce dashboard"]

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

(defn wrapper [& eles]
  [:div
   [navbar
    (left-content email reply todo calendar) (right-content profile notifications)]
   [:div
    {:class "h-screen flex flex-row flex-wrap"}

    [sidebar]

    (comment "strat content")
    [:div
     {:class "bg-gray-100 flex-1 p-6 md:mt-16"}
     (for [ele eles] ^{:key ele} [ele])]
    (comment "end content")]])
