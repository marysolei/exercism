(ns binary-search)

(defn middle [arr] ;; <- arglist goes here
  ;; your code goes here
  (let [high (dec(count arr))]
    (quot high 2)) 
)

(defn search-for [value arr] ;; <- arglist goes here
  ;; your code goes here
  (loop [myArr arr offset 0]
    (let [mid-indx (middle myArr)]
    (cond 
      (and (= 1 (count myArr)) (not= (nth myArr 0) value))
      (throw (Exception. "not found"))
      
      (< value (nth myArr mid-indx)) 
      (recur(take mid-indx myArr) offset)
      
      (> value (nth myArr mid-indx)) 
       (recur(take-last (- (dec(count myArr)) mid-indx) myArr) (+ offset (inc mid-indx)))
      
      (= value (nth myArr mid-indx)) 
       (+ mid-indx offset)
    
      )))
    
)

