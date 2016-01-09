def inBoth(lst1,lst2):
    for x in lst1:
        for y in lst2:
            if x == y:
                return True
    return False 


def printPairs(lst1,lst2):
    for x in lst1:
        for y in lst2:
            print('({},{})'.format(x,y), end = " ")
        print()
