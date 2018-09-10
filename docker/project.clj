(defproject aws-repl "0.1.0-SNAPSHOT"
            :description "Dependencies for Clojure development"
            :url ""
            :license {:name "CC0"
                      :url  "https://creativecommons.org/publicdomain/zero/1.0/legalcode"}
            :dependencies [[org.clojure/clojure "1.9.0"]
                           [com.taoensso/timbre "4.10.0"]
                           [alembic "0.3.2"]
                           [h2d2 "0.1.0-SNAPSHOT"]
                           [incanter "1.9.3"]
                           [kixi/stats "0.4.3"]
                           [net.mikera/core.matrix "0.62.0"]
                           [net.mikera/vectorz-clj "0.48.0"]
                           [clatrix "0.5.0"]
                           [uncomplicate/neanderthal "0.20.4"]
                           [clojure-opennlp "0.4.0"]
                           [nz.ac.waikato.cms.weka/weka-stable "3.8.3"]
                           [thinktopic/cortex "0.9.22"]
                           [org.tensorflow/tensorflow "1.10.0"]
                           [com.hypirion/clj-xchart "0.2.0"]
                           [hswick/jutsu "0.1.2"]]
            :exclusions [[org.jcuda/jcuda-natives :classifier "apple-x86_64"]
                         [org.jcuda/jcublas-natives :classifier "apple-x86_64"]]
            )
