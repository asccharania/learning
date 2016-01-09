#################################################
  #                                            #
  #  PLEASE DO NOT ADD ANYTHING TO THIS FILE  #
  #  OTHER THAN THE FUNCTION IMPLEMENTATIONS. #
  #                                            #
  #  THIS MODULE SHOULD RUN WITHOUT ERRORS    #
  #  WHEN EXECUTED.
  #                                            #
 ###############################################

# Patrick Krebs Homework 4
# Problem 5.15
def vowels(s):
    'prints the indexes of all vowels in string s'
    vow = 'aeiouAEIOU'
    for i in range(len(s)):
        if s[i] in vow:
            print(i)



# Problem 5.16
def indexes(word, letter):
    'returns a list of indexes at which character letter appears in word'
    res = []
    for i in range(len(word)):
       if word[i] == letter:
            res.append(i)
    return(res)

# Problem 5.17
def doubles(l):
    '''prints integers in list l that are exactly twice
       the previous integer in the list'''
    for i in range(1,len(l)):
        if l[i] == l[i-1]*2:
            print(l[i])
        
    
# Problem 5.18
def four_letter(lst):
    'returns list of 4-letter words in list of strings lst'
    res = []
    for i in lst:
        if len(i) == 4:
            res.append(i)
    return res




# Problem 5.25
def leap(year):
    'checks whether year is a leap year'
    if year % 400 == 0:
        return True
    elif  year % 100 == 0: # and year % 400 != 0
        return False
    elif  year % 4 == 0: # and year % 100 != 100 and year % 400 != 0
        return True
    else: # year  % 4 != 0
        return False




# Problem 5.26
def rps(play1, play2):
    '''takes choices ('R', 'P', or 'S') of player 1 and 2,
       and returns -1 if player 1 wins, 1 if player 2 wins,
       or 0 if there is a tie'''
    play1 = play1.upper()
    play2 = play2.upper()
    if play1 == play2:
        return 0
    elif (play1 == 'R' and play2 == 'S') or (play1 == 'S' and play2 == 'P') or ( play1 == 'P' and play2 == 'R'):
        return -1
    else: #(play2 == 'R' and play1 == 'S') or (play2 == 'S' and play1 == 'P') or ( play2 == 'P' and play1 == 'R')
        return 1

        

# Problem 5.28
def geometric(lst):
    'checks whether the integers in list lst form a geometric sequence'
    ratio = lst[1]//lst[0]
    for i in range(1, len(lst)-1):
        if lst[i+1]//lst[i] != ratio:
            return False
    return True




# Problem 5.34   
def statement(lst):
    '''returns a list of two numbers; the first is the sum of the
       positive numbers (deposits) in list lst, and the second is
       the sum of the negative numbers (withdrawals)'''
    deposits = []
    withdrawals = []
    totals = []
    for num in lst:
        if num > 0:
            deposits.append(num)
        else:
            withdrawals.append(num)
    totals.append(sum(deposits))
    totals.append(sum(withdrawals))
    return totals


# Problem 5.39
def exclamation(word):
    'returns exclamation version of word'
    newWord = word
    vow = 'aeiouAEIOU'
    for w in word:
        if w in vow:
            newWord = newWord.replace(w,w*4)
    newWord = newWord + '!'
    return newWord


# Problem 5.39 Not sure if this works
def exclamation2(word):
    'returns exclamation version of word'
    res = ''
    for c in word:
        if c in 'aeiouAEIOU':
            res += 4*c
        else:
            res += c
    return res
            
    

