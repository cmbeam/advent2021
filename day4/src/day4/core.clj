(ns day4.core)

(defn readNumbers [file]
      (def inputs (list ))
      (with-open [rdr (clojure.java.io/reader file)]
                 (doseq [line (line-seq rdr)]
                        (def inputs(conj  inputs line ) ))
                 )
      (list inputs)
      )
(println (readNumbers "../../resources/input_day4.txt"))
