(ns th.explore.binarydigits-test
  (:require [th.explore.binarydigits
             :as digits
             :refer [truthy? falsey? make-sigmoid run-sigmoid]]
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
    (is (truthy? 0.991))
    (is (not (truthy? 0.899))))
  (testing "Values < 0.01 are considered false"
    (is (falsey? 0.006))
    (is (not (falsey? 0.02)))
    (is (not (falsey? 0.012)))))

(deftest valid-boolean-signals
  (testing "Truthyness heuristic accepts ranges of 0 <= x <= 0.01 and 0.99 <= x <= 1"
    (doseq [[num expected-to-be-valid?] [[-0.4 false]
                                         [0 true] [0.003 true]
                                         [0.1 false] [0.2 false] [0.5 false] [0.8 false]
                                         [0.991 true] [1 true]
                                         [1.1 false]]]
      (is (= expected-to-be-valid? (digits/valid-boolean-signal? num))))))

;; Now, what does our transformation look like? We need those neurons.

(deftest dotproduct
  (is (= (digits/dotproduct [1 2] [3 4])
         11)))

(deftest sigmoid-truthyness-limit
  (let [prob-limit 5]
    (is 1)
    (testing "Sigmoid truthyness when we reach above the limit"
      (testing "... by increasing bias"
        (is (truthy? (run-sigmoid (make-sigmoid [0] prob-limit)
                                [0]))))
      (testing "... by increasing weights"
        (is (truthy? (run-sigmoid (make-sigmoid [prob-limit] 0)
                                  [1])))))

    (testing "Sigmoid falseyness when we reach below the limit"
      (testing "... by increasing bias"
        (is (falsey? (run-sigmoid (make-sigmoid [0] (- prob-limit)
                                                )
                                  [0]))))
      (testing "... by increasing weights"
        (is (falsey? (run-sigmoid (make-sigmoid [prob-limit] 0)
                                  [-1])))))
    ))

(deftest digit-to-binary-conversions
  (is digits/binary-target-sigmoid)
  )
