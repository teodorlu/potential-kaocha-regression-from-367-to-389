(ns th.explore.binarydigits-test
  (:require [th.explore.binarydigits :as digits]
            [clojure.test :refer :all]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Goal
;;
;; Describe an interface that ensures that we hit our "digit modeling" right.

(deftest truthy-heuristics
  (testing "Values > 0.99 are considered true"
    (is (digits/probably-true? 0.991))
    (is (not (digits/probably-true? 0.899)))))
