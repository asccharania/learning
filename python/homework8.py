# Problem 6.34
from random import randint
def game(n):
    try:
        correct = 0
        for x in range(n):
            num1 = randint(0,9)
            num2 = randint(0,9)
            print('{} + {} = '.format(num1,num2))
            sol = int(input('Enter Answer: '))
            if sol == (num1 + num2):
                print('Correct')
                correct += 1
            else:
                print('Incorrect')
        print('You got {} correct answers out of {}'.format(correct, n))
    except:
        print('Please enter an integer')




# Problem 6.27
def index(filename, words):
    '''prints a mapping of words from list words to all the line
       numbers of lines in which the words appear in file filename'''
    d = {}
    infile = open(filename)
    lines = infile.readlines()
    infile.close()
    for x in range(len(lines)-1):
        for y in words:
            if y in lines[x]:
                if y not in d:
                    d[y] = [x+1]
                else:
                    d[y].append(x+1)
 
    for keys in d:
        print('{:10}'.format(keys), end = '')
        for values in d[keys]:
            print('{}'.format(values), end = ', ')
        print()

        
# Problem 3
def quicksum(line):
    lst = []
    lst.append(line)
    product = []
    for word in lst:
        for letter in range(0,len(word)):
            if word[letter] == ' ':
                continue 
            else:
                pos = letter + 1
                alph = ord(word[letter]) - ord('A') + 1
                product.append(pos*alph)
                qs = sum(product)
    return qs

            

        
def testQuicksum():
    infile = open('quicksum.txt', 'r')
    line = infile.readline()
    while '-' not in line:
        print(quicksum(line[:-1]))
        line = infile.readline()
    infile.close()



# Problem 4
def hangman(secret):
    wrongGuess = 0
    hide = ''
    secret = secret.lower()
    for num in range(len(secret)):
        hide += '_'
        
    while wrongGuess < 7 and '_' in hide:
        print(hide)
        guess = str(input('Pick a letter: '))
        guess = guess.lower()
        if guess in secret:
            for char in range(len(secret)):
                if guess == secret[char]:
                    hide = hide.replace(hide[char],guess,1)
        else:
            wrongGuess += 1
            
    if wrongGuess == 7:
        print('You lost...')
    else:
        print(secret)
        print('You won!')


