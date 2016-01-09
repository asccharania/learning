# CSC 242-503
# Assignment 7 

# Patrick Krebs
# I worked a little bit with Darian on this assignment. We didn't share any code
# but a couple of times we talked through the bigger picture ideas behind
# a couple of questions and talked through our approaches to the solutions.

import os

# Question 1
def recListSum(lst):
    'returns the sum of the numbers in the list.'
    if len(lst) == 0:
        return 0
    else:
        if type(lst[0]) == list:
            return recListSum(lst[0]) + recListSum(lst[1:])
        elif type(lst[0]) == int or type(lst[0]) == float:
            return lst[0] + recListSum(lst[1:])
        else:
            return 0 + recListSum(lst[1:])


# Question 2
def depthCount(lst):
    'returns the maximum depth to which the list has nested sublists'
    if lst == []:
        return 0
    elif type(lst[0]) == list:
        f = depthCount(lst[0]) + 1 # we stripped it out of a list
        r = depthCount(lst[1:])
        if f > r: # f is more deeply nested
            return f
        else: # r is more deeptly nested
            return r
    else: # lst[0] is not a list
        return depthCount(lst[1:])
        


    
# Question 3
def search(fname, path):
    '''searches for the file in the folder and any folder contained within it,
    directly or indirectly.'''
    for item in os.listdir(path):
        if item[0] != '.':
            n = os.path.join(path, item)
            if os.path.isfile(n):
                if item == fname:
                    return n
            elif os.path.isdir(n):
                result = search(fname, n)
                if result != None:
                    return result 
    return None
                
                

# Question 4
def fileCount(path):
    'returns the number of files found in the directory and any subdirectories'
    count = 0 
    for item in os.listdir(path):
        if item[0] != '.':
            n = os.path.join(path, item)
            if os.path.isfile(n):
                count += 1 
            elif os.path.isdir(n):
                count += fileCount(n)
    return count 
                
    
