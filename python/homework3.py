"""
Patrick Krebs
Homework 3

Paste the solutions to problems 4.12, 4.14, 4.15, 4.18, and 4.20 here:

4.12
>>> s = 'abcdefghijklmnopqrstuvwxyz'
>>> s[1:4]
'bcd'
>>> s[:3]
'abc'
>>> s[3:-2]
'defghijklmnopqrstuvwx'
>>> s[-4:-1]
'wxy'
>>> s[-4:]
'wxyz'

4.14
>>> log = '128.0.0.1 - - [12/Feb/2011:10:31:08 -0600] "GET /docs/test.txt HTTP/1.0"'
>>> log
'128.0.0.1 - - [12/Feb/2011:10:31:08 -0600] "GET /docs/test.txt HTTP/1.0"'
>>> address = log.split()[0]
>>> address
'128.0.0.1'
>>> date = log.split()[3][1:-1] + ' ' + log.split()[4][:-1]
>>> date
'12/Feb/2011:10:31:0 -0600'

4.15
>>> s = '10 20 30 40 50 60'
>>> s.split()
['10', '20', '30', '40', '50', '60']
>>> s = '10,20,30,40,50,60'
>>> s.split(',')
['10', '20', '30', '40', '50', '60']
>>> s = '10&20&30&40&50&60'
>>> s.split('&')
['10', '20', '30', '40', '50', '60']
>>> s = '10 - 20 - 30 - 40 - 50 - 60'
>>> s.split(' - ')
['10', '20', '30', '40', '50', '60']

4.18
>>> s = '''It was the best of times, it was the worst of times; it was the age of wisdom, it was the age of foolishness; it was the epoch of belief, it was the epoch of incredulity; it was ...'''
>>> table = str.maketrans('.,";\n',5*' ')
>>> newS = s.translate(table)
>>> newS
'It was the best of times  it was the worst of times  it was the age of wisdom  it was the age of foolishness  it was the epoch of belief  it was the epoch of incredulity  it was    '
>>> newS = newS.strip()
>>> newS
'It was the best of times  it was the worst of times  it was the age of wisdom  it was the age of foolishness  it was the epoch of belief  it was the epoch of incredulity  it was'
>>> newS = newS.lower()
>>> newS
'it was the best of times  it was the worst of times  it was the age of wisdom  it was the age of foolishness  it was the epoch of belief  it was the epoch of incredulity  it was'
>>> newS.count('it was')
7
>>> newS = newS.replace('was','is')
>>> newS
'it is the best of times  it is the worst of times  it is the age of wisdom  it is the age of foolishness  it is the epoch of belief  it is the epoch of incredulity  it is'
>>> listS = newS.split()
>>> listS
['it', 'is', 'the', 'best', 'of', 'times', 'it', 'is', 'the', 'worst', 'of', 'times', 'it', 'is', 'the', 'age', 'of', 'wisdom', 'it', 'is', 'the', 'age', 'of', 'foolishness', 'it', 'is', 'the', 'epoch', 'of', 'belief', 'it', 'is', 'the', 'epoch', 'of', 'incredulity', 'it', 'is']

4.20
>>> sender = 'tim@abc.com'
>>> recipient = 'tom@xyz.org'
>>> subject = 'Hello!'
>>> print('From: {}\nTo: {}\nSubject: {}'.format(sender,recipient,subject))
From: tim@abc.com
To: tom@xyz.org
Subject: Hello!

DO NOT PASTE BELOW THIS!!!
"""
def cheer(team):
    'prints a cheer for team s'
    print('How do you spell winner?\nI know, I know!\n{}!\nAnd that\'s how you spell winner! Go {}!'.format(team.upper(),team))


def vowelCount(text):
    'counts and prints the number of occurences of each vowel in s'
    vow = 'aeiou'
    print('a, e, i, o, and u appear, respectively, ', end = '')
    for v in vow:
        print(text.count(v),end = ", ")
    print('times.')
    
def crypto(filename):
    '''opens and prints file filename with the modification that
       every occurence of string 'secret' is replaced with 'xxxxx'
    '''
    infile = open(filename)
    secret = infile.read()
    infile.close()
    print(secret.replace('secret','xxxxxx'))
    
    
    


