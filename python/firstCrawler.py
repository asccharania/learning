from html.parser import HTMLParser
from urllib.parse import urljoin
from urllib.request import urlopen

# Change this to import from whatever file holds the Collector class
from htmlParserInClass import Collector

class Crawler(object):

    def __init__(self):
        self.visited = set()

    def reset(self):
        self.visited = set()
    
    def crawl(self, url):
        ' recursive web crawler that calls analyze() on each web page'
        self.visited.add(url)
        links = self.analyze(url)
        for link in links:
            if link not in self.visited:
                try:
                    self.crawl(link)
                except:
                    pass

    def analyze(self, url):
        'returns the list of URLs found in the page url'
        print("Visiting", url)
        content = urlopen(url).read().decode()
        collector = Collector(url)
        collector.feed(content)
        urls = collector.getLinks()
        return urls
