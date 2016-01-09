def growthrates(n):
    'prints values of below 3 functions for i = 1, ..., n'
    print(' i   i**2   i**3   2**i')
    formatStr = '{0:2d} {1:6d} {2:6d} {3:6d}'
    for i in range(2, n+1):
        print(formatStr.format(i, i**2, i**3, 2**i))



def numChars(filename):
    'returns the number of characters in file filename'
    infile = open(filename, 'r')
    content = infile.read()
    infile.close()

    return len(content)



def numWords(filename):
    'returns the number of words in file filename'
    infile = open(filename, 'r')
    content = infile.read()       # read the file into a string
    infile.close()

    wordList = content.split()    # split file into list of words
    print(wordList)               # print list of words too
    return len(wordList)



def numLines(filename):
    'returns the number of lines in file filename'
    infile = open(filename, 'r')   # open the file and read it
    lineList = infile.readlines()  # into a list of lines
    infile.close()

    print(lineList)                # print list of lines
    return len(lineList)


