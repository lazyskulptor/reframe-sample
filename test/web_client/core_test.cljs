(ns web-client.core-test

  (:require
   [clojure.test.check.generators]
   [clojure.test.check]
   [clojure.test.check.properties]
   [cljs.test :refer-macros [deftest testing is]]
   [web-client.test-utils :as util]
   [web-client.events.auth :as auth]
   [web-client.events.auth-spec]
   ))

(deftest auto-tests
  (testing "generated"
    (is (util/scheck `auth/signin-req))
    (is (util/scheck `auth/authenticated))
    (is (util/scheck `auth/signin-fail))
    (is (util/scheck `auth/signup-req))
    (is (util/scheck `auth/signup-fail))))
