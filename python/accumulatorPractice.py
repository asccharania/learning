def factorial(n):
    'returns n! for input integer n'
    res = 1
    for i in range(1,n+1):
    	res *= i
    return res

def acronym(phrase):
    'return the acronym of the input string phrase'
    res = ''
    for word in phrase.split():
        res += word[0].upper()
    return res

def divisors(n):
    'return the list of divisors of n'
    res = []
    for i in range(1, n+1):
        if n % i == 0:
            res.append(i)
    return res


import math
def divisors2(n):
    'return the list of divisors of n'
    res = []
    for i in range(1, math.ceil(math.sqrt(n))+1):
        if n % i == 0:
            res.append(i)
            res.append(n//i)
    return res

    
