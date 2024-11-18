(ns web-client.test-utils
  (:require-macros [web-client.test-utils]))

(def counter
  ((fn []
     (let [v (atom 0)]
       (fn [& arg]
         (when (= (first arg) true)
           (swap! v (fn [_] 0)))
         (let [curr @v]
           (swap! v inc)
           curr))))))

(defn wait
  ([f rs] (wait f rs 10))
  ([f rs ms]
   (js/Promise.
    (fn [resolve]
      (let [repeater (fn repeater [cnt]
                       (if (= rs (f))
                         (resolve rs)
                         (if (< cnt 10000)
                           (js/setTimeout #(repeater (+ cnt 1)) ms)
                           (js/console.error "WAITING TIMEOUT"))))]
        (repeater 0))))))
