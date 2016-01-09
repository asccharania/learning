# CSC 242-503
# Lab 2 

# Patrick Krebs
# I worked Alone

class Animal(object):
    'a class representing an abstraction of an animal'

    def __init__(self, s = 'default', l = 'default', a = 0):
        'the default constructor for the Animal class'
        self.species = s
        self.lang = l
        self.age = a 

    def setSpecies(self, s):
        'set the species of the animal'
        self.species = s

    def setLanguage(self, l):
        'set the language of the animal'
        self.lang = l

    def setAge(self, a):
        'Sets the animal\'s age to the value of a'
        self.age = a 

    def getAge(self):
        'Returns the Age of the Animal'
        return self.age
        
    def speak(self):
        'return a string the animal would say'
        return "I am a {}, I {}, and I am {}-years old".format(self.species, self.lang, self.age)
    
    def __str__(self):
        'the pretty representation of an animal'
        return 'The animal is a {} who {}s and is {}-years old'.format(self.species, self.lang, self.age)
    
    def __repr__(self):
        'the canonical representation of an animal'
        return 'Animal({}, {}, {})'.format(self.species, self.lang, self.age)

def processAnimals(fname):
    'Processes the Animals found in the file fname'
    animals = []
    try:
        infile = open(fname)
        lines = infile.readlines()
        infile.close()
        for items in lines:
            data = items.replace('\n','')
            data = data.split(',')
            animals.append(Animal(data[0],data[1],data[2]))
        for x in animals:
            print(Animal.speak(x))
        return animals
    except:
        print('The file {} does not exist. Self-Destruct in 3...2...1...'.format(fname))
        return animals

