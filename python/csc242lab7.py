# CSC 242-503
# Lab 7 

# Patrick Krebs 

# I worked alone 

from html.parser import HTMLParser
from urllib.request import urlopen

# This code is for reference only
# DO NOT CALL or modify this method
def moveTower(n, source, dest, temp):
    if n==1:
        print("Move disk from", source, "to", dest)
    else:
        moveTower(n-1, source, temp, dest)
        moveTower(1, source, dest, temp)
        moveTower(n-1, temp, dest, source)

# This code is for reference only
# DO NOT CALL or modify this method
def hanoi(n):
    moveTower(n,1,3,2)

# Question 1
# Implement this method for the lab
# Again, DO NOT CALL hanoi() or moveTower()
def hanoiCount(n):
    '''counts and returns the number of disk moves
    necessary to solve the Towers of Hanoi problem for n disks'''
    if n == 1:
        return 1
    else:
        return 1 + hanoiCount(n-1) + hanoiCount(n-1)

    
# Question 2
class HeaderParser(HTMLParser):
    '''find and collect the contents of all the headings
    in an HTML file fed to it'''
    def __init__(self):
        'the constructor'
        HTMLParser.__init__(self)
        self.l = list()
        self.h = False
        self.t = ''

    def handle_starttag(self, tag, attrs):
        self.h = True
        self.t = tag
        

    def handle_endtag(self, tag):
        self.h = False 

    def handle_data(self, data):
        if self.h:
            if self.t in ['h1','h2','h3','h4','h5','h6']:
                self.l.append(data.strip())

    def getHeadings(self):
        return self.l

# For testing purposes only -- do not modify
def testHParser(url):
    'Test the HeaderParser class'
    content = urlopen(url).read().decode()
    hParser = HeaderParser()
    hParser.feed(content)
    return hParser.getHeadings()
