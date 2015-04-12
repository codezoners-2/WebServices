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

                   (include-code "jasmine.txt")]]

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



                 ])
