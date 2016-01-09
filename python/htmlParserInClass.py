from html.parser import HTMLParser
from urllib.request import urlopen
from urllib.parse import urljoin

def testParser(url):
    content = urlopen(url).read().decode()
    parser = Collector(url)
    parser.feed(content)
    return parser.getLinks()

class Collector(HTMLParser):
    'collect the links in an HTML page'

    def __init__(self, url):
        HTMLParser.__init__(self)
        self.lst = list()
        self.url = url

    def handle_starttag(self, tag, attrs):
        'print the links in the anchor tags'
        if tag == 'a':
            #print(attrs)
            for pair in attrs:
                if pair[0] == 'href':
                    if not pair[1].startswith('mailto'):
                        #print(pair[1])
                        j = urljoin(self.url, pair[1])
                        self.lst.append(j)

    def getLinks(self):
        return self.lst

class LinksPrinter(HTMLParser):
    'print the links in an HTML page'

    def handle_starttag(self, tag, attrs):
        'print the links in the anchor tags'
        if tag == 'a':
            #print(attrs)
            for pair in attrs:
                if pair[0] == 'href':
                    if not pair[1].startswith('mailto'):
                        print(pair[1])

class DataCollector(HTMLParser):
    def __init__(self):
        HTMLParser.__init__(self)
        self.s = ''

    def handle_data(self, data):
        if data != '\r\n' and data != '\n':
            self.s += data.strip()

    def get_data(self):
        return self.s

class ContentParser(HTMLParser):
    def handle_data(self, data):
        print(data.strip())
    
class PrettyParser(HTMLParser):
    'print things in an indented way'

    def __init__(self):
        'the constructor'
        HTMLParser.__init__(self) # DO NOT FORGET
        self.indent = 0
        
    def handle_starttag(self, tag, attrs):
        print("{}{} start".format(' ' * self.indent, tag))
        if tag not in ['br','img']:
            self.indent += 3
        
    def handle_endtag(self, tag):
        self.indent -= 3
        print("{}{} end".format(' ' * self.indent, tag))
    
class MyHTMLParser(HTMLParser):
    def handle_starttag(self, tag, attrs):
        print("Encountered a {} start tag".format(tag))
    def handle_endtag(self, tag):
        print("Encountered a {} end tag".format(tag))

