from html.parser import HTMLParser
from urllib.request import urlopen

def testParser(url):
    content = urlopen(url).read().decode()
    parser = DataCollector()
    parser.feed(content)
    return parser.get_data()


class DataCollector(HTMLParser):

    def __init__(self):
        HTMLParser.__init__(self)
        self.s = ''

    def handle_data(self,data):
        self.s += data

    def get_data(self):
        return self.s
        

class ContentParser(HTMLParser):
    'handles content'

    def handle_data(self, data):
        print(data.strip())

    

class PrettyParser(HTMLParser):
    '''prints the names of the start and end tags in the order that they
    appear in the document, and with an indentation
    that is proportional to the element’s depth
    in the tree structure of the document'''

    def __init__(self):
        'The Constructor'
        HTMLParser.__init__(self)
        self.indent = 0

    def handle_starttag(self, tag, attrs):
        print("{}{} start".format(' '*self.indent, tag))
        if tag not in ['br','img']:
            self.indent += 3
        
    def handle_endtag(self, tag):
        self.indent -= 3
        print("{}{} end".format(' '*self.indent, tag))
        
        
        

class MyHTMLParser(HTMLParser):
    def handle_starttag(self, tag, attrs):
        print("Encountered a {} start tag".format(tag))
    def handle_endtag(self, tag):
        print("Encountered a {} end tag".format(tag))

