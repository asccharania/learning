# CSC 242-503
# Lab 1 template

# Patrick Krebs
# I worked alone on this 

import random

# Question 1
def makeNoisy(table, numChanges):
        for num in range(numChanges):
            if table != [] and numChanges > 0:
                row = random.randrange(0,3)
                column = random.randrange(0,3)
                table[row][column] += random.randrange(0,255)
            else:
                return


# Question 2
def evenQuiz():
    while True:
        try:
            num = int(input('Enter a Positive Even Integer: '))
            if num <= 0:
                print('That was an invalid value. Please Enter a positive number.')
                continue
            else:
                if num%2 != 0:
                    print('That was an invalid value. Please Enter an even number.')
                    continue
                else:
                    print('Thank you for the Positive Even Integer!')
                    return num
            break
        except:
            print('That was an invalid value. Please Enter an Integer')
        
