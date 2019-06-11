(ns th.explore.deeplearning)

;; Following http://neuralnetworksanddeeplearning.com/chap1.html

(defn make-perceptron-1 [weights treshold]
  {:weights weights
   :treshold treshold})

(defn dotproduct [x y]
  (reduce + (map * x y)))

(comment
  (dotproduct [1 2] [3 4])
  ;; => 11
  )

(defn sigmoid-z [z]
  (/ 1
     (+ 1 (Math/exp (- z)))))

(defn sigmoid [perceptron x]
  (let [{:keys [weights treshold]} perceptron
        bias (- treshold)]
    (sigmoid-z (+ (dotproduct weights x)
                  bias))))

;; How can we test this?

(comment
  (sigmoid (make-perceptron-1 [0.2 0.4 0.4] 0.7)
           [0 1 1])
  ;; => 0.52497918747894
  :previously-true

  (sigmoid (make-perceptron-1 [0.2 0.4 0.4] 0.7)
           [1 0 0])
  ;; => 0.3775406687981454
  :previously-false

  "This seems to be right. If we put the cutoff at 0.5, we're at where we'd like to be."
  )

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; EXERCISE

;; Create an intermediate layer that converts a set of sigmoids that represent
;; digits 0-9 to a binary representation of the numbers.

(def target-activations {0 [0 0 0 0]
                         1 [0 0 0 1]
                         2 [0 0 1 0]
                         3 [0 0 1 1]
                         4 [0 1 0 0]
                         5 [0 1 0 1]
                         6 [0 1 1 0]
                         7 [0 1 1 1]
                         8 [1 0 0 0]
                         9 [1 0 0 1]})

;; Where true is > 0.99 and false is < 0.01

;; How should we run this?

;; We need to have the first one respond true only to the frist two digits.
