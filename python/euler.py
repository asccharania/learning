import math
def approxE(error):
    'retuns the approximation of e, such that Ei-Ei+1 > error'
    previous, current = 1, 2
    i = 2
    while current-previous > error:
        previous, current = current, current + 1/math.factorial(i)
        i += 1 
    return current 
