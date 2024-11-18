(ns web-client.test-utils)

(defmacro scheck [sym]
  `(-> (cljs.spec.test.alpha/check ~sym) first :clojure.spec.test.check/ret :result))
