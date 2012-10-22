(ns leiningen.new.misaki
  (:use [leiningen.new.templates :only [renderer name-to-path ->files]]))

(def render (renderer "misaki"))

(defn misaki
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)
              :year     "{{year}}"
              :month    "{{month}}"
              :filename "{{filename}}"
              :line     "{{line}}"
              :message  "{{message}}"}]
    (->files data
             ;["src/{{sanitized}}/foo.clj" (render "foo.clj" data)]
             ["_config.clj" (render "_config.clj" data)]
             ; templates
             ["template/atom.xml.clj"   (render "atom.xml.clj" data)]
             ["template/index.html.clj" (render "index.html.clj" data)]
             ; layouts
             ["template/layouts/default.clj" (render "layouts/default.clj" data)]
             ["template/layouts/post.clj"    (render "layouts/post.clj" data)]
             ["template/layouts/tag.clj"     (render "layouts/tag.clj" data)]
             ; posts
             ["template/posts/2011-01-01-post1.html.clj" (render "posts/2011-01-01-post1.html.clj" data)]
             ["template/posts/2012-02-02-post2.html.clj" (render "posts/2012-02-02-post2.html.clj" data)]
             ; js
             ["public/js/lang-clj.js" (render "js/lang-clj.js" data)]
             ["public/js/prettify.js" (render "js/prettify.js" data)]
             ["public/js/main.js"     (render "js/main.js" data)]
             ; css
             ["public/css/prettify.css"   (render "css/prettify.css" data)]
             ["public/css/main.css"       (render "css/main.css" data)]
             ["public/css/smartphone.css" (render "css/smartphone.css" data)]
             ["public/css/extra.css"      (render "css/extra.css" data)]
             )))
