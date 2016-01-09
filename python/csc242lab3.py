# Patrick Krebs
# CSC 242 Lab 3
# I worked Alone

class Stat(object):
    '''A class that stores a sequence of numbers and
    provides statistical information about the numbers'''

    def __init__(self, l = []):
        'the Constructor'
        self.lst = list(l)

    def __len__(self):
        'Returns the length of the list'
        return len(self.lst)

    def min(self):
        'returns the smallest number'
        if self.lst == []:
            return 0.0
        else:
            return min(self.lst)

    def max(self):
        'returns the largest number'
        if self.lst == []:
            return 0.0
        else:
            return max(self.lst)

    def sum(self):
        'returns the sum of the numbers'
        if self.lst == []:
            return 0
        else:
            return sum(self.lst)

    def mean(self):
        'returns the average of the numbers'
        if self.lst == []:
            return 0.0
        else:
            return (sum(self.lst)/(len(self.lst)))

    def add(self, x):
        'Adds x to the list'
        self.lst.append(x)

    def clear(self):
        'Clears the list'
        self.lst = []

    def __contains__(self, y):
        'Test to see if y is in self'
        if y in self.lst:
            return True
        else:
            return False

    def __repr__(self):
        'The Representation of the numbers'
        return 'Stat({})'.format(self.lst)

    def __str__(self):
        'a fancier representation'
        return '{}'.format(self.lst)
