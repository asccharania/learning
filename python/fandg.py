def f(y):       # f is global, y is local to f()
    x = 2       # x is local to f()
    return g(x) # g is global, x is local to f()
    
def g(y):       # g is global, y is local to g()
    global x    # x is global
    x = 4       # x is global
    return x*y  # x is global, y is local to g()

x = 0           # x is global
res = f(x)      # res, f and x are global, and below too
print('x = {}, f(0) = {}'.format(x, res))


