(ns sublist)

(defn classify [list1 list2] ;; <- arglist goes here
      ;; your code goes here
  (let [list-1-partitions (partition (count list2) 1 list1)
        list-2-partitions (partition (count list1) 1 list2)
    
        ]
    (cond 
      (= list1 list2) :equal
      (seq(filter #(= list1 %) list-2-partitions)) :sublist
      (seq(filter #(= list2 %) list-1-partitions)) :superlist
      :else :unequal))
  
  
  ;(subset? list1 list2)
)

