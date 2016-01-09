# CSC 242-503
# Assignment 4 

# Patrick Krebs

# I worked alone

class Money(object):
     'an abstraction of a dollar amount'
     def __init__(self, dollars = 0, cents = 0):
          'the constructor'
          self.dollars = dollars
          self.cents = cents
          
     def __str__(self):
          'display the money with 2 decimal places'
          if abs(self.cents) < 10:
               s = '${}.0{}'.format(self.dollars, abs(self.cents))
          else:
               s = '${}.{}'.format(self.dollars, abs(self.cents))
          return s
     
     def __repr__(self):
          'the canonical representation'
          return 'Money({},{})'.format(self.dollars, abs(self.cents))
     
     def convert(self):
          'convert to Euros; $1 = .86 euros'
          return (self.dollars + self.cents/100)*.86
     
     def __add__(self, other):
          'add two objects together and return a new one'
          mycents = self.dollars * 100 + self.cents
          othercents = other.dollars * 100 + other.cents
          allcents = mycents + othercents
          newdollars = abs(allcents) // 100
          newcents = abs(allcents) % 100
          if allcents < 0:
               newdollars *= -1
               newcents *= -1
          return Money(newdollars, newcents)
     
     def __sub__(self, other):
          'substract an object from another returning the result'
          mycents = self.dollars * 100 + self.cents
          othercents = other.dollars * 100 + other.cents
          allcents = mycents - othercents
          newdollars = abs(allcents) // 100
          newcents = abs(allcents) % 100
          if allcents < 0:
               newdollars *= -1
               newcents *= -1
          return Money(newdollars, newcents)
     
     def __gt__(self, other):
          'return True if the first object is greater than the second'
          mycents = self.dollars * 100 + self.cents
          othercents = other.dollars * 100 + other.cents
          return mycents > othercents
     
     # Method added for the fourth assignment
     def __ge__(self, other):
          'return True if the first object is greater than or equal to the second'
          mycents = self.dollars * 100 + self.cents
          othercents = other.dollars * 100 + other.cents
          return mycents >= othercents
     
     def __neg__(self):
          'return the negation of a dollar amount'
          return Money(-self.dollars, -self.cents)
     
     def zero():
          'return a zero dollar amount'
          return Money(0,0)
          

class BankAccount(object):
     'Represents a Bank Account that has a money value as its balance.'
     
     def __init__(self, initBalance = Money.zero()):
          'The constructor'
          if initBalance >= Money.zero():
               self.balance = initBalance
               self.transactions = []
          else:
               raise DepositError('intial balance of {} is invalid'.format(initBalance))
               
     def __str__(self):
          'returns a string showing the balance of the BankAccount'
          return 'Bank account with balance {}'.format(self.balance)


     def deposit(self, amount):
          '''updates the balance of the bank account by depositing
           amount into the account'''
          if amount >= Money.zero():
               self.balance = self.balance + amount
               self.transactions.append(amount)
          else:
               raise DepositError('deposit of {} is invalid'.format(amount))

     def withdraw(self, amount):
          '''updates the balance of the bank account by taking
           amount out of the account'''
          if self.balance > amount:
               self.balance = self.balance - amount
               self.transactions.append(-amount)
          else:
               raise WithdrawError('balance of {} is invalid'.format(self.balance - amount))
               
     def getBalance(self):
          'returns the balance of the BankAccount, which is a Money object'
          return self.balance

     def getTransactions(self):
          '''returns the list of transactions processed so far,
          which is a list of Money
          objects.'''
          return self.transactions

     def __getitem__(self, index):
          'returns the transaction in position index in the transactions list'
          return self.transactions[index]

     # Write this method for the first question
     def __iter__(self):
          'Iterator for the BankAccount class'
          return RevListIter(self.getTransactions())

     # Method added for the fourth assignment
     def __repr__(self):
          'Returns canonical reporesentation of the object'
          return repr(self.balance)
     
class RevListIter(object):
    'reversed list iterator'
    
    def __init__(self, l):
        'create the iterator'
        self.lst = l
        self.index = len(self.lst) - 1

    def __next__(self):
        'return the next item in the list'
        if self.index < 0:
            raise StopIteration()
        item = self.lst[self.index]
        self.index -= 1
        return item

class WithdrawError(Exception):
     'Raising Exceptions for Withdraw Errors since 2015'
     pass

class DepositError(Exception):
     'An exception class for Deposit Errors'
     pass

# Question 3
def processTrans(fname):
    'A function that processes transactions found in file fname'
    acct = BankAccount()
    
    try:
         infile = open(fname)
         lines = infile.readlines()
         infile.close()
    except:
          print('File {} could not be opened. Exiting Program'.format(fname))
          return acct
    
    for items in lines:
         trans = items.replace('\n','')
         trans = trans.replace('\t','')
         trans = trans.replace(' ','')
         for item in range(len(trans)):
              try:
                   if trans[item] in 'wW':
                        w = Money(int(trans[1:]))
                        acct.withdraw(w)
                        print('Withdraw:  {}'.format(w))
              except WithdrawError as e:
                   print('Withdraw skilled in file {}: {}'.format(fname,e))
              try: 
                   if trans[item] in 'dD':
                        d = Money(int(trans[1:]))
                        acct.deposit(d)
                        print('Deposit:  {}'.format(d))
              except DepositError as e:
                   print('Deposit skilled in file {}: {}'.format(fname,e))

    print('Final Balance: {}'.format(acct.getBalance()))
    print('Final List of Transactions: {}'.format(acct.getTransactions()))
    return acct

                   

