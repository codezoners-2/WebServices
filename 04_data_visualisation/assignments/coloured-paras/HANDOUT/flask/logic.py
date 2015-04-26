import sys
import functools

def filesToDict(listOfFiles):
    '''
    >>> sorted(filesToDict(['test/testRead1.txt','test/testRead2.txt']).items())
    [('test/testRead1.txt', ['one', 'two']), ('test/testRead2.txt', ['three', 'four', 'three'])]
    '''
    return { f: open(f).read().splitlines() for f in listOfFiles }
