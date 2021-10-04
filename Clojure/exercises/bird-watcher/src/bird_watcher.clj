(ns bird-watcher)

(def last-week 
  [0 2 5 3 7 8 4]
  )
(def birds-per-day
   [0 2 5 3 7 8 4]
  )

(defn today [birds]
  (last birds)
  )

(defn inc-bird [birds]
  (update birds (- (count birds) 1) inc)
  )

(defn day-without-birds? [birds]
    #_(nil? (seq
           (filter 
              zero?
            birds)))
  (->> birds
    (filter zero?)
    (count)
    (< 0)))

(defn n-days-count [birds n]
  (reduce + (take n birds))
  )

(defn busy-days [birds]
  (count(filter #(>= % 5) birds))
  )

(defn odd-week? [birds]
  (every? 
   #(= '(1 0) %)
   (partition 2 2 (repeat 0) birds))
  )
