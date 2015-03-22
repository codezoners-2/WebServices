`-*- mode: markdown; mode: visual-line; mode: adaptive-wrap-prefix; -*-`

# SHAKESPEARE, COLOURED

An extension of the Shakespeare search application in Bootstrap. This time: multiple searches at the same time, results presented on the same page, in different colours. Use Bootstrap's stacked progress bars for display.

Issues:

- In the application code (`logic.py`): the `freqAnalyzer` function can be altered to take several search terms, and return several counts. How might this look?

- The kind of structure that gets passed into the template needs to change: rather than one result (count, and/or percentage) per line, you need to return three.

This is a major *refactoring* exercise: functions which dealt with a single value (argument, result) now have to deal with multiple values. Your unit tests will help greatly here: work out how the functions have to change, then modify the tests, then modify the code.

Modify in small steps: can you first change the functions to take multiple (or list) arguments and return list results, without changing much else? (An argument `x` to a function call can be passed as `[x]`, and used as `x[0]`.)
