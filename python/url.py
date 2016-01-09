from urllib.request import urlopen

def urlFcn(url, word):
    #url="http://facweb.cdm.depaul.edu/asettle/csc242/web/test.html"
    #word="mission"
    file=urlopen(url)
    html=file.read()
    html = html.decode()
    #print(html)
    print(html.count(word))
