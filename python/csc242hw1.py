# CSC 242-503
# Assignment 1 
# Patrick Krebs 

# I worked alone.


from random import randint

# Question 1
def rps(p1, p2):
    'play a round of rock, paper, scissors'
    p1 = p1.upper()
    p2 = p2.upper()
    if p1 == p2:
        return 0
    elif (p1 == 'R' and p2 == 'S') or (p1 == 'S' and p2 == 'P') or (p1 == 'P' and p2 == 'R'):
        return -1
    else:
        return 1

# Write this function for the question
def playRPS(n):
    'Play n Rounds of Rock, Paper, Scissors Against the Computer'
    print('Welcome to Patrick\'s Rock Paper Scissors Game')
    print('You will play {} games against the computer'.format(n))
    compWins = 0
    playerWins = 0
    ties = 0
    for x in range(n):
        comp = randint(0,2)
        # computerC = random.choice(['r','p','s'])
        if comp == 0:
            comp = 'R'
        elif comp == 1:
            comp = 'P'
        else: #comp == 2
            comp = 'S'
        while True:
            player = input('Pick R, P, or S: ')
            if player == '' or player not in 'RPS':
                print('Please Enter either R, P, or S')
                continue
            else:
                break
        result = rps(player,comp)
        if result == 0:
            print('We tied! We both picked {}'.format(player))
            ties += 1
        elif result == -1:
            playerWins += 1
            print('You won! I picked {} and you picked {}'.format(comp,player))
        else: # result == 1
            print('I won! I picked {} and you picked {}'.format(comp,player))
            compWins += 1
    print()
    print('Thank you for playing with me!')
    print('I won {} times, you won {} times, and we tied {} times.'.format(compWins,playerWins,ties))

    

# Question 2
def names():
    'Keeps count of the number of names entered.'
    count = {}
    while True:
        nam = input('Enter the next name: ')
        nam = nam.lower()
        nam = nam.strip()
        nam = nam.capitalize()
        if nam == '':
            for keys in count:
                if count[keys] == 1:
                    print('There is 1 student named {}.'.format(keys))
                else:
                    print('There are {} students named {}.'.format(count[keys],keys))
            break
        else:
            if nam not in count:
                count[nam] = 1
            else:
                count[nam] += 1


# Question 3
def grades(infname, outfname):
    '''Reads the Grades for each student from the infile, and writes
    the student name and average grade in the outfile'''
    dic = {}
    dic2 = {}
    try:
        infile = open(infname)
        lines = infile.readlines()
        infile.close()
        for items in lines:
            words = items.split()
            dic[words[0]] = words[1:]
        for keys in dic:
            dic2[keys] = []
            for values in dic[keys]:
                dic2[keys].append(int(values))
        for x in dic2:
            dic2[x] = sum(dic2[x])/len(dic2[x])

        outfile = open(outfname, 'w')
        for y in dic2:
            outfile.write(y)
            outfile.write(' ')
            outfile.write(str(dic2[y]))
            outfile.write('\n')
        outfile.close()
    except:
        print('{} does not exist. The function will not continue.'.format(infname))
