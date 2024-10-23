(ns web-client.base.component)

(defn l-btn [to title icon]
  [:a
   {:class
    "mr-2 transition duration-500 ease-in-out hover:text-gray-900",
    :href to,
    :title title}
   [:i {:class (str "fad " icon)}]])


(defn hide-overflow []
  [:button
    {:class
     "hidden fixed top-0 left-0 z-10 w-full h-full menu-overflow"}])

(defn side-menu [to icon name]
  [:a
   {:href to,
    :class
    "mb-3 capitalize font-medium text-sm hover:text-teal-600 transition ease-in-out duration-500"}
   [:i {:class (str "fad text-xs mr-2 " icon)}]
   name])

(defn subhead
  ([name] (subhead name true))
  ([name upper-margin]
   [:p
    {:class (str "uppercase text-xs text-gray-600 mb-4 tracking-wider"
                 (when upper-margin " mt-4"))}
    name]))
