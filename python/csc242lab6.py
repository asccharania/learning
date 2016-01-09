# CSC 242-503
# Lab 6 

# Patrick Krebs

# Feel free to change the import statements
from tkinter import *
from tkinter.messagebox import showinfo
from random import *
import os

# Question 1
# Complete the GUI by writing the handler reply
# Do not modify any of the other methods in the class
class Game(Frame):
    'Number guessing application'
    def __init__(self,parent=None):
        'constructor'
        Frame.__init__(self, parent)
        self.pack()
        Game.make_widgets(self)
        Game.new_game(self)

    def make_widgets(self):
        'defines Game widgets'
        Label(self, text="Enter your guess:").pack()
        self.ent = Entry(self, justify = CENTER, width=14)
        self.ent.pack()
        Button(self, text="Enter", command=self.reply).pack()

    def new_game(self):
        'starts new game by choosing secret number'
        self.num = randint(1,100)

    # Write this method to finish the question
    def reply(self):
        'handles button "Enter" clicks'
        try:
            guess = int(self.ent.get())
            if guess == self.num:
                showinfo(title = 'Congratulations!', message = 'You guessed correctly!')
                self.ent.delete(0,END)
                self.new_game()
            elif guess > self.num:
                showinfo(title = 'Report', message = '{} is too high'.format(guess))
                self.ent.delete(0,END)
            else:
                showinfo(title = 'Report', message = '{} is too low'.format(guess))
                self.ent.delete(0,END)
        except:
            showinfo(title = 'Whoops', message = 'Invalid Number')
            self.ent.delete(0,END)
                   

# Question 2
# This function must be recursive
# It may not use loops
def itemCount(lst):
    'count and return the number of items in a nested list'
    if lst == []:
        return 0
    else:
        if type(lst[0]) == list:
            return itemCount(lst[0]) + itemCount(lst[1:])
        return 1 + itemCount(lst[1:])

# Question 3
# This function must be recursive
def traverse(path, indent):
    'recursively traverse a set of directories'
    for item in os.listdir(path):
        if item[0] != '.':
            n = os.path.join(path, item)
            if os.path.isdir(n):
                print('{}{}'.format(' '*indent,n))
                traverse(n, indent + 2)
            elif os.path.isfile(n):
                print('{}{}'.format(' '*indent,n))
