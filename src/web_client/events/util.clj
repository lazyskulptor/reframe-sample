(ns web-client.events.util)

(defmacro def-param [payload & args]
  (println 1)
  `(s/cat :ctx ::c/ctx
         :event (s/spec (s/cat :id keyword? :payload ~payload))))
