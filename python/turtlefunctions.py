def jump(t, x, y):
    'makes turtle t jump to coordinates (x, y)'
    t.penup()
    t.goto(x, y)
    t.pendown()



def emoticon(t, x, y):
    'directs turtle t to draw a smiley face with chin at (x, y)'
    t.pensize(3)           # set turtle heading and pen size
    t.setheading(0)
    jump(t, x, y)          # move to (x, y) and draw head
    t.circle(100)
    jump(t, x+35, y+120)   # move and draw right eye
    t.dot(25)
    jump(t, x-35, y+120)   # move and draw left eye
    t.dot(25)
    jump(t, x-60.62, y+65) # move and draw smile
    t.setheading(-60)  
    t.circle(70, 120)      # 120 degree section of a circle

