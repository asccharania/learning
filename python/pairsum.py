def pairSum(lst, target):
    '''prints the indexes of all pairs of values in the list
    that add up to the target value'''
    for i in range(len(lst)-1): # i is left item in pair
        for j in range(i+1, len(lst)): # j is the index of the right item
            if lst[i] + lst[j] == target:
                print(i,j)
               
    
