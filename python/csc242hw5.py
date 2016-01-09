# CSC 242-503
# Assignment 5 

# Patrick Krebs

# I worked Alone

from tkinter import *
from tkinter.messagebox import showinfo
from random import *

# Question 1
class Craps(Tk):
    'a GUI that plays craps'

    def __init__(self, parent=None):
        'constructor'
        Tk.__init__(self, parent)
        self.title("Play craps")
        self.new_game()
        self.make_widgets()

    def new_game(self):
        'reset the game'
        self.firstroll = 0
        
    def make_widgets(self):
        'define the Craps widgets'
        Label(self, text="Die 1").grid(row=0, column=0)
        Label(self, text="Die 2").grid(row = 0, column = 1)
        self.ent1 = Entry(self, justify = CENTER)
        self.ent1.grid(row = 1, column = 0)
        self.ent2 = Entry(self, justify = CENTER)
        self.ent2.grid(row = 1, column = 1)
        Label(self, text = "First roll").grid(row = 2, column = 0)
        self.first = Entry(self, justify = CENTER)
        self.first.grid(row = 3, column = 0)
        Label(self, text = "Result").grid(row = 2, column = 1)
        self.result = Entry(self, justify = CENTER)
        self.result.grid(row = 3, column = 1)
        Button(self, text="Roll the dice!", command = self.play).grid(row = 4, column = 0, columnspan = 2)

    # Write this method
    # Do not modify the other methods in this class
    def play(self):
        'the event handler'
        self.result.delete(0,END)
        roll1, roll2 = randrange(1,7), randrange(1,7)
        self.ent1.delete(0,END)
        self.ent2.delete(0,END)
        self.ent1.insert(END, roll1)
        self.ent2.insert(END, roll2)
        if self.firstroll == 0:
            self.first.delete(0,END)
            self.firstroll = roll1 + roll2
            self.first.insert(END, self.firstroll)
            if self.firstroll == 7:
                self.result.insert(END, 'You won! Play Again?')
                self.new_game()
            elif self.firstroll == 2 or self.firstroll == 3 or self.firstroll == 12:
                self.result.insert(END, 'You lost. Play Again?')
                self.new_game()
            else:
                self.result.insert(END, 'Roll Again')
    
        else:
            total = roll1 + roll2
            if total == 7:
                self.result.insert(END, 'You lost! Play Again?')
                self.new_game()
            elif total == self.firstroll:
                self.result.insert(END, 'You won! Play Again?')
                self.new_game()
            else:
                self.result.insert(END, 'Roll Again')
                        
# Question 2
class Ed(Frame):
    'Simple arithmetic education app'
    
    def __init__(self,parent=None):
        'constructor'
        Frame.__init__(self, parent)
        self.pack()
        Ed.make_widgets(self)
        Ed.new_problem(self)

    # Write all of the methods below
    # Do not change the constructor
    def make_widgets(self):
        'defines Ed widgets'
        self.ent1 = Entry(self)
        self.ent1.pack(side = LEFT)
        self.ent2 = Entry(self)
        self.ent2.pack(side = LEFT)
        Button(self, text = 'Enter', command = self.evaluate).pack(side = LEFT)
        

    def new_problem(self):
        'creates new arithmetic problem'
        self.ent2.delete(0, END)
        self.ent1.delete(0, END)
        self.n1,self.n2 = randint(1,9),randint(1,9)
        self.op = randint(1,2)
        if self.op == 1:
            self.op = '+'
        else:
            self.op = '-'
        if self.n1 < self.n2:
            self.ent1.insert(END,'{} {} {} ='.format(self.n2,self.op,self.n1))
        else:
            self.ent1.insert(END,'{} {} {} ='.format(self.n1,self.op,self.n2))

    def evaluate(self):
        'handles button "Enter" clicks by comparing answer in entry to correct result'
        if self.op == '+':
            result = self.n1 + self.n2
        else:
            if self.n2 > self.n1:
                result = self.n2 - self.n1
            else:
                result = self.n1 - self.n2
        try:
            a = int(self.ent2.get())
            if result == a:
                showinfo(title = 'Yes!', message = 'You got it! Good Job!')
                self.new_problem()
            else:
                showinfo(title = 'Not Quite', message = 'That was incorrect. Try Again.')
                self.ent2.delete(0, END)
        except:
            showinfo(title = 'Ooops!', message = 'You need to write numbers using digits (0 through 9')
            self.ent2.delete(0, END)
            
      

        
