def fibonacci(bound):
    'returns first Fibonnaci number > limit'
    previous = 1
    current = 1
    while current <= bound:
        previous, current = current, previous+current
    return current
