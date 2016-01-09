def negative(lst):
    '''returns index of the first negative number in lst;
       returns -1 if there is no negative number
    '''
    index = 0
    while index < len(lst) and lst[index] >= 0:
        index += 1
    if index < len(lst):
        return index
    else:
        return -1 
