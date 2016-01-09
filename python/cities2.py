def cities2():
    lst = []
    while True:
        city = input('Enter city: ')
        if city == '':
            return lst
        lst.append(city)

def cities2B():
    lst = []

    while True:
        city = input('Enter city: ')

        if city == '':
            break

        lst.append(city)

    return lst
