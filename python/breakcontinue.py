def before0(table):
    for row in table:
        for num in row:
            if num == 0:
                break
            print(num, end=' ')
        print()
                  

def ignore0(table):
    for row in table:
        for num in row:
            if num == 0:
                continue
            print(num, end=' ')
        print() 
