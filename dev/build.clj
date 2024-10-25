(ns build
 (:require [shadow.cljs.devtools.api :as shadow]))

(defn watch-app
  {:shadow/requires-server true}
  []
  (shadow/watch :app)
  (shadow/watch :browser-test)
  (shadow/watch :karma-test)
  (let [pr (-> (Runtime/getRuntime) (.exec "npx gulp"))]
    (-> pr .getInputStream (.transferTo System/out))))
