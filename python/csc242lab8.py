# CSC 242-503
# Lab 8 

# Patrick Krebs
# I worked Alone 

from html.parser import HTMLParser
from urllib.parse import urljoin
from urllib.request import urlopen

class Crawler2(object):
    def __init__(self):
        'constructor'
        self.discovered = set()

    def reset(self):
        'reset the visited links'
        self.discovered = set()

    # Write an iterative version of this method as
    # described in the lab write-up
    def crawl(self, startURL):
        'Iteratively Crawls the URLs'
        self.discovered.add(startURL)
        q = queue()
        q.enqueue(startURL)
        while not q.isEmpty():
            item = q.dequeue()
            try:
                links = self.analyze(item)
                for link in links:
                    if link not in self.discovered:
                        q.enqueue(link)
                        self.discovered.add(link)
            except:
                pass
        self.reset()
                               
        
        
        
    def analyze(self, url):
        'returns the list of URLs found in the page url'
        print("Visiting", url)
        content = urlopen(url).read().decode()
        collector = Collector(url)
        collector.feed(content)
        urls = collector.getLinks()
        return urls
    
# Helper classes
# DO NOT MODIFY
class queue(object):
    def __init__(self):
        self.q = []
    def dequeue(self):
        if self.isEmpty():
            raise EmptyQueueError('dequeue from empty queue')
        return self.q.pop(0)
    def enqueue (self, item):
        return self.q.append(item)
    def size(self):
        return len(self.q)
    def isEmpty(self):
        return (self.size() == 0)
    def __repr__(self):
        return self.q.__repr__()
    def __str__(self):
        return self.q.__str__()
    def __iter__(self):
        return self.q.__iter__()
    
class EmptyQueueError(Exception):
    def __init__(self, value):
        self.v = value
    def __str__(self):
        return repr(self.v)
    
class Collector(HTMLParser):
    def __init__(self, url):
        HTMLParser.__init__(self)
        self.url = url
        self.links = []

    def handle_starttag(self, tag, attrs):
        if tag == 'a':
            for attr in attrs:
                if attr[0] == 'href':
                    absolute = urljoin(self.url, attr[1])
                    if absolute[:4] == 'http':
                        self.links.append(absolute)

    def getLinks(self):
        return self.links
