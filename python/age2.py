try:
    # try block --- executed first; if an exception is
    # raised, the execution of the try block is interrupted
    strAge = input('Enter your age: ')
    intAge = int(strAge)
    print('You are {} years old.'.format(intAge))
except:
    # except block --- executed only if an exception
    # is raised while executing the try block
    print('Enter your age using digits 0-9!')
