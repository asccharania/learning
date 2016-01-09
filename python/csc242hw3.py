# CSC 242-503
# Assignment 3 

# Patrick Krebs 

# I worked alone.

# Question 1
class Money(object):
     'A class that represents a dollar ammount.'
     
     def __init__(self, dollars = 0, cents = 0):
          'The Constructor'
          self.d = dollars
          self.c = cents
     
     def __str__(self):
          'Nicely formatted value of money'
          if self.c >= 10:
               return '${}.{}'.format(self.d,self.c)
          else:
               return '${}.0{}'.format(self.d,self.c)
     
     def __repr__(self):
          'Canonical form for the money object'
          return 'Money({},{})'.format(self.d,self.c)
     
     def convert(self):
          'Converst the Money object to Euros'
          return (self.d * .86) + ((self.c/100) * .86)
     
     def __add__(self, other):
          'Allows two Money objects to be added together'
          newDollars = self.d + other.d
          newCents = self.c + other.c 
          if newCents >= 100:
               newDollars += 1
               newCents = newCents - 100
          if newCents < 0:
               newDollars -= 1
               newCents = newCents + 100
          new = Money(newDollars,newCents)
          return new
     
     def __sub__(self, other):
          'Allows two Money objects to be subtracted'
          newDollars = self.d - other.d
          newCents = self.c - other.c 
          if newCents >= 100:
               newDollars += 1
               newCents = newCents - 100
          if newCents < 0:
               newDollars -= 1
               newCents = newCents + 100
          new = Money(newDollars,newCents)
          return new
     
     def __gt__(self, other):
          'Compares two money objects, checking if the first is larger'
          if self.d > other.d:
               return True
          elif self.d == other.d:
               if self.c > other.c:
                    return True
               else:
                    return False
          else: # self.d < other.d
               return False 
     
     def __neg__(self):
          'Negates a Money Object'
          return Money(-self.d,self.c)
     
     def zero():
          'returns a Money object with zero dollars and zero cents'
          return Money(0,0)          

# Question 2
class BankAccount(object):
     'Represents a Bank Account that has a money value as its balance.'
     
     def __init__(self, initBalance = Money.zero()):
          'The constructor'
          self.b = initBalance
          self.t = []
     
     def __str__(self):
          'returns a string showing the balance of the BankAccount'
          return 'Your balance is {}'.format(self.b)
     
     def deposit(self, amount):
          '''updates the balance of the bank account by depositing
           amount into the account'''
          self.b += amount
          self.t.append(amount)
     
     def withdraw(self, amount):
          '''updates the balance of the bank account by taking
           amount out of the account'''
          self.b -= amount
          self.t.append(-amount)
     
     def getBalance(self):
          'returns the balance of the BankAccount, which is a Money object'
          return self.b
     
     def getTransactions(self):
          '''returns the list of transactions processed so far,
          which is a list of Moneyobjects.'''
          return self.t
     
     def __getitem__(self, index):
          'returns the transaction in position index in the transactions list'
          return self.t[index]

