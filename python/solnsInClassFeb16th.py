def ffib(n):
    first, second = 1, 1
    count = 2
    while count <= n:
        first, second = second, first+second
        count += 1
    return second

def fib(n):
    if n == 0 or n == 1:
        return 1
    else:
        return fib(n-1) + fib(n-2)

def recExp(a, n):
    'compute a to the nth power recursively and cleverly'
    if n == 0:
        return 1
    else: # recursive step
        val = recExp(a, n // 2)
        if n % 2 == 0: # n is even
            return val * val
        else: # n is odd
            return val * val * a

def slowExp(a, n):
    if n == 0:
        return 1
    else:
        return a * slowExp(a, n-1)
    
def s_pattern(n):
    'return a numeric pattern as a string'
    if n == 1:
        return str(n)
        #return '{}'.format(n)
    else:
        s = s_pattern(n-1)
        return s + str(n) + s

def loop(a, n):
    'compute a to the nth power'
    ans = 1
    for i in range(n):
        ans = ans * a
    return ans

def fact(n):
    'return the factorial of n, computed recursively'
    if n <= 1:
        return n
    else:
        val = fact(n-1)
        return n * val

def pattern(n):
    'print a numeric pattern'
    if n == 1:
        print(n, end = ' ')
    else:
        pattern(n-1)
        print(n, end = ' ')
        pattern(n-1)
    
def cheer(n):
    'print a cheer based on n'
    #if n == 0 or n == 1:
    if n <= 1:
        print("Hurrah!")
    else:
        print("Hip")
        cheer(n-1)
    
def printLst(lst):
    'print a list recursively'
##    if len(lst) == 0:
##        pass
##    elif len(lst) == 1:
##        print(lst[0])
    if len(lst) >= 1:
    #else: # recursive call
        print(lst[0])
        printLst(lst[1:])

