`-*- mode: markdown; mode: visual-line; mode: adaptive-wrap-prefix; -*-`

# flask-db-example

This is a simple comment-message application. When a message is posted, it is timestamped and added to the database.

The `Message` class has a timestamp and some text content. The timestamp has a default value (the current date/time when created).

If the main page is posted from the form, and if there's a text field (`term`), then add a new message to the database. In all cases, list out all messages, in reverse date order.
