`-*- mode: markdown; mode: visual-line; mode: adaptive-wrap-prefix; -*-`

# SHAKESPEARE PIE

We can take the code and data from the last Shakespeare exercise and use it to display word counts in a pie chart.

The handout code has some hard-wired pie patterns, with text. Can you modify this to display the Shakespeare data? Steps:

- Think about what data gets passed as JSON from the Flask server to the page. It's similar to the data used for the spots examples.

- Can you adapt the Shakespeare code from the earlier exercise to generate data in the same format?

- The buttons in the handout code call different URLs to get the different patterns. You should adapt this code so that there is one URL for fetching data, where the word is part of the URL. For example:

        @app.route('/data/<word>')
        def shakespeare(word):
            [... generate data for word ...]
            
- Specify the actual search words in Flask:

        searchWords = ["love", "hate",
                       "king", "queen",
                       "country", "kingdom",
                       "army", "navy",
                       "revenge", "justice",
                       "romeo", "asjasjasjasj"]

  How can you use this list to generate the buttons on the page? (Use the Jinja2 templating system.)

- Notice that the text in the Shakespeare pie is actually rotated, to read out of (or into) the centre of the pie. Can you work out how to do this? (Do some googling to see how it's done in the examples. We're already using this technique to put the text in the right place.)

- In some of the Shakespeare word searches, play titles appear to overlap. Why does this happen? How would you prevent it?

- Notice that, in the original example, the labels jump to their end point before the segments start to move. This is rather untidy. If you want to try to transition them to their new locations, have a go! Otherwise, do what I did and remove the labels before the transition and put them back at the end. (Look at the Haiku example for hints on how to do this.)

- The last button (which returns no matches) actually blows up the arc generator; it remains broken until you refresh the page. Can you work out why? Can you prevent it?
  
## BONUS

- Can you replace the buttons with a text field, to search for any word?
- There are better options for positioning the text (so that it doesn't overflow the frame)
