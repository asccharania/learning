##def wordcount(text):
##    'prints frequency of each word in text'
##    wordList = text.split()
##    counter = {}
##    for word in wordList:
##        if word not in counter:
##            counter[word] = 1
##        else:
##            counter[word] += 1
##    for key in counter:
##        print('{} appears {} times.'.format(key,counter[word]))
##            
##    
##    
    
def wordCount(text):
    'prints frequency of each word in text' 

    wordList = text.split()  # split text into list of words

    counters ={}             # dictionary of counters
    for word in wordList:   
        if word in counters: # counter for word exists
            counters[word] += 1
        else:                # counter for word doesn't exist
            counters[word] = 1

    for word in counters:    # print word counts
        if counters[word] == 1:
            print('{:8} appears {} time.'.format(word, counters[word]))
        else:
            print('{:8} appears {} times.'.format(word, counters[word]))
