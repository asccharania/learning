def qsolver(a,b,c):
    import math
    d = b**2 - 4*a*c
    if d < 0:
        return 'No roots'
    elif d == 0:
        root = -b / (2*a)
        return root
    else:
        r1 = (-b - math.sqrt(d)) / (2*a)
        r2 = (-b+math.sqrt(d))/(2*a)
        return (r2, r1)

def phone(number):
    s = ''
    d = {'ABC': '2',
         'DEF': '3',
         'GHI': '4',
         'JKL': '5',
         'MNO': '6',
         'PQRS': '7',
         'TUV': '8',
         'WXYZ': '9',
         }
    upperNum = number.upper()
    for letters in upperNum:
        for keys in d:
            if letters in keys:
                s += d[keys]
    return s
    


def approxPIsquared(error):
    bottom = 3
    est = 8
    while est > error:
        est = est +((8/bottom)**2)
        bottom = bottom+2
    return est 

        

from random import randrange
def yahtzee():
    pass

if __name__ == '__main__':
    if qsolver(1,2,1) != -1.0:
        print('Error in qsolver')
    if phone('Loveyou') != '5683968':
        print('Error in phone')
    if approxPIsquared(0.0001) != 9.855519952254232:
        print('Error in approxPIsquared')
