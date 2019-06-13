(ns th.explore.binarydigits)

(defn foo "Before the name comes the function"
  [])

(defn probably-true? [prob]
  (> prob 0.99))

(defn probably-false? [prob]
  (< prob 0.01))

(defn make-sigmoid [weights bias]
  {:weights weights
   :bias bias})

(defn sigmoid-z [z]
  (/ 1
     (+ 1 (Math/exp (- z)))))

(defn dotproduct [x y]
  (reduce + (map * x y)))

(defn run-sigmoid [sigmoid x]
  (let [{:keys [weights bias]} sigmoid]
    (sigmoid-z (+ (dotproduct weights x)
                  bias))))

(def binary-target-activations
  {0 [0 0 0 0]
   1 [0 0 0 1]
   2 [0 0 1 0]
   3 [0 0 1 1]
   4 [0 1 0 0]
   5 [0 1 0 1]
   6 [0 1 1 0]
   7 [0 1 1 1]
   8 [1 0 0 0]
   9 [1 0 0 1]})
