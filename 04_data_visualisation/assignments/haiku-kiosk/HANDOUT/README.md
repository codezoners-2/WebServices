`-*- mode: markdown; mode: visual-line; mode: adaptive-wrap-prefix; -*-`

# HAIKU KIOSK

This is a "kiosk" which serves one haiku every 10 seconds. The template here is pretty empty; the following things need to be done.

- In `logic.py`: this needs to return some sort of structure - the "corpus" - which is built once, when the server starts. We did exactly the same in the Shakespeare server, but the data structure here is slightly different. Whatever you build, start with the unit tests! (I've provided test data files, as well as the entire haiku data set.)

- In `run.py`: a JSON data structure needs to be created and passed back to the client. What should this look like?

- `index.html` is ready to go, with empty paragraphs.

- In `haiku.js`, I've provided the outline: a function called `oneCycle` which is called every 10 seconds. It needs to get an AJAX call each time to get a new haiku; when this call finishes, use D3 to fade in the lines of the fresh haiku, and then fade them out again.
