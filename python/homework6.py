# Problem 5.33
def mystery(n):
    'returns mystery number'
    res = 0
    while n > 1:
        n //= 2
        res += 1
    return res 
    
# Problem 5.48
def sublist(lst1, lst2):
    'checks whether list lst1 is a sublist of list lst2'
    i = 0
    j = 0
    while i < len(lst1):
        while j < len(lst2) and lst1[i] != lst2[j]:
            j += 1
        if j == len(lst2):
            return False
        else:
            i += 1 
    return True 
                              


# Problem 5.49
def heron(a, err):
    'return sqrt(a) within error err using Heron method'
    prev = 1.0
    cur = (prev + a/prev)/2
    while abs(cur - prev) > err:
        cur, prev = prev,(cur + a/cur)/2
    return cur 

# Problem 4
def gnome():
    'solves gnome problem'
    infile = open('gnome.txt')
    n = int(infile.readline())
    for i in range(n):
        nums = infile.readline().split()
        if int(nums[0]) <= int(nums[1]) <= int(nums[2]) or int(nums[0]) >= int(nums[1]) >= int(nums[2]):
            print('Ordered')
        else:
            print('Unordered')
            
         
# Problem 5
def speed():
    'solves speed problem'
    
    
    

