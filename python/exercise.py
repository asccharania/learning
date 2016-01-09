import re

def parta():
    lst = []
    pattern = 'a[abc]c'
    textlist = ['aac', 'abc', 'acc', 'bbb','xyz']
    for text in textlist:
        l = re.findall(pattern, text)
        if len(l) > 0:
            lst += l
    return lst 
    
def partb():
    lst = []
    pattern = 'abc|xyz'
    textlist = ['aac', 'abc', 'acc', 'bbb','xyz']
    for text in textlist:
        l = re.findall(pattern, text)
        if len(l) > 0:
            lst += l
    return lst 

def partc():
    lst = []
    pattern = 'ab*'
    textlist = ['a','ab','abb','abbbb','abbbbbbbbb','xyx']
    for text in textlist:
        l = re.findall(pattern, text)
        if len(l) > 0:
            lst += l
    return lst 

def partd():
    lst = []
    pattern = '[a-z]+'
    textlist = ['abvcssfwfraegrgr','ASGEGSERTSG', '', 'hello']
    for text in textlist:
        l = re.findall(pattern, text)
        if len(l) > 0:
            lst += l
    return lst 


def parte():
    lst = []
    pattern = '.*oe.*'
    textlist = ['oe','oeabc','abcoe','aboecd']
    for text in textlist:
        l = re.findall(pattern, text)
        if len(l) > 0:
            lst += l
    return lst 
