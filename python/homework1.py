# Patrick Krebs
# Homework 1

# 2.13
>>> s1 = '-'
>>> s2 = '+'
>>> s1 + s2
'-+'
>>> s1+s2+s1
'-+-'
>>> s2 + (s1*2)
'+--'
>>> (s2 + (s1*2))*2
'+--+--'
>>> (s2 + (s1*2))*10 + s2
'+--+--+--+--+--+--+--+--+--+--+'
>>> (s2+s1 + (s2*3) + (s1*2)) * 5
'+-+++--+-+++--+-+++--+-+++--+-+++--'

# 2.15
>>> s = 'goodbye'
>>> s[0] == 'g'
True
>>> s[6] == 'g'
False
>>> s[0] == 'g' and s[1] == 'a'
False
>>> s[-2] == 'x'
False
>>> s[3] == 'd'
True
>>> s[0] == s[-1]
False
>>> s[3:7] == 'tion' 
False

# 2.16
>>> a = 6
>>> b = 7
>>> c = (a+b)/2
>>> inventory = ['paper', 'staples', 'pencils']
>>> first = 'John'
>>> middle = 'Fitzgerald'
>>> last = 'Kennedy'
>>> fullname = first + ' ' + middle + ' ' + last
>>> fullname
'John Fitzgerald Kennedy'

# 2.17
>>> (17 + -9) < 10
True
>>> len(inventory) > 5 * len(fullname)
False
>>> c <=24
True
>>> a < 6.75 < b
True
>>> len(last) > len(middle) > len(first)
False
>>> inventory == '' or len(inventory) >= 10
False

# 2.18
>>> flowers = ['rose', 'bougainvillea', 'yucca', 'marigold', 'daylilly', 'lilly of the valley']
>>> 'potato' in flowers
False
>>> thorny = [flowers[0], flowers[1], flowers[2]]
>>> poisonous = [flowers[-1]]
>>> dangerous = thorny + poisonous

# 2.19
>>> r = 10
>>> x = 0
>>> y = 0
>>> x**2 + y**2 <= r**2
True
>>> x= 10
>>> y = 10
>>> x**2 + y**2 <= r**2
False
>>> x = 6
>>> y = 6
>>> x**2 + y**2 <= r**2
True
>>> x = 7
>>> x = 8
>>> x**2 + y**2 <= r**2
True

# 2.21
>>> s = 'top'
>>> s
'top'
>>> p = s[2] + s[1] + s[0]
>>> p
'pot'

# 2.24
>>> lst = [1,2,3,4,5,6,7,8]
>>> lst.index(len(lst)//2)
3
>>> lst[len(lst)//2]
4
>>> lst.sort(reverse=True)
>>> lst
[8, 7, 6, 5, 4, 3, 2, 1]
>>> lst.append(lst.pop(0))
>>> lst
[7, 6, 5, 4, 3, 2, 1, 8]

# Problem A
>>> grades = ['B','B','F','C','B','A','A','D','C','D','A','A','B']
>>> grades.sort()
>>> grades
['A', 'A', 'A', 'A', 'B', 'B', 'B', 'B', 'C', 'C', 'D', 'D', 'F']
>>> sort = [grades.count('A'),grades.count('B'),grades.count('C'),grades.count('D'),grades.count('F')]
>>> sort
[4, 4, 2, 2, 1]


count = []
count.append(grades.count('A'))
count.append(grades.count('B'))
count.append(grades.count('C'))
count.append(grades.count('D'))



