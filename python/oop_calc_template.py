from tkinter import Frame, Button, Entry, END

class Calculator(Frame):
    """
      The calculator has a layout like this:
      < display >
      7 8 9 *
      4 5 6 /
      1 2 3 -
      0 = + C
    """
    
    def __init__(self, parent = None):
        Frame.__init__(self, parent)
        self.make_widgets()
        self.grid()

    def make_widgets(self):
        btn_list = [
        '7', '8', '9', '*',
        '4', '5', '6', '/',
        '1', '2', '3', '-',
        '0', '=', '+', 'C']
               
        # create all buttons with a loop
        r = 1
        c = 0
        for b in btn_list:
            rel = 'ridge'
            cmd = lambda x=b: self.click(x)
            Button(self,text=b,width=7, relief = rel,command=cmd).grid(row=r,column=c)
            c += 1
            if c > 3:
                c = 0
                r += 1

        # use Entry widget for an editable display
        self.entry = Entry(self, width=33)#, bg="lightblue", fg ="blue")
        self.entry.grid(row=0, column=0, columnspan=4)

    def click(self, key):
        if key == '=':
            try:
                result = eval(self.entry.get())
                self.entry.insert(END, " = " + str(result))
            except:
                self.entry.insert(END, "--> Error!")
        elif key == 'C':
            self.entry.delete(0, END) # clear entry
        else:
        # The previous calculation has been done, so clear entry
            if '=' in self.entry.get():
                self.entry.delete(0, END)
            self.entry.insert(END, key)


Calculator().mainloop()
