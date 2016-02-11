(defproject javascript-externs-generator "0.1.0-SNAPSHOT"
  :description "JavaScript Externs Generator"
  :url "http://jmmk.github.io/javascript-externs-generator"

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [re-frame "0.4.1"]
                 [re-com "0.5.4"]
                 [org.clojure/clojurescript "0.0-3308"]]

  :node-dependencies [[source-map-support "0.2.8"]]

  :plugins [[lein-cljsbuild "1.0.6"]
            [lein-doo "0.1.6"]
            [lein-figwheel "0.3.5"]]

  :source-paths ["src"]

  :clean-targets ^{:protect false} ["out"
                                    "out-adv"
                                    "assets/js/javascript_externs_generator.js"
                                    "target"]

  :figwheel {:css-dirs ["assets/css"]}
  :cljsbuild {
    :builds [{:id "test"
              :source-paths ["src" "test"]
              :compiler {:output-to "target/test.js"
                         :output-dir "target"
                         :target :nodejs
                         :main javascript-externs-generator.runner
                         :optimizations :none}}
             {:id "dev"
              :source-paths ["src"]
              :figwheel {:on-jsload "javascript-externs-generator.core/init"}
              :compiler {
                :main "javascript-externs-generator.core"
                :output-to "assets/js/javascript_externs_generator.js"
                :output-dir "out"
                :optimizations :none
                :cache-analysis true
                :source-map true}}
             {:id "release"
              :source-paths ["src"]
              :compiler {
                :output-to "assets/js/javascript_externs_generator.js"
                :output-dir "out-adv"
                :optimizations :advanced
                :pretty-print false}}]})
