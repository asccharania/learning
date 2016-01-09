from urllib.request import urlopen

def readHTML(url):
    file=urlopen(url)
    html=file.read()
    html = html.decode()
    return html

def urlFcn(url, word):
    #url="http://facweb.cdm.depaul.edu/asettle/csc242/web/test.html"
    #word="mission"
    html = readHTML(url)
    print(html.count(word))
