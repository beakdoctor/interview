(ns solutions.core
  (:require [clojure.math.combinatorics :as combinatorics]
            [loom.graph :as l]
            [loom.io :refer [view]]))
; https://leetcode.com/problems/combination-sum/
; Difficulty: Medium
; Problem statement:
; Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
; find all unique combinations in candidates where the candidate numbers sums to target.
;
; The same repeated number may be chosen from candidates unlimited number of times.
;
; Note:
;
; All numbers (including target) will be positive integers.
; The solution set must not contain duplicate combinations.
; Example 1:
;
; Input: candidates = [2,3,6,7], target = 7,
; A solution set is:
; [
;  [7],
;  [2,2,3]
;  ]
; Example 2:
;
; Input: candidates = [2,3,5], target = 8,
; A solution set is:
; [
;  [2,2,2,2],
;  [2,3,3],
;  [3,5]
;  ]

(->> [2 3 6 7]
     )

(defn combination-sum [candidates target]
  ; recursion?
  ; base case is that the sequence is consumed
  )
(defn solution? [s])
(defn print-solution [s])


(first #{0 1})
(rest #{0 1})

; production clojure: look up how to do it in math, find the math lib that does it
(defn all-subsets [s]
  (map set (combinatorics/subsets s)))
(all-subsets #{1 2 3})
(= (all-subsets #{0 1}) '(#{} #{0} #{0 1} #{1}))
; Start with something a little bit easier, generate subsets

(defn my-subsets [s]
  (if (empty? s)
    #{#{}}                                                  ; return the empty subset
    (let [ts (my-subsets (rest s))]
      (println ts)
      (->> ts
           (map #(conj % (first s)))
           (clojure.set/union ts))))

  )
(my-subsets #{1 2 3})

(defn my-subsets [set]
  (loop [[first & rest] set
         accumulator '(#{})]
    (if first (recur rest (concat accumulator (map #(conj % first) accumulator)))
          accumulator)))
(my-subsets #{1 2 3})

