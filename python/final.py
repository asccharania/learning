def innerProduct(x, y):
    res = []
    for nums in range(len(x)):
        for num in range(nums,nums+1):
            res.append(x[nums]*y[num])
    res = sum(res)
    return res
            
            
def digitsum(n):
    res = []
    num = str(n)
    for dig in num:
        res.append(int(dig))
    res = sum(res)
    return res 
        


import string
def wordcount(filename):
    infile = open(filename)
    text = infile.read()
    infile.close()

    table = str.maketrans(string.punctuation+'0123456789', (len(string.punctuation)+10)*' ')
    text = text.translate(table)
    
    words = text.split()
    d = {}
    for word in words:
        if len(word) > 2:
            if word not in d:
                d[word] = 1
            else:
                d[word] += 1
        else:
            pass
        
    for keys in d:
        print('{:15}'.format(keys), end = '')
        print('{}'.format(d[keys]), end = ' ')
        print()

    
    
    
        
from random import randrange
def manhattan():
    table = [[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],\
             [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],\
             [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],\
             [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],\
             [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],\
             [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],\
             [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],\
             [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],\
             [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],\
             [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],\
             [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],\
             [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],\
             [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],\
             [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],\
             [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],\
             [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],\
             [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],\
             [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],\
             [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],\
             [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],\
             [0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]]
 
    while True:
        x = 10
        y = 10
        if x >= 21 or y >= 21:
            break
        direction = randrange(1,5)
        if direction == 1:
            x += 1
            table[x][y] += 1
        elif direction == 2:
            x -= 1
            table[x][y] += 1
        elif direction == 3:
            y += 1
            table[x][y] += 1
        else: # direction == 4:
            y -= 1
            table[x][y] += 1
            
    for line in table:
        print(line)
        
    
    
