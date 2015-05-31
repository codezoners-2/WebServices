(render :theme :sky
        :title "MongoDB"
        :author "Nick Rothwell"

        :slides [[:section
                  (heading "MongoDB")
                  (subheading "Nick Rothwell")]

                 [:section
                  [:section
                   (heading "Databases")

                   [:ul
                    [:li "Relational (table-based) - MySQL, Oracle, PostgreSQL, ..."]
                    [:li "Structured/'NoSQL' - CouchDB, MongoDB, ..."]]

                   [:p "NoSQL databases usually simpler, more scalable, less powerful"]]]

                 [:section
                  [:section
                   (heading "Software as a Service (SaaS)")

                   [:ul
                    [:li "Subscription model"]
                    [:li "Web availability"]]

                   [:p "Heroku: Platform as a Service (PaaS)"]
                   [:p "MongoLab (" (link "http://mongolab.com") "): MongoDB as a service"]
                   ]]

                 [:section
                  [:section
                   (heading "Signing up for MongoLab")

                   [:ul
                    [:li "Sign up for an account"]
                    [:li "Create a few database"]

                    ]

                   ]

                  [:section
                   (image "mongolab-create.png")

                   [:p "(With database name, user name and password)"]
                   ]

                  ]

                 [:section
                  [:section
                   (heading "MongoDB Structure")

                   [:ul
                    [:li "Mongo databases contain " [:i "collections"]]
                    [:li "Each collection contains " [:i "documents"]]]

                   ]

                  [:section
                   (heading "MongoDB and Python")

                   [:p "We'll be using an " [:i "ORM"] " (Object Relational Mapping)"]

                   [:p "(Converts between Python objects and database documents)"]

                   [:p "The ORM library is called " (tt "mongoengine")]

                   (include-code "install-mongo.py")]]

                 [:section
                  [:section
                   (heading "Getting started")
                   (include-code "mongo-start.py")

                   [:p "(Note the " (tt "raw_input") " to avoid storing a password in the code)"]
                   ]

                  [:section
                   (heading "Document Classes")
                   (include-code "person.py")]

                  [:section
                   (heading "Creating Documents")
                   (include-code "create-person.py")]

                  [:section
                   (heading "Listing Documents")
                   (include-code "list-persons.py")]

                  [:section
                   (image "list-db.png")]

                  [:section
                   (heading "Deleting Documents")
                   (include-code "delete-persons.py")

                   [:p "(This example also performs a custom " [:i "query"]]]]
                 ])
