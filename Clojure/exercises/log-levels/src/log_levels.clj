(ns log-levels
  (:require [clojure.string :as str]))

(def log-regex #"\[(.+)\]:\s+(.+)") 

(defn message
  "Takes a string representing a log line
   and returns its message with whitespace trimmed."
  [s]
  #_(str/trim (last(str/split s #":")))
  (str/trim (nth (re-find log-regex s) 2))
  )

(defn log-level
  "Takes a string representing a log line
   and returns its level in lower-case."
  [s]
  #_(clojure.string/replace 
   (clojure.string/lower-case (str/trim (first(str/split s #":"))))
   #"[|]" {"" ""})
  (clojure.string/lower-case(nth (re-find log-regex s) 1))
  
  )

(defn reformat
  "Takes a string representing a log line and formats it
   with the message first and the log level in parentheses."
  [s]
  (str/trim (str (message s) " " "(" (log-level s) ")"))
  )
