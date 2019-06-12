(ns th.explore.binarydigits)

(defn foo "Before the name comes the function"
  [])

(defn probably-true? [prob]
  (> prob 0.99))

(defn probably-false? [prob]
  (< prob 0.01))

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

;; But I need a way to run the neurons as well. How do I run one with some input?
;; And for each one, ..., they could just be run with "arguments" as the xs.
