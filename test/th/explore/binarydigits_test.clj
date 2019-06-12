(ns th.explore.binarydigits-test
  (:require [th.explore.binarydigits :as digits]
            [clojure.test :refer :all]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Goal
;;
;; Describe an interface that ensures that we hit our "digit modeling" right.
;;
;; That test runner is ridiculously fast! Works well.

(deftest stuf
  (is 9399))

(deftest hello
  (testing "Things work"
    (is (= 1 1))))
