# CSC 242-503
# Assignment 2 

# Patrick Krebs 

# I worked alone

from time import localtime

# Question 1
class Person(object):
    'A user-defined class that is used to Abstract People! Whoa!'
    
    def __init__(self, name = 'Jane Doe', birthYear = 2015):
        'The Constructor'
        self.personName = name
        self.birthYear = birthYear
        
    def age(self):
        'A method that returns the age of the person'
        return localtime()[0] - int(self.birthYear)
    
    def name(self):
        'A method that returns the name of the person'
        return self.personName
    
    def __repr__(self):
        'A method that returns the canonical representation of the Person'
        return 'Person({}, {})'.format(self.personName,self.birthYear)
    
    def __str__(self):
        'returns a nicely formatted version of the Person'
        return '{} is {} years old.'.format(self.personName, self.age()))

# Question 2
class Student(Person):
    'A sub-class of Person that abstracts a Student'
    def __init__(self, name = 'unknown', birthYear = 1997, major = 'unknown'):
        'The Student constructor'
        Person.__init__(self, name, birthYear)
        self.currentMajor = major
        
        
    def major(self):
        'Returns the major of the student'
        return self.currentMajor

class Instructor(Person):
    'A sub-class of Person that abstracts an Instructor'
    def __init__(self, name = 'unknown', birthYear = 1985, degree = 'unknown'):
        'The Instructor constructor'
        Person.__init__(self, name, birthYear)
        self.degreeEarned = degree
        
    def degree(self):
        'Returns the degree of the Instructor'
        return self.degreeEarned

# Question 3
def processPeople(fname):
    'A function that process the information found in file fname'
    people = []
    try:
        infile = open(fname)
        lines = infile.readlines()
        infile.close()
        for items in lines:
            data = items.replace('\n','')
            data = data.replace(',',' ')
            data = data.split(' ')
            name = data[1] + ' ' + data[0]
            if len(data) > 2:
                date = data[2]
            else:
                date = localtime()[0]
            people.append(Person(name, date))
        for x in people:
            print('Person added to the list:', end = ' ')
            print(x)
        
        return people
    except:
        print('The file {} cannot be found. Exiting...'.format(fname))
        return people
