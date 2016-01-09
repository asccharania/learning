def pixels(image):
    'return number of pixels in image that are not zero'
    res = 0
    for row in image:
        for pixel in row:
            if pixel > 0:
                res += 1
    return res 
    
