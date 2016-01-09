import re

def example1():
    pattern='hello'
    text='I say hello there'
    lst = re.findall(pattern,text)
    return lst

def example2():
    pattern='by.e'
    text='by every measure'
    lst = re.findall(pattern,text)
    return lst

def example3():
    pattern='hell\..'
    text='hello, hellp, heloo hell.x'
    lst = re.findall(pattern,text)
    return lst

def example4():
    pattern = 'hel+p'
    pattern2='hel+p[^!]+'
    text='help! help! hellllllp!!! heeellllllppp!!!! hep helpp'
    lst = re.findall(pattern,text)
    return lst

def example5():
    pattern='[H,h]el*[a-z]'
    text='Help! hello! hellllllp!!! heeellllllppp!!!! hen'
    lst = re.findall(pattern,text)
    return lst

def example6():
    pattern='[A-Za-z0-9_.]+\@[A-Za-z0-9_.]+\.com'
    pattern2 = '[A-Za-z0-9_.]+\@[A-Za-z0-9_.]+\...[.]?'
    text='len@yahoo.com, @gmail.com, lp0e@derida.com, d@dds.net, a@ca.ca'
    lst = re.findall(pattern2,text)
    return lst

#print('example 1 list = ', example1())
#print('example 2 list = ', example2())
#print('example 3 list = ', example3())
#print('example 4 list = ', example4())
#print('example 5 list = ', example5())
#print('example 6 list = ', example6())
