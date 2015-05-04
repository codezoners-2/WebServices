(render :theme :sky
        :title "Data Visualisation"
        :author "Nick Rothwell"

        :slides [[:section
                  (heading "D3.js")
                  (subheading "Nick Rothwell")]

                 [:section
                  [:section
                   (heading "History Lesson")
                   (subheading "Computer Graphics")]

                  [:section
                   (subheading "The 1970s")

                   [:p "Tektronix TekScope 1"]

                   (image "Tektronix_TekScope_1.JPG")]

                  [:section
                   (subheading "Storage Tubes")

                   [:ul
                    [:li "Analogue vector control: no pixels"]
                    [:li "Write-only, with reset - no 'movement'"]]

                   (image "wizidd.gif")

                   [:p (youtube-link "T-F7ZySfgZ0" "video") "."]]

                  [:section
                   (subheading "The 1980s and Beyond")

                   (image "mac_control_panel1.gif")

                   [:p "Everything is pixels."]
                   ]]

                 [:section
                  [:section
                   (heading "Web Graphics")
                   (subheading "Pixels vs. Vectors")

                   [:ul
                    [:li "HTML Canvas (including p5.js): drawing into a pixel-based frame"]
                    [:li "SVG: creating structured vector-based graphical objects"]]
                   ]

                  [:section
                   (subheading "Why SVG?")

                   [:ul
                    [:li "Scalable, resolution-independent"]
                    [:li "Doesn't need Javascript"]
                    [:li "Elements are part of the DOM - can use JS libraries"]]]

                  [:section
                   (subheading "Why Canvas?")

                   [:ul
                    [:li "Performance"]]]
                  ]

                 [:section
                  [:section
                   (heading "D3.js")

                   (image "preview.png")
                   ]

                  [:section
                   (subheading "D3.js")

                   [:ul
                    [:li "JS library for manipulating the DOM (just like React)"]
                    [:li "Document manipulation based on data"]
                    [:li "Additional graphics support"]
                    ]
                   ]

                  [:section
                   (subheading "Highlights")

                   [:ul [:li "jQuery-like selectors"]]

                   (code "d3.selectAll(\"p\").style(\"color\", \"white\");")

                   ]

                  [:section
                   [:ul [:li "Dynamic properties"]]

                   (include-code "dynamic.js")]

                  [:section
                   [:ul [:li "Data binding"]]

                   (include-code "databind.js")

                   ]

                  [:section
                   [:ul [:li "AJAX"]]

                   (include-code "ajax.js")
                   ]
                  ]

                 [:section
                  [:section
                   (heading "Exercise 1")
                   (subheading "Coloured Paragraphs")

                   (image "coloured-paras.png")]

                  [:section
                   [:ul
                    [:li "The handout uses Flask to serve the main page, and a data page via AJAX"]
                    [:li "The data is a list of RGB colours"]
                    [:li "The paragraphs are coloured by D3.js based on this data"]
                    [:li "The font sizes are set up by D3.js as well, based on line number"]]]

                  [:section
                   [:ul
                    [:li "Alter the colours: make all the lines red (easy)"]
                    [:li "Randomise the colours"]
                    [:li "Make the colours into random greyscale"]
                    [:li "Alternate between two colours (evens and odds)"]
                    [:li "Blend between two colours: from red (top) to green (bottom)"]]

                   [:p "Everything here can be done in the server; the front-end doesn't change"]

                   [:p "(Template " (github "codezoners-2/WebServices/tree/master/04_data_visualisation/assignments/coloured-paras" "here") ".)"]
                   ]]

                 [:section
                  [:section
                   (heading "Transitions")

                   [:ul
                    [:li "Animate by transition from one DOM state to another"]
                    [:li "D3.js can " [:i "interpolate"] " from one value to another"
                     " (for common data types)"]
                    [:li "Can set " (tt "delay") " and " (tt "duration") " (as values or functions)"]]

                   (include-code "transition.js")]

                  [:section
                   (subheading "More Timing Support")

                   [:ul
                    [:li "Run a function periodically using " (tt "setInterval")]
                    [:li "Delay and run a function once using " (tt "setTimeout")]]

                   (code "setInterval(function () {...}, 5000);")
                   (code "setTimeout(function () {...}, 1000);")]

                  ]

                 [:section
                  [:section
                   (heading "Exercise 2")
                   (subheading "Haiku Kiosk")

                   (image "haiku.png")]

                  [:section
                   (subheading "Haiku Kiosk")

                   [:ul
                    [:li "A new random haiku is served every 10 seconds"]
                    [:li "Haikus are stored in files on the server"]
                    [:li "The display cycle fades in a haiku line by line, and fades it out again"]]

                   [:p "(Template " (github "codezoners-2/WebServices/tree/master/04_data_visualisation/assignments/haiku-kiosk/HANDOUT" "here") ".)"]


                   ]
                  ]

                 [:section
                  [:section
                   (heading "Graphics with SVG")

                   [:p "SVG is scalable vector graphics written in the web page"]

                   (include-code "svg.html")

                   (image-h 100 "spot.png")
                   ]
                  ]

                 [:section
                  [:section
                   (heading "Dynamic Selections")

                   [:p "How do we deal with varying amounts of data?"]

                   [:ul
                    [:li "Use the " (tt "enter") " method to deal with new data"]
                    [:li "Use the " (tt "exit") " method to deal with data that's removed"]]]

                  [:section
                   (subheading "Example (with SVG)")

                   (include-code "selections-1.js")

                   [:p "Data binding, as before, but we (probably) need a key function"]]

                  [:section
                   [:p "As before: set attributes for existing elements"]
                   (include-code "selections-2.js")]

                  [:section
                   [:p "The new stuff: set attributes for elements "
                    [:em "entering"] " or " [:em "exiting"] " the page"]

                   (include-code "selections-3.js")
                   ]

                  ]

                 [:section
                  [:section
                   (heading "Exercise 3")
                   (subheading "Kinetic Art")
                   (image "art-1.png")
                   ]

                  [:section
                   (image "art-2.png")]

                  [:section
                   [:ul
                    [:li "The example code provides two simple art pieces: " (tt "/page/simple")
                     " and " (tt "/page/stack")]

                    [:li "Can you implement the following examples (or better ones)?"]

                    [:li "(The D3.js code is almost - but not quite - complete."
                     " Can you work out what's missing?)"]

                    [:li "(Everything else can be done in Python: " (tt "run.py")
                     " and/or " (tt "logic.py") ")"]

                    ]]

                  [:section (video "d3-hal.mov")]
                  [:section (video "d3-dots.mov")]
                  [:section (video "d3-blink.mov")]
                  [:section (video "d3-shift.mov")]
                  [:section (video "d3-spin.mov")]]

])
