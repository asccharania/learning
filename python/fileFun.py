def numChars(filename):
    'Computes the number of Characters in a file'
    infile = open(filename)
    content = infile.read()
    infile.close()
    return(len(content))

def numWords(filename):
    'Computes the number of Words in a file'
    infile = open(filename)
    content = infile.read()
    infile.close()
    words = content.split()
    return(len(words))

def numLines(filename):
    'Computes the number of Lines in a file'
    infile = open(filename)
    lines = infile.readlines()
    infile.close()
    return(len(lines))
