# CSC 242-503
# Assignment 6 

# Patrick Krebs 
# I worked alone

# Question 1
def recIntCount(lst):
    '''takes a one-dimensional list as a parameter and
    returns the number of integers that are found in the list'''
    if len(lst) == 0:
        return 0
    else:
        if type(lst[0]) == int:
            return 1 + recIntCount(lst[1:])
        else:
            return recIntCount(lst[1:])
            

# Question 2
def recSymCount(s):
    'computes and returns the number of math symbols in a string'
    if s == '':
        return 0
    else:
        if s[0] in '+-*/=':
            return 1 + recSymCount(s[1:])
        else:
            return recSymCount(s[1:])

# Question 3
def reversible(lst):
    'returns True if the list is the same forward and backward and False otherwise'
    if len(lst) > 1:
        index = len(lst) -1
        if lst[0] != lst[index]:
            return False
        else:
            return reversible(lst[1:index])
    else:
        return True
            

# Question 4
def recSymPrint(c1, c2, n, indent):
    '''takes two characters and two integers n and indent as parameters
    and prints a double triangular pattern using the characters'''
    if n > 0:
        print('{}{}'.format(' '*indent,c1*n))
        recSymPrint(c1, c2, n-1, indent+1)
        print('{}{}'.format(' '*indent,c2*n))
    
