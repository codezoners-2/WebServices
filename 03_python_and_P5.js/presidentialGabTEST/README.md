## **Quick demo from me**
1. What is this exercise about
2. How is it different from shakespeareInteractive
  * `freqAnalyzer` uses regular expressions
  * `freqAnalyzerNorm` normalises for speech length (10.000 words)
  * added function `multiFreqAnalyserNorm`
  * the data structure we're going after

## presidentialGab
SOMETHING ABOUT THIS ASSIGNMENT

### back end
1. Open the `logic.py` and implement the function `prepareJSON` that takes a search term and the dictionary with the results as provided by the `multiFreqAnalyserNorm` function and returns a JSON object. It takes a dictionary like this:
```
{
	"data/1790.1.8,George Washington,federalist": 10,
	"data/1994.1.3,William J. Clinton,democrat": 30,
	"war")
}
```
and returns a JSON object like this:
```
'{
	"statistics": [
		{ "year": 1790, "month": 1,
		  "party": "federalist",
		  "president": "George Washington",
		  "freq": 10,
		  "day": 8}
		{ "year": 1994, "month": 1,
		  "party": "democrat",
		  "president": "William J. Clinton",
		  "freq": 30,
		  "day": 3}
		],
	"startyear": 1790,
	"endyear": 1790,
	"minfreq": 10,
	"maxfreq": 30,
	"searchterm": "war",
	"totalentries": 2,
}'
```
I've already provided the test to make your life easier. To run the test, execute `python -m doctest logic.py`. To implement the function follow these steps:
  * create an empty list called `stats`. This is where we are going to store
  * for all tuples in the `statisticsDict` dictionary  (ie `for speechdata, freq in statisticsDics.items()`) do the following (note the indentation):
    * create an empty dictionary `tempDict`
    * get rid of the `data/` path so that you keep only the filename. You'll need to use slicing to do that and use `rfind` to find the last `/` in order to slice there. Save the cleanedup string in a variable called speech.
    * using `split()` split the string at the commas (`,`), get the first element which is the date, do a further split on the dots and get the first element which should be the year. All this can and should be on one line. Save the value extracted in the `tempDict` dictionary under the key `year`.
    * using the above technique extract the month, day, president's name and party and save them each under the following keys: `month`,`day`,`president`,`party`.
    * save the `freq` value from the `for` statement under the key `freq` in the `tempDict`
    * append `tempDict` in the `stats` list
  * create an empty dictionary called `results`
  * create an entry with the key name `totalentries` and give it a value equal to the total number of entries in the `stats` list
  * create an entry with the key name `maxfreq` and give it a value equal to the maximum frequency in the stats list. You can do this effectively with a list comprehension. This command: `[entry["freq"] for entry in stats]` creates a list of all the frequencies in the stats list. Combine it with `max()` to find the maximum value.
  * Do the same for calculating the minimum frequency, the earliest year of a speech and the latest year of a speech and store them in the `results` dictionary under the key names, `minfreq`,`startyear` and `endyear` respectively.
  * Save the `term` parameter in an entry in the `results` dictionary under the key `searchterm`
  * Save the `stats` list you created in the previous step in the `results` dictionary under the key `statistics`
  * Use the `json.dumps()` function to convert the `results` dictionary into a JSON object and save it in a variable called `statsJSON`.
  * finally return the `statsJSON` object
  * you can now run `python logic.py data/*` and it should print on screen both the table of frequencies as well as the JSON object itself.
2. Open the `presitentialGab.py` file and in the `search` function which will handle the search queries add the following lines:
  * add an `if` statement which checks if the `term` has anything in it and if it does:
    * create a `statisticsDict` variable and store in it the value returned by the `multiFreqAnalyserNorm()` function. The latter takes two parameters. The `corpus` and the `term` that we want to search.
    * create a `statisticsJSON` variable and store in it the value returned by the `prepareJSON()` function. The latter takes two parameters. The `statisticsDict` generated in the previous step and the `term`.
    * return the `statisticsJSON`
  * else if the `term` is empty return an empty dictionary (ie `{}`)

