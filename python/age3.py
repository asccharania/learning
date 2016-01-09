try:
    # try block
    strAge = input('Enter your age: ')
    intAge = int(strAge)
    print('You are {} years old.'.format(intAge))
except ValueError:
    # except block --- executed only if a ValueError
    # exception is raised in the try block
    print('Enter your age using digits 0-9!')
