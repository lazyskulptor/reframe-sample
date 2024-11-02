(ns web-client.base.layout
  (:require
   [re-frame.core :refer [subscribe dispatch]]
   [web-client.events :as events]
   [web-client.subs :as subs]))

(defmulti panels identity)
(defmulti header-menus identity)
(defmulti side-menus identity)
(defmulti action-menus identity)

(defmethod panels :default [] [:div "No panel found for this route."])

(defn- sidebar []
  [:aside
   {:class
    (str (if @(subscribe [::subs/sidebar]) "hidden " "")
         "z-20 inset-y-0 md:inset-y2.5 mt-16 md:mt-0 fixed md:relative md:block w-64 overflow-y-auto bg-white dark:bg-gray-800 flex-shrink-0")}

   [:div
    {:class "py-4 text-gray-500 dark:text-gray-400"}
    [:a
     {:class "ml-6 text-lg font-bold text-gray-800 dark:text-gray-200",
      :href "#"}
     "Spot"]
    [:ul.mt-6
     (for [ele (side-menus)] ^{:key ele} [ele])]

    (for [ele (action-menus)] ^{:key ele} [ele])]])

(defn- cover- []
  [:div
   {:class
    (str (if @(subscribe [::subs/sidebar]) "hidden " "")
         "flex md:hidden fixed inset-0 z-10 items-end bg-black bg-opacity-50 sm:items-center sm:justify-center")}])

(defn- mobile-hamburger []
  [:button
   {:class
    "p-1 mr-5 -ml-1 rounded-md md:hidden focus:outline-none focus:shadow-outline-purple",
    :on-click #(dispatch [::events/toggle-sidebar]),
    :aria-label "Menu"}
   [:svg
    {:class "w-6 h-6",
     :aria-hidden "true",
     :fill "currentColor",
     :viewBox "0 0 20 20"}
    [:path
     {:fill-rule "evenodd",
      :d
      "M3 5a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 10a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 15a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1z",
      :clip-rule "evenodd"}]]])

(defn- search-input []
  [:div
   {:class "hidden flex justify-center flex-1 lg:mr-32"}
   [:div
    {:class
     "relative w-full max-w-xl mr-6 focus-within:text-purple-500"}
    [:div
     {:class "absolute inset-y-0 flex items-center pl-2"}
     [:svg
      {:class "w-4 h-4",
       :aria-hidden "true",
       :fill "currentColor",
       :viewBox "0 0 20 20"}
      [:path
       {:fill-rule "evenodd",
        :d
        "M8 4a4 4 0 100 8 4 4 0 000-8zM2 8a6 6 0 1110.89 3.476l4.817 4.817a1 1 0 01-1.414 1.414l-4.816-4.816A6 6 0 012 8z",
        :clip-rule "evenodd"}]]]
    [:input
     {:class
      "w-full pl-8 pr-2 text-sm text-gray-700 placeholder-gray-600 bg-gray-100 border-0 rounded-md dark:placeholder-gray-500 dark:focus:shadow-outline-gray dark:focus:placeholder-gray-600 dark:bg-gray-700 dark:text-gray-200 focus:placeholder-gray-500 focus:bg-white focus:border-purple-300 focus:outline-none focus:shadow-outline-purple form-input",
      :type "text",
      :placeholder "Search for projects",
      :aria-label "Search"}]]])

(defn- header []
  [:header
   {:class "z-10 py-4 bg-white shadow-md dark:bg-gray-800"}
   [:div
    {:class
     "container flex items-center justify-between h-full px-6 mx-auto text-purple-600 dark:text-purple-300"}
    [mobile-hamburger]
    [search-input]

    [:ul
     {:class "w-full flex items-center justify-end space-x-6"}
     (for [ele (header-menus)] ^{:key ele} [ele])]]])

(defn wrapper [& eles]
  [:div
   {:class "flex h-screen bg-gray-50 dark:bg-gray-900 overflow-hidden"}

   [cover-]
   [sidebar]

   [:div
    {:class "flex flex-col flex-1 w-full"}
    [header]

    [:main
     {:class "h-full overflow-y-auto"}
     [:div
      {:class "container px-6 mx-auto grid"}
      (for [ele eles] ^{:key ele} [ele])

      (comment "CTA")]]]])


