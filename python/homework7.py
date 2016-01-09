# Problem 6.11
def easyCrypto(s):
    '''prints the following encryption of s: Every character at an odd
       position i in the alphabet is encrypted with the character at
       position i + 1, and every character at an even position i will
       be encrypted with the character at position i − 1'''
    res = ''
    for letter in s:
        a = ord(letter)
        if a % 2 != 0:
            a += 1
            res += chr(a)
        else:
            a -= 1
            res += chr(a)
    print(res) 
    


# Problem 6.21
def ticker(filename):
    '''file filename contains company names and stock (ticker) symbols
       in the format:
           company 1 name
           company 1 stock symbol
           company 2 name
           company 2 stock symbol
           ...
        function provides an interface through which the stock symbol
        for a given company can be obtained'''
    counter = {}
    infile = open(filename)
    while True:
        line = infile.readline()
        line2 = infile.readline()
        counter[line.strip()] = line2.strip()
        if line == '':
            query = str(input('Enter Company name: '))
            if query == '':
                break
            else:
                query = query.upper()
                print('Ticker symbol: {}'.format(counter[query]))
    
    
        
# Problem 6.22
def mirror(word):
    '''returns mirror image of word but if it can be represented
       using letters in the alphabet'''
    res = ''
    d = {'d':'b',
         'b':'d',
         'i':'i',
         'o':'o',
         'u':'u',
         'v':'v',
         'w':'w',
         'x':'x'}
    for x in range(len(word)-1,-1,-1):
        if word[x] in d:
            res += d[word[x]] 
        else:
            return 'INVALID'
    return res 
            

# Problem 6.23
import string
def scaryDict(filename):
    '''prints, and writes to file dictionary.txt, all the words
       in file filename, in alphabetical order; one- and two-letter
       words are ignored'''
    infile = open(filename)
    text = infile.read()
    infile.close()

    table = str.maketrans(string.punctuation+'0123456789', (len(string.punctuation)+10)*' ')
    text = text.translate(table)
    
    words = text.split()
    d = {}
    for word in words:
        if word not in d and len(word) > 2:
            d[word] = 1
            
    lst = []
    for word in d.keys():
        lst.append(word)
    lst.sort()
    outfile = open('dictionary.txt','w')
    for word in lst:
        outfile.write(word+'\n')
    outfile.close()
    
    
# Problem 6.30
import random 
def simul(n):
    options = ['R','P','S']
    player1Wins = 0
    player2Wins = 0
    for x in range(0,n):
        play1 = random.choice(options)
        play2 = random.choice(options)
        if play1 == play2:
            player1Wins += 1
            player2Wins += 1
        elif (play1 == 'R' and play2 == 'S') or (play1 == 'S' and play2 == 'P') or ( play1 == 'P' and play2 == 'R'):
            player1Wins += 1 
        else: #(play2 == 'R' and play1 == 'S') or (play2 == 'S' and play1 == 'P') or ( play2 == 'P' and play1 == 'R')
            player2Wins += 1
    if player1Wins == player2Wins:
        print('Tie')
    elif player1Wins > player2Wins:
        print('Player 1')
    else: #player1Wins < player2Wins
        print('Player 2')



# Problem 6.31
import random
def craps():
    'simulates a game of craps'
    roll = random.randrange(1, 7) + random.randrange(1, 7)
    if roll == 7 or roll == 11:
        return 1
    elif roll == 2 or roll == 3 or roll == 12:
        return 0
    else:
        while True: 
            roll2 = random.randrange(1, 7) + random.randrange(1, 7)
            if roll2 == 7:
                return 0
            if roll2 == roll:
                return 1 

        

def testCraps(n):
    'simulates n games of craps and returns the fraction of games won'
    wins = 0
    total = 0 
    for x in range(0,n):
        roll = random.randrange(1, 7) + random.randrange(1, 7)
        if roll == 7 or roll == 11:
            wins += 1
            total += 1 
        elif roll == 2 or roll == 3 or roll == 12:
            total += 1
        else:
            while True: 
                roll2 = random.randrange(1, 7) + random.randrange(1, 7)
                if roll2 == 7:
                    total += 1
                    break
                if roll2 == roll:
                    wins += 1
                    total += 1
                    break
    frac = wins/total
    return frac
            


if __name__ == '__main__':
    if easyCrypto('bax') != 'abc':
        print('Error in easyCrypto')
