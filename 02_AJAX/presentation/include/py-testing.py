def filesToDict(listOfFiles):
    '''
    >>> sorted(filesToDict(['test/testRead1.txt','test/testRead2.txt']).items())
    [('test/testRead1.txt', 'one\\ntwo\\n'), ('test/testRead2.txt', 'three\\nfour\\nthree\\n')]
    '''
    return {f: open(f).read() for f in listOfFiles }
