# CSC 242-503
# Lab 4 

# Patrick Krebs
# I worked Alone

# Question 1
# Do not modify the OddList class
class OddList(list):
    'a class representing an odd-behaving class'

    def __iter__(self):
        'returns an iterator for the class'
        return OddListIterator(self)

# Write this class for the first question
class OddListIterator:
    'The Iterator Class for OddList'

    def __init__(self, lst):
        'create the iterator'
        self.l = lst
        self.index = 1

    def __next__(self):
        'return the next odd item in the list'
        if self.index > len(self.l) - 1:
            raise StopIteration()
        item = self.l[self.index]
        self.index += 2
        return item

# Question 2
class PriorityQueue(object):
    'A container Class for a Queue'
    
    def __init__(self):
        'The Constructor for the Queue'
        self.q = []
        
    def insert(self, item):
        'inserts the number into the queue'
        self.q.append(item)
        self.q.sort()
        
    def minimum(self):
        'returns the smallest number in the queue'
        return min(self.q)
    
    def removeMin(self):
        'removes the smallest number from the queue'
        m = self.minimum()
        self.q.remove(m)
        self.q.sort()
        return m
    
    def __len__(self):
        'returns the size of the priority queue'
        return len(self.q)
    
    def __getitem__(self, index):
        'returns the queue item at that index'
        return self.q[index]
    
    def __str__(self):
        'returns a string representing the queue'
        return str(self.q)
    
    def __repr__(self):
        'returns the canonical representation of the queue'
        return repr(self.q)
    
    def __iter__(self):
        'implements iteration for the queue'
        return iter(self.q)
