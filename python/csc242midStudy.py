# CSC 242-503
# Midterm study problem template

from tkinter import *
from tkinter.messagebox import showinfo

class BMI(Frame):
    'Body Mass Index app'
    def __init__(self,parent=None):
        'constructor'
        Frame.__init__(self, parent)
        # If you use pack for the widgets in make_widgets, change
        # this to pack
        self.grid()
        self.make_widgets()

    def make_widgets(self):
        'defines BMI widgets'
        Label(self, text = 'Enter your height:').grid(row = 0, column = 0)
        self.ent1 = Entry(self)
        self.ent1.grid(row = 0, column = 1)

        Label(self, text = 'Enter your weight:').grid(row = 1, column = 0)
        self.ent2 = Entry(self)
        self.ent2.grid(row = 1, column = 1)

        Button(self, text = 'Compute BMI', command =lambda: self.compute()).grid(row = 3, column = 0, columnspan = 2 )

    def compute(self):
        'the handler for button "Compute BMI"'
        try:
            h = int(self.ent1.get())
            w = int(self.ent2.get())
            bmi = w*703/h**2
            r = ''
            if bmi < 18.5:
                r = 'underweight'
            elif bmi < 25:
                r = 'normal'
            elif bmi < 30:
                r = 'overweight'
            else: # bmi > 30
                r = 'obese'
            showinfo(title='Results', message = 'Your BMI is {} \n You are in the {} range.'.format(bmi,r))
            self.ent1.delete(0,END)
            self.ent2.delete(0,END)
        except:
            showinfo(title='Error', message = 'Invalid Number')
            self.ent1.delete(0,END)
            self.ent2.delete(0,END)

