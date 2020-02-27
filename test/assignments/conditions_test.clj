(ns assignments.conditions-test
  (:require [clojure.test :refer :all]
            [assignments.conditions :refer :all]))

(deftest safe-division
  (testing "non zero denominator"
    (is (= 2 (safe-divide 4 2))))
  (testing "zero denominator"
    (is (nil? (safe-divide 3 0)))))

(deftest informative-division
  (testing "non zero denominator"
    (is (= 2 (informative-divide 4 2))))
  (testing "zero denominator"
    (is (= :infinite (informative-divide 3 0)))))

(deftest harishchandra-test
  (testing "true"
    (is (= 2 (harishchandra 2))))
  (testing "false"
    (is (nil? (harishchandra false))))
  (testing "nil"
    (is (nil? (harishchandra nil)))))

(deftest yudishtira-test
  (testing "true"
    (is (= 2 (yudishtira 2))))
  (testing "false"
    (is (= :ashwathama (yudishtira false))))
  (testing "nil"
    (is (= :ashwathama (yudishtira nil)))))

(deftest duplicate-first-test
  (testing "list with 1 elemet"
    (is (= [1 1] (duplicate-first [1]))))
  (testing "list with more than 1 elemet"
    (is (= [1 1 2 3] (duplicate-first [1 2 3]))))
  (testing "nil arguments"
    (is (nil? (duplicate-first nil))))
  (testing "empty list"
    (is (nil? (duplicate-first [])))))

(deftest five-point-someone-test
  (testing "2nd arg is 5"
    (is (= :chetan-bhagat (five-point-someone 2 5))))
  (testing "1st arg is 5"
    (is (= :satan-bhagat (five-point-someone 5 10))))
  (testing "1st arg greater than 2nd arg"
    (is (= :greece (five-point-someone 10 2))))
  (testing "any other condition"
    (is (= :universe (five-point-someone 2 2)))))

(deftest conditions-apply-test
  (testing "arg contains 1 and 3 in that order"
    (is (= :wonder-woman (conditions-apply [1 5 3]))))
  (testing "arg contains :a :b and :c in that order"
    (is (= :durga (conditions-apply [:a :z :b :c]))))
  (testing "arg with [2 3] and [4 5] in this order"
    (is (= :cleopatra (conditions-apply [[2 3] [6 7] [4 5]]))))
  (testing "arg with random values"
    (is (= :tuntun (conditions-apply [:a 1])))))

(deftest repeat-and-truncate-test
  (testing "repeat true and truncate true"
    (is (= [0 1 2 3 0 1] (repeat-and-truncate [0 1 2 3] true true 6))))
  (testing "repeat true and truncate false"
    (is (= [0 1 2 3 0 1 2 3] (repeat-and-truncate [0 1 2 3] true false 6))))
  (testing "repeat false and truncate true"
    (is (= [0 1] (repeat-and-truncate [0 1 2 3] false true 2))))
  (testing "repeat false and truncate false"
    (is (= [0 1 2 3] (repeat-and-truncate [0 1 2 3] false false 2)))))

(deftest order-in-words-test
  (testing "when x greater than y"
    (is (= [:x-greater-than-y] (order-in-words 5 2 3))))
  (testing "when x greater than y and y greater than z"
    (is (= [:x-greater-than-y :y-greater-than-z] (order-in-words 5 3 2))))
  (testing "when z greater than x"
    (is (= [:z-greater-than-x] (order-in-words 2 3 5))))
  (testing "when x greater than y and z is greater than x"
    (is (= [:x-greater-than-y :z-greater-than-x] (order-in-words 3 2 5)))))

(deftest zero-aliases-test
  (testing "input is zero"
    (is (= :zero (zero-aliases 0))))
  (testing "input is empty vector"
    (is (= :empty (zero-aliases []))))
  (testing "input is empty unevaluated list"
    (is (= :empty (zero-aliases ()))))
  (testing "input is empty set"
    (is (= :empty-set (zero-aliases #{}))))
  (testing "input is empty map"
    (is (= :empty-map (zero-aliases {}))))
  (testing "input is empty string"
    (is (= :empty-string (zero-aliases ""))))
  (testing "input is non zero value"
    (is (= :not-zero (zero-aliases {:a 1})))))

(deftest zero-separated-palindrome-test
  (testing "valid input"
    (is (= [4 3 2 0 2 3 4] (zero-separated-palindrome [1 2 3]))))
  (testing "nil input"
    (is (= [0] (zero-separated-palindrome nil))))
  (testing "empty input"
    (is (= [0] (zero-separated-palindrome [])))))