### front end








2. Create a function `extractStateName(aString)` which takes a string and returns the full name of a extracted state. Returns `None` if no match is found. Follow these steps:
  * study the data **first**. Take a look at what it is you are trying to extract. What similarities do you see between all the strings? What types of data are going to be the input to your regex?
  * knowing what types of data you are going to be processing, create a test **before** proceeding with code. **Attention**: some states are one word (Nevada), some are more than one (New Hampshire) and some include dots (Washington D.C.). Make tests for each of them. (Hint: you test the file by running the `python -m doctest logic.py` command)
  * You should also make a test for the empty string (simulating a no match). You can test if `is None` (copy-paste this code) returns `True` (just like we were doing dictionary comparisons). So you would have something like this in the test line: ```extractStateName('yourStringHere') is None```
  * Now that all the tests fail, you're ready to code. Open the *simpleRegex.py* example and see how a simple regex operation takes place. Copy that code and instead of the `print()` statements, have the code return the result. How could you deal with the fact that states are not always one word? (Hint: you could use square brackets[]).
  * Once you manage to extract the substring that's needed, you still have the patterns you used to identify where the state is. Since the length of these is standard, you can remove them using a simple slicing operation, and returning its result

3. Create a function `extractStateAbbr(aString)` which takes a string and returns the **capitalized** abbreviation of the state. Returns `None` if no match is found. Follow these steps:
  * study the data **first**. Take a look at what it is you are trying to extract. What similarities do you see between all the strings? You'll be using these similarities to extract the required data.
  * knowing what types of data you are going to be processing, create a test **before** proceeding with code. Make sure the returning value in the test is capitalized.
  * You should also make a test for the empty string (simulating a no match). You can test if `is None` (copy-paste this code) returns `True` (just like we did for `extractStateName(aString)`
  * Now that all the tests fail, you're ready to code. Write a regex that extracts the substring you need.
  * Use slicing to get rid of the surrounding characters and return the capitalized result? How do we capitalize a string?

4. Create a function `extractStateStats(aString)` which takes a string and returns the statistics/number associated with a state. Returns `None` if no match is found. Follow these steps:
  * study the data **first**. Take a look at what it is you are trying to extract. What similarities do you see between all the strings? You'll be using these similarities to extract the required data.
  * create a test **before** proceeding with code. The returning value in this test should be a number (not a string)
  * you should also make a test for the empty string (simulating a no match). Test for `None` as we did above.
  * now that all the tests fail, you're ready to code. Write a regex that extracts the substring you need. Notice the numbers in both files contain commas `,` and that one of the files' numbers contain periods `.`. You'll need to take that into consideration. What could you use?
  * once you number is extracted use slicing to remove the excess characters.
  * Python doesn't deal well with `,`. Before returning the number use the `replace()` function to replace the `,` with an empty string, effectively removing the `,`.
  * convert the resulting, lean string to a float, then to an int (getting rid of the decimal) and return that value

5. Create a function `linesToDict(myList)` which takes a list of strings and returns the data we need in a well structured dictionary.
  * start designing a test **first**. We want this function to take a list of strings, so put **1** example string, in a 1 element **list** in the test and have it expect something like this: `{'CA': ['California', 37253956]}`. What the function should return is a dictionary whose keys are the capitalized state abbreviations and whose values are the full name and statistics of the states in a list of length 2.
  * Once your test fails, start by writhing the code following these steps (pay attention to the indentation):
  * create an empty dictionary `resultsDict`
  * loop over `myList` and for each element `c` in the list
    * call `extractStateAbbr`, passing to it `c` and store the returning value to `abbr`
    * copy-paste this: `if abbr is not None:` (if we actually found a state abbreviation we try getting the other values)
      * call the `extractStateName` passing `c` and store the returning value to `stateName`
      * call the `extractStateStats` passing `c`  and store the returning value to `stateStats`
      * add an entry with key `abbr` in the `resultsDict` with value equal to a list made up of `stateName` and `stateStats`
  * return `resultsDict`

