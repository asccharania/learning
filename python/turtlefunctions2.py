def jump(t, x, y):
    'makes turtle t jump to coordinates (x,y)'
    
    t.penup()
    t.goto(x,y)
    t.pendown()



def emoticon(t,x,y):
    'turtle t draws a smiley face with chin at coordinate (x, y)'
    # set turtle direction and pen size
    t.pensize(3)
    t.setheading(0)
    
    # move to (x, y) and draw head
    jump(t, x, y)
    t.circle(100)

    # draw right eye
    jump(t, x+35, y+120)
    t.dot(25)

    # draw left eye
    jump(t, x-35, y+120)
    t.dot(25)

    #draw smile
    jump(t, x-60.62, y+65)
    t.setheading(-60)  # smile is a 120 degree
    t.circle(70, 120)  # section of a circle

