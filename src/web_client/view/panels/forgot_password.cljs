(ns web-client.view.panels.forgot-password
  (:require
   [web-client.base.layout :as l]))

(defmethod l/panels :forgot-password-panel []
  [l/centered
     (fn [] [:div
      {:class "h-32 md:h-auto md:w-1/2"}
      [:img
       {:aria-hidden "true",
        :class "object-cover w-full h-full dark:hidden",
        :src "/img/forgot-password-office.jpeg",
        :alt "Office"}]
      [:img
       {:aria-hidden "true",
        :class "hidden object-cover w-full h-full dark:block",
        :src "/img/forgot-password-office-dark.jpeg",
        :alt "Office"}]])
     (fn [] [:div
      {:class "flex items-center justify-center p-6 sm:p-12 md:w-1/2"}
      [:div
       {:class "w-full"}
       [:h1
        {:class
         "mb-4 text-xl font-semibold text-gray-700 dark:text-gray-200"}
        "Forgot password"]
       [:label
        {:class "block text-sm"}
        [:span {:class "text-gray-700 dark:text-gray-400"} "Email"]
        [:input
         {:class
          "block w-full mt-1 text-sm dark:border-gray-600 dark:bg-gray-700 focus:border-purple-400 focus:outline-none focus:shadow-outline-purple dark:text-gray-300 dark:focus:shadow-outline-gray form-input",
          :placeholder "Jane Doe"}]]
       (comment
         "You should use a button here, as the anchor is only used for the example")
       [:a
        {:class
         "block w-full px-4 py-2 mt-4 text-sm font-medium leading-5 text-center text-white transition-colors duration-150 bg-purple-600 border border-transparent rounded-lg active:bg-purple-600 hover:bg-purple-700 focus:outline-none focus:shadow-outline-purple",
         :href "./login"}
        "Recover password"]]])])
