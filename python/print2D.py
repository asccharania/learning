def print2D(t):
    'prints values in 2D list t as a 2D table'
    for row in t:
        for item in row:
            print(item, end='')
        print()


def incr2D(t):
    'incremetns each number in 2D list t'
    nrows = len(t)
    ncolumns = len(t[0])
    for i in range(nrows):
        for j in range(ncolumns):
            t[i][j] += 1
