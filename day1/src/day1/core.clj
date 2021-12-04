(ns day1.core)


(defn readFile [file]
  (def inputs (list ))
  (with-open [rdr (clojure.java.io/reader file)]
    (doseq [line (line-seq rdr)]
      (def inputs(conj  inputs line ) ))
      )
  (list inputs)
  )

(defn increases [file]
  (def increaseCount 0)
  (def inputs (list "0"))
  (with-open [rdr (clojure.java.io/reader file)]
    (doseq [line (line-seq rdr)]

      ;(println line)
      ;(println (first inputs))
      (if (> (Integer/parseInt line) (Integer/parseInt (first inputs)))
        (def increaseCount (+ increaseCount 1)) )
      (def inputs(cons line inputs ) )
      )

    )
  (int (dec increaseCount))
  )


(def coordinates (increases "../../resources/input_day1.txt"))
(println coordinates)
