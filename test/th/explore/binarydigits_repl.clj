(ns th.explore.binarydigits-repl
  (:require [th.explore.binarydigits :as digits]
            [clojure.test :refer :all]))

;;;; Get a feel for the sigmoid function
(comment
  (digits/run-sigmoid (digits/make-sigmoid [5 5 -10] 0)
                      [1 1 1])
  ;; => 0.5
  (digits/run-sigmoid (digits/make-sigmoid [5 5 -10] 0)
                      [1 1 -1])
  ;; => 0.9999999979388463
  (digits/run-sigmoid (digits/make-sigmoid [5 5 -10] 0)
                      [1 1 0])
  ;; => 0.9999546021312976

  (digits/run-sigmoid (digits/make-sigmoid [1] 0)
                      [1])
  ;; => 0.7310585786300049

  (digits/run-sigmoid (digits/make-sigmoid [5] 0)
                      [1])
  ;; => 0.9933071490757153

  (digits/run-sigmoid (digits/make-sigmoid [1] 1)
                      [1])
  ;; => 0.8807970779778823

  (digits/run-sigmoid (digits/make-sigmoid [1] 4)
                      [1])
  ;; => 0.9933071490757153
  )
