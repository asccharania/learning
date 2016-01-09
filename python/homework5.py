# Patrick Krebs homework 5

# Problem 5.32
def fib(n):
    'returns the nth Fibonacci number'
    previous = 1
    current = 1
    for i in range(2,n+1):
        previous, current = current, previous+current
    return current
        

# Problem 5.37
def mssl(lst):
    'returns the sum of the maximum sum sublist of list lst'
    m = 0
    for i in range(len(lst)-1):
        for j in range(i+1,len(lst)):
            y = 0
            for x in range(i,j+1):
                y += lst[x]
                if y > m:
                    m = y
    return m
                

# Problem 5.38
def collatz(n):
    'prints the Collatz sequence starting at n'
    print(n)
    while n > 1:
        if n % 2 == 0:
            n = n//2 
        else:
            n = 3*n + 1
        print(n)
        



# Problem 5.42
def primeFac(n):
    'returns a list containing all the numbers in the prime factorization of n'
    res = []
    p = 2
    while n > 1:
        if n % p == 0:
            res.append(p)
            n = n//p
        else:
            p = p+1
    return res
        
        
# Problem 5.43
def evenrow(table):
    '''checks whether each row of the two-dimensional list table
       sums up to an even number'''
    for row in table:
        s = sum(row)
        if s % 2 != 0:
            return False
    return True 
         
        

# Problem 5.46
def inversions(s):
    'returns the number of inversions in sequence s'
    res = 0
    for letters in range(len(s)-1):
        for i in range(letters+1,len(s)):
            if s[i] < s[letters]:
                res += 1
    return res 

