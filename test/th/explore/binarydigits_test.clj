(ns th.explore.binarydigits-test
  (:require [th.explore.binarydigits :as digits]
            [clojure.test :refer :all]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; GOAL
;;
;; Describe an interface that ensures that we hit our "digit modeling" right.

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; RESOURCES
;;
;; Book URL: http://neuralnetworksanddeeplearning.com/chap1.html

(deftest truthy-heuristics
  (testing "Values > 0.99 are considered true"
    (is (digits/probably-true? 0.991))
    (is (not (digits/probably-true? 0.899))))
  (testing "Values < 0.01 are considered false"
    (is (digits/probably-false? 0.006))
    (is (not (digits/probably-false? 0.02)))
    (is (not (digits/probably-false? 0.012)))))

;; Now, what does our transformation look like? We need those neurons.

(deftest transform-api
  (is digits/foo))
