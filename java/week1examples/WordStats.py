textFileName = input("Please enter the pathname of the input book file: ")
textFile = open(textFileName, "r")
bookText = textFile.read()
bookWords = bookText.split()
wordLengths = []
for word in bookWords:
    wordLengths.append(len(word))

print("The longest word has", max(wordLengths), "letters.")
print("The average word length is", sum(wordLengths)/len(wordLengths), "letters")
textFile.close()
