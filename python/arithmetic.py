def arithmetic(lst):
    '''takes as input a list of numbers
    returns True if the numbers in the list form an arithmetic sequence,
    False otherwise
    '''
    dif = lst[1] - lst[0] #find the differnce between the first two numbers
    for i in range(1, len(lst)-1):
        if lst[i+1] - lst[i] != dif: 
            return False
    return True 
        
