(ns th.explore.binarydigits)

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

(defn valid-boolean-signal? [num]
  (and (>= num 0)
       (<= num 1)
       (or (truthy? num)
           (falsey? num))))

(def invalid-boolean-signal? (complement valid-boolean-signal?))

(comment
  (for [num [-0.4 0 0.003 0.1 0.2 0.5 0.8 0.991 1 1.1]]
    [num (valid-boolean-signal? num)])
  ;; => ([-0.4 false]
  ;;     [0 true]
  ;;     [0.003 true]
  ;;     [0.1 false]
  ;;     [0.2 false]
  ;;     [0.5 false]
  ;;     [0.8 false]
  ;;     [0.991 true]
  ;;     [1 true]
  ;;     [1.1 false])

  (prn (vec (for [num [-0.4 0 0.003 0.1 0.2 0.5 0.8 0.991 1 1.1]]
              [num (valid-boolean-signal? num)])))


  ;; Looks good
  )

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
