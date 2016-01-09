def game(r,c):
    import random
    field = []
    for i in range(r):
        field.append(c*[0])
    bombRow = random.randrange(0,r)
    bombCol = random.randrange(0,c)
    field[bombRow][bombCol] = 1
    while True:
        coord = input('Enter Bomb Guess (x y): ').split()
        x = int(coord[0])
        y = int(coord[1])
        if x == bombCol and y == bombRow:
            print('You found the bomb!!')
            break
        else:
            print('Try Again')
        
    
    
    
