# CSC 242-503
# Assignment 8 
# Patrick Krebs 

# I worked alone 

import os
from html.parser import HTMLParser
from urllib.request import urlopen


# Question 1
def nestingCount(path):
    'computes and returns the number of levels of subdirectories found in path'
    k = 0
    for item in os.listdir(path):
        if item[0] != '.':
            n = os.path.join(path, item)
            if os.path.isdir(n):
                j = 1 + nestingCount(n)
                if k < j:
                    k = j 
    return k


# Question 2
def countDir(dname, path):
    '''returns the number of instances of the directory
    name dname in the path directory structure.'''
    c = 0
    for item in os.listdir(path):
        if item[0] != '.':
            if item.lower() == dname.lower():
                c += 1
            n = os.path.join(path, item)
            if os.path.isdir(n):
                c += countDir(dname, n)
    return c

# Question 3
def findAll(fname, path):
    'return a list containing the full pathname of all occurrences of the file'
    l = []
    for item in os.listdir(path):
        if item[0] != '.':
            n = os.path.join(path, item)
            if os.path.isfile(n):
                if item.lower() == fname.lower():
                    l.append(n)
            elif os.path.isdir(n):
                k = findAll(fname, n)
                for x in k:
                    l.append(x)
    return l 

# Question 4
class ListParser(HTMLParser):
    '''collect the contents of all the list items,
    both ordered and unordered, in an HTML file'''
    
    def __init__(self):
        'The Constructor' 
        HTMLParser.__init__(self)
        self.l = list()
        self.b = False
        self.t = ''

    def handle_starttag(self, tag, attrs):
        'Called if encounters a start tag'
        self.b = True
        self.t = tag

    def handle_endtag(self, tag):
        'Called if encounters a end tag'
        self.b = False

    def handle_data(self, data):
        'data added to the list of list items'
        if self.b:
            if self.t == 'li':
                self.l.append(data)

    def getItems(self):
        'Returns the list of list items collected by the class'
        return self.l

# For testing only -- do not change
def testLParser(url):
    'Test the ListParser class'
    content = urlopen(url).read().decode()
    lParser = ListParser()
    lParser.feed(content)
    return lParser.getItems()
