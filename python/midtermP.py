def greeting(first, last):
    'prints greeting'
    print('Hello {}, {}! How you doin\'?'.format(last,first))

def pig(word):
    'returns pig-latin form of word'
    word = word.lower()
    if word[0] in 'aeiou':
        word = word + 'way'
    else:
        word = word[1:] + word[0] +'ay'
    return word
        

def pay(rate, hours):
    'returns wage based on rate and hours'
    if hours > 60:
        return ((hours-60)*(rate*2)) +(20*rate*1.5)+rate*40
    elif hours > 40:
        return ((rate*1.5)*(hours-40))+(rate*40)
    else:
        return rate*hours


def season(month):
    'prints season corresponding to month (an integer)'
    if month < 4:
        print('Winter')
    elif month < 7:
        print('Spring')
    elif month < 10:
        print('Summer')
    else:
        print('Fall')

    
def mult(lst,n):
    'prints numbers in lst that are multiples of n'
    for num in lst:
        if num % n == 0:
            print(num, end=' ')


def statement(transactions):
    'prints total deposit and withdrawals statement'
    deposits = []
    withdrawals = []
    for num in transactions:
        if num > 0:
            deposits.append(num)
        else:
            withdrawals.append(num)
    totalDep = sum(deposits)
    totalWit = sum(withdrawals)
    print('Total deposits: {}\nTotal withdrawals: {}'.format(totalDep,totalWit))
    
    
'''
def decrypt(filename):
    'returns hidden message in file filename'
    infile = open(filename, 'r')
    message = infile.read()
    infile.close()
    res = ''
    for char in range(len(message)):
        if char % 10 == 0: 
            res += message[char]
    return res
'''

def decrypt(filename):
    'returns hidden message in file filename'
    infile = open(filename, 'r')
    message = infile.read()
    infile.close()
    res = ''
    for char in range(0,len(message),10):
            res += message[char]
    return res 

        
