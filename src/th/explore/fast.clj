(ns th.explore.fast
  )

;; Can we get some fast operations going with TVM? But what does that even look
;; like? Is simply adding up matrices and vectors too primitive?

;; I could at least try avoiding hundreds and hundreds of the allocations needed
;; when working with large data sizes of (pure) Clojure vectors.

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; TODO
;;
;;  - Consider TVM-CLJ
;;  - Consider MXNET

;; For now, leave it be. Don't bother. Focus on learning the primitives first,
;; then make them fast -- if that's required.

;; And as for the results. Perhaps just store the results in the DB. Don't try
;; to keep everything, don't push the limits of what we can store when we make
;; this thing work.
