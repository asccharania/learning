textFileName = "../../data/twotales.txt"
textFile = open(textFileName, "r")
bookText = textFile.read()
bookWords = bookText.split()
print("There are", len(bookWords), "words in", textFileName)
textFile.close()
