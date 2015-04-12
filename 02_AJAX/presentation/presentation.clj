(render :theme :sky
        :title "Data Visualisation"
        :author "Nick Rothwell"

        :slides [[:section
                  (heading "Web Services: AJAX")
                  (subheading "Nick Rothwell")]

                 [:section
                  [:section
                   (subheading "Where We're Going")

                   (image "d3.png")]]

                 [:section
                  [:section
                   (heading "AJAX")

                   [:ul
                    [:li [:strong "A"] "synchronous"]
                    [:li [:strong "J"] "avascript"]
                    [:li [:strong "A"] "nd"]
                    [:li [:strong "X"] "ML"]]]

                  [:section
                   (subheading "AJAX")

                   [:ul
                    [:li "Request page content without refreshing the entire page"]
                    [:li "Request via HTTP (using Javascript)"]
                    [:li "Response via JSON (so much for XML)"]
                    [:li "Update page (DOM) in place, using React, D3.js, ..."]]]]

                 [:section
                  [:section
                   (heading "Meanwhile...")
                   (subheading "Unit Testing in Javascript")

                   [:ul
                    [:li "Python: tests embedded in the application code"]]

                   (include-code "py-testing.py")]

                  [:section
                   (subheading "Unit Testing in Javascript (and Java and...)")

                   [:ul
                    [:li "Separate test suite"]]

                   (include-code "adder.js")
                   (include-code "adder-test.js")

                   [:ul
                    [:li "Testing with " [:a {:href "http://jasmine.github.io/"} "Jasmine"]]]]
                  ]

                 [:section
                  [:section
                   (heading "Yak Shaving")
                   (subheading "Installing Jasmine")

                   [:ul
                    [:li "Install NodeJS (for running JS programs)"]
                    [:li "Install " (tt "jasmine") " using NPM"]]]

                  [:section
                   (subheading "NodeJS (OS X)")

                   [:ul
                    [:li "Install " [:a {:href "http://brew.sh/"} "Homebrew"]]
                    [:li "You will need to have " [:a {:href "https://itunes.apple.com/us/app/xcode/id497799835"} "Xcode"] " installed (this is " [:strong "big"] ")"]
                    [:li "Install NodeJS with " (tt "brew install node")]]]

                  [:section
                   (subheading "NodeJS (Windows)")

                   [:ul
                    [:li "Use the " [:a {:href "https://nodejs.org/download/"} "installer"]]]]

                  [:section
                   (subheading "Jasmine")

                   [:ul
                    [:li "OS X: " (tt "sudo npm install -g jasmine")]
                    [:li "Windows: " (tt "npm install -g jasmine")]]

                   [:p "If everything works, you can now just say " (tt "jasmine") "."]]]

                 [:section
                  [:section
                   (heading "Testing with Jasmine")

                   [:ul
                    [:li "Create a new project directory with " (tt "jasmine init")]
                    [:li "Test files are in " (tt "spec/*spec.js")]]

                   (include-code "jasmine.txt")]

                  [:section
                   (subheading "Dependencies")

                   [:ul
                    [:li "Jasmine runs the " [:emph "spec"] " file"]
                    [:li "The spec file must " (tt "require") " the source file"]
                    [:li "The source file must add its functions to " (tt "exports")]]

                   [:p "(This is all NodeJS package machinery.)"]]]

                 [:section
                  [:section
                   (heading "Exercise &frac12;")
                   (subheading "Unit Testing Revisited")

                   [:ul
                    [:li "We've ported the test examples from " (github "codezoners-2/AgileDevelopment/tree/master/01_basic_testing/assignments/fixme-1/HANDOUT" "Python") " to Javascript"
                     " (and from DocTest to Jasmine)"]
                    [:li "Repeat the exercise in Javascript"]]

                   [:p "(Exercise " (github "codezoners-2/WebServices/tree/master/02_AJAX/assignments/fixme-1/HANDOUT" "here") ".)"]

                   ]
                  ]

                 [:section
                  [:section
                   (heading "AJAX, React and jQuery")

                   [:ul
                    [:li "AJAX is built on web standards (XHR)"]
                    [:li "Many frameworks wrap XHR into their own API (D3.js, jQuery, ...)"]
                    [:li "We can use React to modify a page dynamically (on a response)"]
                    [:li "Trickiness: the " [:strong "A"] " in " [:strong "A"] "JAX"]
                    ]]

                  [:section
                   (subheading "Everything is a Callback")

                   [:ul
                    [:li "Send request to the server with a callback function to trigger"
                     " when the reply arrives (sometime later)"]]

                   (include-code "ajax-jquery.js")
                   ]

                  [:section
                   (subheading "Data comes back (usually) as JSON")

                   [:ul
                    [:li "Convenient Javascript-like notation"]
                    [:li "Can be read directly by browser's Javascript"]]

                   [:p "Example data: " [:a {:href "https://api.github.com/users/octocat/gists"}
                                         "Octocat's Gists"]]]
                  ]

                 [:section
                  [:section
                   (heading "Round Trip: Fetching Gists")

                   [:ul
                    [:li "A " [:emph "gist"] " is a quick note containing programming code,"
                     " in any language, formatted/highlighted by GitHub"]]

                   [:p "(Octocat's " [:a {:href "https://gist.github.com/octocat"} "gists"] ".)"]]

                  [:section
                   (subheading "Connecting with React")

                   [:p "(Source " [:a {:href "..."} "here"] ".)"]

                   [:p "Overview:"]

                   (include-code "gist-react-1.js")
                   ]

                  [:section
                   (subheading "Setup")

                   [:p "The initial state is an empty list (of gists)"]

                   (include-code "gist-react-2.js")

                   ]

                  [:section
                   (subheading "Doing the AJAX Call")

                   [:p "This is fired when React mounts the component into the page"]

                   (include-code "gist-react-3.js")

                   ]

                  [:section
                   (subheading "Rendering")

                   [:p "Called first, on load; called again when data comes in"]

                   (include-code "gist-react-4.js")

                   ]
                  ]

                 [:section
                  [:section
                   (heading "Exercise 1")
                   (subheading "More Information...")

                   (image "gists-more.png")

                   [:p "Start with the " [:a {:href ""} "handout code"] "."]

                   ]

                  [:section
                   (subheading "Can you...")

                   [:ul
                    [:li "Make the gists into hyperlinks (rather than just text)?"]
                    [:li "Include the gist filename and language in each entry (a bit harder...)?"]
                    [:li "(Using Bootstrap) render three columns, for three different users?"]
                    [:li "(Bonus!) select users from a menu or button bar?"]]]]])
