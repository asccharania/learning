# Fails on the empty list -- how do we fix it?
def printLst(lst):
    'print a list recursively'
    if len(lst) == 1:
        print(lst[0])
    else: # recursive call
        print(lst[0])
        printLst(lst[1:])

