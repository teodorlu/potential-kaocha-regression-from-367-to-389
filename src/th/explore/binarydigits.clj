(ns th.explore.binarydigits)

(defn foo "Before the name comes the function"
  [])

(defn truthy?
  "We represent true as values 0.99 < prob < 1"
  [prob]
  (> prob 0.99))

(defn falsey?
  "We represent false as values 0 < prob < 0.01"
  [prob]
  (< prob 0.01))

(defn make-sigmoid
  "Create an object with weights and bias for use later"
  [weights bias]
  {:weights weights
   :bias bias})

(defn sigmoid-z
  "The sigmoid function transforms (-inf, inf) to (0, 1) smoothly"
  [z]
  (/ 1
     (+ 1 (Math/exp (- z)))))

(defn dotproduct
  "The dot product (inner product) of two vectors"
  [x y]
  (reduce + (map * x y)))

(defn run-sigmoid
  "Execute a sigmoid on inputs x"
  [sigmoid x]
  (let [{:keys [weights bias]} sigmoid]
    (sigmoid-z (+ (dotproduct weights x)
                  bias))))

(def binary-target-activations
  "A zero (base 10) is represented as [0 0 0 0] (base 0, less than 16)"
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
