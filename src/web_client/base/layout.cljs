(ns web-client.base.layout)

(defmulti panels identity)
(defmulti left-nav-items identity)
(defmulti right-nav-items identity)
(defmulti side-menubar identity)

(defmethod panels :default [] [:div "No panel found for this route."])

(defn navbar []
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

   [:div#navbar ;; navbar content
    {:class
     "animated md:hidden md:fixed md:top-0 md:w-full md:left-0 md:mt-16 md:border-t md:border-b md:border-gray-200 md:p-10 md:bg-white flex-1 pl-3 flex flex-row flex-wrap justify-between items-center md:flex-col md:items-center"}

    [(left-nav-items)] [(right-nav-items)]]])

(defn wrapper [& eles]
  [:div
   [navbar]

   [:div.h-screen.flex.flex-row.flex-wrap
    [side-menubar]

    [:div.bg-gray-100.flex-1.p-6.md:mt-16
     ;; contents
     (for [ele eles] ^{:key ele} [ele])

     ]]])
