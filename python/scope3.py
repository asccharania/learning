def f(b):
    global a    # all references to a in f() are to the global a
    a = 6       # global a is changed
    return a*b  # this a is the global a

a = 0           # this a has global scope
print('f(3) = {}'.format(f(3)))
print('a is {}'.format(a))        # global a has been changed to 6
