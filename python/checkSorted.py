def checkSorted(lst):
    'return True if sequence lst is increasing, False otherwise'
    for i in range(0, len(lst)-1):
        #i = 0,2,...len(lst)-1
        if lst[i] > lst[i+1]:
            return False
    return True 
            
