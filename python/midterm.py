# Patrick Krebs Midterm

def date(weekday, month, day, year):
    'return complete date using 3-character abbreviations for weekday and month'
    return '{}, {} {}, {}'.format(weekday[:3],month[:3],day,year)

def multiples(n):
    'return list of the first 10 multiples of n, starting with 0'
    res = []
    for num in range(0,10):
         res.append(num*n)
    return res 

def quote(filename, index):
    'return quote in line index of file filename'
    infile = open(filename)
    lines = infile.readlines()
    infile.close()
    quote = lines[index]
    return quote
 
def allEven(numList):
    'return True is all integers in numList are even, False otherwise'
    for num in numList:
        if num % 2 != 0:
            return False
    return True 


def poly(a, w):
    '''return value of polynomial

       a[0] + a[1]*x + a[2]*x**2 + ... + a[n]*x**n

       at x = w, where n is the index of the last item in a (i.e., len(a)-1)
    '''
    res = []
    for n in range(len(a)):
        res.append(a[n]*w**n)
        sol = sum(res)
    return sol 
        
