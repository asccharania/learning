#
# NOTE:
# 
# A function must have a code block otherwise
# Python will complain. For that reason I put
# a pass Python statement where the code block
# should be. The pass statement does absolutely
# nothing. You should replace the pass statement
# with your function implementation

#Patrick Krebs
#Homework 2

def forLoop():
    ''' printing numbers 5, 9, 13, 17, and 21
    one per line
    
    usage:
    >>> forLoops()
    5
    9
    13
    17
    21

    '''
    for x in range(5,25,4):
        print(x)


# Problem 3.32
def pay(wage, hours):
    '''return employee’s pay; overtime (beyond 40 hours)
       is paid at 1.5 times the regular hourly wage'''
    if hours > 40:
        return(((wage*1.5)*(hours-40))+(wage*40)) 
    else:
        return(wage*hours)




# Problem 3.33
def prob(n):
    'return probability of getting n heads in a row'
    if n > 0:
        return(2**(-n))



# Problem 3.35
import math
def points(x1, y1, x2, y2):
    '''print slope and length of line segment passing
       through points (x1,y1) and (x2,y2)'''
    if x1 == x2:
        slope = 'infinity'
    else: # x1 != x2
        slope = (y2 - y1)/(x2 - x1) 
    distance = (math.sqrt((x2-x1)**2 + (y2-y1)**2))
    print('The slope is ', slope ,' and the distance is',length)



# Problem 3.36
def abbreviation(day):
    'return two-letter abbreviation of day of the week'
    return(day[:2])



# Problem 3.37
def collision(x1, y1, r1, x2, y2, r2):
    '''checks whether two circles with centers (x1,y1) and (x2,y2)
       and radii r1 and r2, respectively, intersect'''
    return(math.sqrt((x2-x1)**2 + (y2-y1)**2) <= (r1+r2))



# Problem 3.38
def partition(lst):
    '''prints the names in list lst that start
       with a letter between and including A and M'''
    for name in lst:
        if 'A' <= name[0] <= 'M':
            print(name)


# Problem 3.39
def lastF(first, last):
    return(last + ', ' + first[0] +'.')



# Problem 3.40
def avg(lst):
    '''lst is a list that contains lists of numbers; the
       function prints, one per line, the average of each list'''
    for studentGrades in lst:
        print(sum(studentGrades)/len(studentGrades))
    


# Problem 3.42
def ion(word):
    return word[-3:] == 'ion'
       


# Problem 3.44
import turtle
def polygon(n):
    'draw n-sided regular polygon using turtle graphics'
    s = turtle.Screen()
    t = turtle.Turtle()
    for x in range(0,n):
        t.left(180-(((n-2)*180)/n))
        t.forward(100)
    

# Problem 3.45
import turtle
def planets():
    'simulates motion of Mercury, Venus, Earth, and Mars'
    s = turtle.Screen()
    
    m = turtle.Turtle()
    m.shape("circle")
    
    v = turtle.Turtle()
    v.shape("circle")
    
    e = turtle.Turtle()
    e.shape("circle")
    
    mars = turtle.Turtle()
    mars.shape("circle")
    
    m.penup()
    m.goto(0,-58)
    m.pendown()

    v.penup()
    v.goto(0,-108)
    v.pendown()

    e.penup()
    e.goto(0,-150)
    e.pendown()    

    mars.penup()
    mars.goto(0,-228)
    mars.pendown()

    for x in range(0,360):
        m.circle(58,7.5)
        v.circle(108,3)
        e.circle(150,2)
        mars.circle(228,1)
