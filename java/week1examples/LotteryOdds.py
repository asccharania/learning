def factorial(n):
    if n == 0:
        return 1
    else:
        return n * factorial(n-1)

def choose(n, k):
    return factorial(n)/(factorial(n-k)*factorial(k))

n = eval(input("Enter the number of values in the lottery: "))
k = eval(input("Enter the number of values chosen: "))
print("There are {:,} possible combinations.".format(int(choose(n, k))))
print(factorial(52))


                         
