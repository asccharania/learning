def collatz():
    for i in range(0,1000000000):
        print(i)
        while i > 1:
            if i % 2 == 0:
                i = i//2
            else:
                i = 3*i + 1
        print(True)
    
