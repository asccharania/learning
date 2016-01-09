def h(n):
    try:
        print('Start h')
        print(1/n)
        print(n)
    except:
        print('Caught!')

def g(n):
    print('Start g')
    h(n-1)
    print(n)

def f(n):
    print('Start f')
    g(n-1)
    print(n)
