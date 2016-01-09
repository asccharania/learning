def recLen(s):
    if s == '':
        return 0
    else:
        return 1 + recLen(s[1:])


def recLen2(lst):
    if lst == []:
        return 0
    else:
        return 1 + recLen2(lst[1:])


def printLst(lst):
    if len(lst) > 0:
        print(lst[0])
        printlst(lst[1:])


def lstPrint(lst):
    if len(lst) > 0:
        if type(lst[0]) == list:
            lstPrint(lst[0])
        else:
            print(lst[0])
        lstPrint(lst[1:])


def linSearch(lst, item, index):
    'return the index of item in lst or -1, recusively'
    if index >= len(lst):
        return -1
    elif lst[index] == item:
        return index
    else:
        return linSearch(lst, item, index+1)
