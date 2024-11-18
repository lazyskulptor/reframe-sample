(ns web-client.events.core-spec)

(defmacro def-param [payload]
  `(s/cat :ctx ::ctx
         :event (s/spec (s/cat :id keyword? :payload ~payload))))

(defmacro def-data [data]
  `(s/cat :ctx ::ctx
          :event (s/spec (s/cat :id keyword? :response (s/keys :req-un [~data])))))

(defmacro http-ret [http-xhrio]
  `(s/keys :req-un [::db ~http-xhrio]))

(defmacro db-ret [vm-spec]
  `(s/merge ::db (s/keys :req-un [~vm-spec])))

(defmacro spec-nav [route]
  `(s/tuple #{:dispatch}
            #{:web-client.events.core/navigate}
            #{~route}))
