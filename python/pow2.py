def pow2(n):
    'takes ingeger n and returns what power of 2 it is divisible by'
    res = 0
    while n % 2 == 0:
        n //= 2
        res += 1
        print('res = {}, n = {}'.format(res,n))
    return res
