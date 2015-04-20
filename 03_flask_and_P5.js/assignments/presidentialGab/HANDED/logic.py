import sys
import re
import json

def filesToDict(listOfFiles):
	'''
	>>> filesToDict(['testRead1.txt','testRead2.txt']) == {'testRead1.txt': 'one two\\n', 'testRead2.txt': 'three four three\\n'}
	True
	
	'''	
	return {f: open(f).read() for f in listOfFiles }

def freqAnalyser(fullWorksDict, keyword):
	'''
	returns number of times a word appears in the text
	
	>>> freqAnalyser({'testRead1.txt': 'one ntwo\\n', 'testRead2.txt': 'three four three\\n'}, 'tHree') == {'testRead1.txt': 0, 'testRead2.txt': 2}
	True
	
	>>> freqAnalyser(filesToDict(['testRead1.txt','testRead2.txt']), 'tHree') == {'testRead1.txt': 0, 'testRead2.txt': 2}
	True

	>>> freqAnalyser(filesToDict(['testRead1.txt','testRead2.txt']), 'tHre') == {'testRead1.txt': 0, 'testRead2.txt': 0}
	True
	'''
	#we are checking for exact full word matches. The search string "we" won't be matched with "weather"
	return {opusName: len(re.findall(r"\b"+keyword.lower()+r"\b", content.lower())) for opusName, content in fullWorksDict.items()}
	
def freqAnalyserNorm(fullWorksDict, keyword):
    '''
    normalizes speech length by returning freq per 10k words
    
    >>> sorted(freqAnalyserNorm({'testRead1.txt': 'one two\\n', 'testRead2.txt': 'three four three\\n'}, 'tHree').items())
    [('testRead1.txt', 0), ('testRead2.txt', 6666)]

    >>> sorted(freqAnalyserNorm({'testRead1.txt': 'one two three THREE three\\n','testRead2.txt': 'three four three\\n'},'tHree').items())
    [('testRead1.txt', 6000), ('testRead2.txt', 6666)]
    '''
    corpus = freqAnalyser(fullWorksDict, keyword)
    return {opusName: ((freq * 10000) // len(fullWorksDict[opusName].split())) for opusName, freq in corpus.items()}

def multiFreqAnalyserNorm(fullWorksDict, keywords):
	results = {}
	for k in keywords.split(","):
		for opusName, freq in freqAnalyserNorm(fullWorksDict,k).items():
			results[opusName] = results.get(opusName, 0) + freq
	return results
	
def prepareJSON(statisticsDict, term):
	'''
	>>> json.loads(prepareJSON({"data/1790.1.8,George Washington,federalist": 10},"aTerm")) == json.loads('{"statistics": [{"year": 1790, "month": 1, "party": "federalist", "president": "George Washington", "freq": 10, "day": 8}], "startyear": 1790, "totalentries": 1, "endyear": 1790, "minfreq": 10, "maxfreq": 10, "searchterm": "aTerm"}')
	True
	
	'''
	return '{"dummy":"data"}'


# main provided in order to allow command line functionality
# not needed for the flask back end.
def main():
	arguments = sys.argv[1:]

	if not arguments:
		print "wrong usage"
		sys.exit(1)

	completeBodyOfTexts = filesToDict(arguments)

	keyword = raw_input("enter comma separated keywords: ")
	for opusName, freq in multiFreqAnalyserNorm(completeBodyOfTexts, keyword).items():
		print opusName + ": " + str(freq)
	
	dataDict = freqAnalyserNorm(completeBodyOfTexts, keyword)
	print prepareJSON(dataDict, keyword)

if __name__ == "__main__":
	main()
