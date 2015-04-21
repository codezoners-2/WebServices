# presidentialGab

## **Quick demo from me**
1. What is this exercise about
2. How is it different from shakespeareInteractive
  * `freqAnalyzer` uses regular expressions
  * `freqAnalyzerNorm` normalises for speech length (10.000 words)
  * added function `multiFreqAnalyserNorm`
  * the data structure we're going after
3. Examples of APIs using JSON:
  * [Spotify](https://developer.spotify.com/web-api/console/)
  * [The Guardian](http://open-platform.theguardian.com/)

In this exercise we're going to be learning how to server a JSON object from a flask server as well as how to read it via AJAX calls on a website and dynamically alter the contents of the DOM.

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
	"endyear": 1994,
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
    * using `split()` split the string at the commas (`,`), get the first element which is the date, do a further split on the dots and get the first element which should be the year. All this can and should be on one line. Save the value extracted in the `tempDict` dictionary under the key `year`. Convert the result to an integer by running the `int()` function
    * using the above technique extract the month, day, president's name and party and save them each under the following keys: `month`,`day`,`president`,`party`. Don't forget to convert to int the month and tha day.
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
2. Before you proceed make sure you have installed the `flask-cors` extension by running `sudo pip install flask-cors`. Then, open the `presitentialGab.py` file and in the `search` function which will handle the search queries add the following lines:
  * add an `if` statement which checks if the `term` has anything in it and if it does:
    * create a `statisticsDict` variable and store in it the value returned by the `multiFreqAnalyserNorm()` function. The latter takes two parameters. The `corpus` and the `term` that we want to search.
    * create a `statisticsJSON` variable and store in it the value returned by the `prepareJSON()` function. The latter takes two parameters. The `statisticsDict` generated in the previous step and the `term`.
    * return the `statisticsJSON`
  * else if the `term` is empty return an empty dictionary (ie `{}`)
  * run the flask server by running `python presidentialGab.py` and visit [http://localhost:8080/search/war](http://localhost:8080/search/war) to see how many times each president mentioned the word war.

## front end
### demo `modifyingElements` example
### setup function
1. create a canvas of size 1200x200 and save it in `canvas`
2. set the parent of canvas to `canvasID`
3. create an input and save it in the `keywordInput` variable
4. set the parent of keywordInput to `keywordInputID`
5. initialize `searchTermSpan` (hint: you need to call `createSpan`)
6. set the parent of searchTermSpan to `searchtermID`
7. create a button and give it the label `search`
8. set the button's parent to `keywordInputID`
9. add interaction to the button by adding this line `button.mousePressed(fetchStatistics);`
10. set the class of the button by adding this `button.class("btn btn-default");`
11. initialize `speechDataSpan` (hint: you need to call `createSpan`)
12. set the parent of speechDataSpan to `speechDataID`
13. fetch the value of the `keywordInput` field and save it in `searchTerm` (hint: you'll need to use the `value()` function)
14. set the value of the `searchTermSpan` equal to the `searchTerm`.  (hint: you'll need to use the `html()` function). Also, uncomment the next line. This is the line that fetches the JSON file. 
15. read the jsonobject's `minfreq` variable and save it inside a variable called `minfreq`.
16. Do the same for maxfreq
17. Do the same for startyear
18. Do the same for endyear
19. Do the same for total entries
20. Now we're inside the for loop because we want to traverse inside the statistics list. We'll use `x` of the loop as an index on the `statistics` list of the `jsonobject` and get the party (Hint: `jsonobject.statistics[x].party;`). Save the return value in a variable called `party`.
21. Do the same for year and freq. The next lines plot the ellipses based on the values you got from the statistics table. In the section marked as `SETTING HTML STRING` I am building a string to display under the table. Notice that the string is normal html code.
22. Set the contents of `speechDataSpan` to `htmlString` (Hint: you'll need to use the `html()` function)
