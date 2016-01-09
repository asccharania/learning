def f(b):       # f has global scope, b has local scope
    a = 6       # this a has scope local to function call f()
    return a*b  # this a is the local a

a = 0           # this a has global scope
print('f(3) = {}'.format(f(3)))
print('a is {}'.format(a))        # global a is still 0
