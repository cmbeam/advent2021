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

(defn increasesWithWindow [file]
  (def increaseCount 0)
  (def inputs (list "0" "0" "0"))
  (with-open [rdr (clojure.java.io/reader file)]
    (doseq [line (line-seq rdr)]
      (if (> (+ (Integer/parseInt line) (Integer/parseInt (nth inputs 0)) (Integer/parseInt (nth inputs 1))) (+ (Integer/parseInt (nth inputs 0)) (Integer/parseInt (nth inputs 1)) (Integer/parseInt (nth inputs 2))))
        (def increaseCount (+ increaseCount 1)))
      (def inputs(cons line inputs ) )
      )
    )
  (int (- increaseCount 3))
  )


(def increases (increases "../../resources/input_day1.txt"))
(println "Part 1: " increases)
(def increases (increasesWithWindow "../../resources/input_day1.txt"))
(println "Part 2: " increases)
