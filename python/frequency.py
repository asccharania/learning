def frequency(itemList):
    'returns frequency of items in itemList'
    counters = {}
    for item in itemList:
        if item not in counters:
            counters[item] = 1
        else: #item already in counters
            counters[item] += 1
    return counters

