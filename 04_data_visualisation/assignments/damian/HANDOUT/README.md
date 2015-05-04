`-*- mode: markdown; mode: visual-line; mode: adaptive-wrap-prefix; -*-`

# DAMIAN

This is an attempt to create some serious contemporary digital art. Damien Hirst can do it with his ["spot" paintings](http://www.damienhirst.com/texts1/series/spots), but ours can be better, because they can move.

As with the Haiku exercise, the content is created with a Flask server; the D3 code repeatedly reads a JSON description from the server and lays it out. The main difference here is that we're doing graphics (with `SVG` elements), but the principles are the same. This example is slightly more complex because the number of elements might change dynamically; this is why we need to use the `enter()` and `exit()` methods.

Let's look at the files.

- `index.html`: as with most of our D3 exercises, there's hardly anything here, apart from some boilerplate code to load the various scripts and style sheets. The content goes into the `inner` `DIV` element. (We have an inner `DIV` inside the container in order to centre our frame.)

- `damian.js`: this is where all the front-end (browser) work is done. The code looks very similar to the Haiku example, except that we're working with circles, not paragraphs. Note the `enter()` and `exit()` calls.

- There's a slight wrinkle here: notice that the `.data` call has a second argument, a function:

        c = circle.data(json.result, function(d) { return +d.key; });
        
  This is used by D3 on each refresh, to tell whether the circles in the data are the same ones as on the last refresh, or new ones.
  
- There's a little bit of work to do in `damian.js` before it's fully functional - that's part of the exercise! - but it will run, and once fixed up it doesn't need to change for any of the "artworks".

- `run.py`: as with the Haiku example, a complete "app" comes in two parts: the enclosing HTML page (rendered from `index.html`) and the data feed "page", fetched by D3. The "Damian" exercise supports lots of artworks at the same time (useful for that high-profile gallery exhibition). Every artwork has a URL of the form

        http://localhost:8080/page/artyspots
        
  If you look inside `index.html` you'll see that I've used the templating to make the data URL correspond to the page URL. So, the above example would make D3 access `/data/artyspots/N`. This calls back into Flask via `run.py`, where code here (or in `logic.py`) generates the data.
  
  Another little wrinkle: that `N` is a counter, starting from 0, generated in the Javascript. This is so that the backend can rendering distinct "frames" for animating. (The backend can also ignore the counter, if it wants to do something else.)
  
- Look at the data for the simple example (`simple`). Everything here is *normalised*, which means data values fall between standard limits (in this case, 0.0 and 1.0). This means the backend doesn't need to worry about the size of the display frame, or the maximum dot size (which may be specific to the browser or device); the front-end and Javascript code deals with that.
