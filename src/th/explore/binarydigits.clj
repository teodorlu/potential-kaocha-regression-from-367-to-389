(ns th.explore.binarydigits
  "Partial implementation of digits-as-sigmoids from http://neuralnetworksanddeeplearning.com/chap1.html")

(defn truthy?
  "We represent true as values 0.99 < prob < 1"
  [prob]
  (>= prob 0.99))

(defn falsey?
  "We represent false as values 0 < prob < 0.01"
  [prob]
  (<= prob 0.01))

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

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; A short note on the sigmoid function.
;;
;; The sigmoid function normalizes inputs. Regardless of how large the weights
;; are, we get a standard output range. This eases composition. We know what our
;; inputs are going to be -- they are going to be in (0, 1). So we'll just
;; assume that. And we know that a result of 5 will produce something
;; that's "really true".
;;
;; In other words, the sigmoid function makes composition easier. That's a good
;; thing!

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

(defn make-signal-encodings
  "Create a map with encodings for the numbers 0..n"
  [n]
  (let [zero-vec (vec (repeat n 0))
        create-single-signal (fn [x]
                               (assoc zero-vec x 1))]
    (into {}
          (for [x (range n)]
            [x (create-single-signal x)]))))

(def single-digit-signal-encodings
  (make-signal-encodings 10))

(def binary-target-sigmoid
  (make-sigmoid [] 0))

(defn valid-boolean-signal?
  "0 <= x <= 0.01 or 0.99 <= x <= 1"
  [x]
  (and (>= x 0)
       (<= x 1)
       (or (truthy? x)
           (falsey? x))))

(def invalid-boolean-signal? (complement valid-boolean-signal?))

(do
  (defn binary-signals-to-number [binaries]
    (if (any?
         (map invalid-boolean-signal? binaries))
      nil
      (vec (for [b binaries]
             (if (> b 0.5)
               1
               0))))
    )
  [(binary-signals-to-number [0.999 0.999])]
 )
