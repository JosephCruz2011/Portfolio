
# coding: utf-8

# In[ ]:

### !/usr/bin/env python3

"""

COURSE: Artificial Intelligence I
MP2: Gen-Tic-Tac-Toe Minimax Search with alpha/beta pruning
SEMESTER: Fall 2021
NAME: Joe Cruz
DATE: 28Sept2021

The purpose of this algorithm is to utilize Minimax Search and alpha/beta pruning to play tic tac toe. The algorithm created
will choose an optimized move against the opponent. 


Created on Fri Jan 18 14:30:21 2019

@author: szczurpi

Machine Problem 2
Gen-Tic-Tac-Toe Minimax Search with alpha/beta pruning
"""
import numpy as np
import random
import math

# self class is responsible for representing the game board
class GenGameBoard: 
    
    # Constructor method - initializes each position variable and the board size
    def __init__(self, boardSize):
        self.boardSize = boardSize  # Holds the size of the board
        self.marks = np.empty((boardSize, boardSize),dtype='str')  # Holds the mark for each position
        self.marks[:,:] = ' '
    
    
    # Prints the game board using current marks
    def printBoard(self): 
        # Prthe column numbers
        print(' ',end='')
        for j in range(self.boardSize):
            print(" "+str(j+1), end='')
        
        
        # Prints the rows with marks
        print("")
        for i in range(self.boardSize):
            # Prthe line separating the row
            print(" ",end='')
            for j in range(self.boardSize):
                print("--",end='')
            
            print("-")

            # Prthe row number
            print(i+1,end='')
            
            # Prthe marks on self row
            for j in range(self.boardSize):
                print("|"+self.marks[i][j],end='')
            
            print("|")
                
        
        # Prints the line separating the last row
        print(" ",end='')
        for j in range(self.boardSize):
            print("--",end='')
        
        print("-")

    
    # Determines whether a game winning condition exists
    # If so, returns True, and False otherwise
    def checkWin(self, mark):
        won = False # Variable holding the return value
        
        # Check wins by examining each combination of positions
        
        # Check each row
        for i in range(self.boardSize):
            won = True
            for j in range(self.boardSize):
                if self.marks[i][j]!=mark:
                    won=False
                    break        
            if won:
                break
        
        # Check each column
        if not won:
            for i in range(self.boardSize):
                won = True
                for j in range(self.boardSize):
                    if self.marks[j][i]!=mark:
                        won=False
                        break
                if won:
                    break

        # Check first diagonal
        if not won:
            for i in range(self.boardSize):
                won = True
                if self.marks[i][i]!=mark:
                    won=False
                    break
                
        # Check second diagonal
        if not won:
            for i in range(self.boardSize):
                won = True
                if self.marks[self.boardSize-1-i][i]!=mark:
                    won=False
                    break

        return won
    
    # Determines whether the board is full
    # If full, returns True, and False otherwise
    def noMoreMoves(self):
        return (self.marks!=' ').all()

    
    # Attempts to make a move given the row,col and mark
    # If move cannot be made, returns False and prints a message if mark is 'X'
    # Otherwise, returns True
    def makeMove(self, row, col, mark):
        possible = False  # Variable to hold the return value
        if row==-1 and col==-1:
            return False
        
        # Change the row,col entries to array indexes
        row = row - 1
        col = col - 1
        
        if row<0 or row>=self.boardSize or col<0 or col>=self.boardSize:
            print("Not a valid row or column!")
            return False
        
        # Check row and col, and make sure space is empty
        # If empty, set the position to the mark and change possible to True
        if self.marks[row][col] == ' ':
            self.marks[row][col] = mark
            possible = True    
        
        # Prout the message to the player if the move was not possible
        if not possible and mark=='X':
            print("\nself position is already taken!")

        return possible
    
    
    #This method runs the minimax search algorithm that determines the value of each move the computer can make.
    #The best move (that minimizes the utility of the player) is selected and performed. 
    def makeCompMove(self):
        
        #alpha and beta values initialized to serve as the bounds.
        alpha_max = -10
        beta_min = 10
        
        #creates a save state for the board before determining the optimal move
        state = self.marks.copy()
        
        #recursive method to determine the optimal move as well as its respective utility score using alpha/beta pruning in minimax search
        utility, move = self.max_value(alpha_max, beta_min)

        #TEST: Returns the utility and the move that are returned by the minimax search. To ensure that they are returned properly.  
        #print("THIS IS THE FINAL RETURNED UTILITY:", utility)
        #print("THIS IS THE FINAL RETURNED MOVE (coordinate pair [x y])", move)
        
        #restores the board back to save state prior to determination of optimal move.  
        self.marks = state
        
        #Operator to extract the row and col from the move returned in coordinate pair [row, col] in the optimal move returned. 
        row = int(float(str(move[0]))) + 1
        col = int(float(str(move[1]))) + 1            
        
        #Performs most optimal move determined. 
        self.makeMove(row, col, 'O')
        return 
    

    
    #Max_value method used to determine the O move (max player) designed to return the move with the highest 
    #utility score for the player. 
    def max_value(self, alpha_max, beta_min):
        
        #checks whether this is terminal state (where there are either wins for either side or the board is full). 
        #This method returns the utility of the terminal state and no action (move)
        if self.is_terminal():
      
            #obtains the utility of the terminal state
            utility = self.get_utility()
            return utility, None
        
        #create move_want and v, move_want is the desired move that we want to return back to the and v is the maximum utility_score
        #found by the search. At the moment we are initialized at alpha_max. 
        move_want= None
        v = alpha_max
        
        #iterates through the available actions at the current state
        for i in self.get_actions():
                   
            #extracts the row and col from the move available (current format returns coordinates [row, col])
            row = int(float(str(i[0]))) + 1
            col = int(float(str(i[1]))) + 1
            
            #TEST: Prints the current state before the move is made.
            #print("This is the state before the move state max_: ", self.marks)
            
            #create save state to revert back to based on current self
            state_copy_1 = self.marks.copy() 
            
            #performs the move extracted.
            self.makeMove(row, col, 'O')
            
            #Test: Prints the state after the move was made as well as the current max utility(v)
            #print("This is the move state max_: ", self.marks)
            #print("This is v:", v)
            
            #Simulates the game for the move made through the minimax search recursion.
            min_value_utility, move_made_next = self.min_value(alpha_max, beta_min)
            
            #Test: Prints the utility of the move after the utility of the next move is calculated. This will only return the value after a 
            #terminal leaf node is reached.
            #print("This is min_value_utility: ", min_value_utility)
            
            #the gameboard is reverted back to the state before the move was made. 
            self.marks = state_copy_1
            
            #compares the new utiility (v2) to previous utility (v) if v2 is larger than v, the move coordinates are saved. 
            #and the alpha max value is changed pending upon whether v2 is larger than v (v is then reinstated to be the v2 as well)
            if min_value_utility > v:
                
                #Records the action in move_want
                move_want = i
                
                #Test: Prints the action/move that is passed through (i)
                #print("This is the move2 ", i )
                
                #The alpha max bound is updated. 
                alpha_max = max(min_value_utility, alpha_max)
                
                #The maximum utility value is updated to be the utility of the action stored. 
                v = min_value_utility
                
            #compares the v value to the beta_min which is the upper bound. if this statement is true, then the state is returned to previous
            #and the current value of v and the action_last action done will be returned. 
            if v >=beta_min:
                return v, move_want
        
        #end of the method returns current value of v(utility) and the action. 
        return v, move_want


    #Min_value method used to determine the simulated X move (min player) to return the move in which the lowest 
    #utility for the X move player (min player).
    def min_value(self, alpha_max, beta_min): 

        #checks whether this is terminal state (where there are either wins for either side or the board is full). 
        #This method returns the utility of the terminal state and no action (move)
        if self.is_terminal():
            
            #obtains the utility of the terminal state
            utility = self.get_utility()
            return utility, None
        
        #create move_want and v, move_want is the desired move that we want to return back to the and v is the maximum utility_score
        #found by the search. At the moment we are initialized at beta_min. 
        move_want = None
        v = beta_min
        
        #iterates through the available actions at the current state
        for i in self.get_actions():
            
            #create save state to revert back to based on current self
            state_copy_1 = self.marks.copy()
            
            #extracts the row and col from the move available (current format returns coordinates [row, col])
            row = int(float(str(i[0]))) + 1
            col = int(float(str(i[1]))) + 1
            
            #TEST: Prints the state before the move is made
            #print("This is the state before move state min_: ", self.marks)
            
            #Performs the move available (action is made)
            self.makeMove(row, col, 'X')

            #TEST: Prints the new state as well as the action made (i)
            #print("This is the move state min_: ", self.marks)
            #print("This is the current move _ min : ", i)
            
            #Simulates the game for the move made through the minimax search recursion.
            max_value_utility, move_2 = self.max_value(alpha_max, beta_min)
            
            
            #Test: Prints the utility of the move after the utility of the next move is calculated. This will only return the value after a 
            #terminal leaf node is reached.
            #print("This is max_value_utility: ", max_value_utility)
            
            #the gameboard is reverted back to the state before the move was made. 
            self.marks = state_copy_1
            
            
            #Checks if the new utility of the move (v2) is smaller than v (current max utility).
            if max_value_utility < v:

                #records the action in move_want
                move_want = i
                
                #Test: Prints the action/move that is passed through (i)
                #print("This is the move2_min: ", move_want)
                
                #The beta_min bound is updated.
                beta_min= min(beta_min, v)
                
                #The maximum utility value is updated to be the utility of the action stored. 
                v = max_value_utility
                
            #compares the v value to the alpha_max which is the lower bound. if this statement is true, then the state is returned to previous
            #and the current value of v and the action_last action done will be returned. 
            if v <= alpha_max:
                return v, move_want
            
        #end of method will return the current utility and the current action. 
        return v, move_want
  
    #This function gets the utility of a terminal state (-1 represents X win, 1 represents O win, and 0 represents draw)
    def get_utility(self):
        """
        Finds the utility of a terminal state
        """
        assert self.is_terminal()
        if self.checkWin('X'):
            return -1
        elif self.checkWin('O'):
            return 1
        else:
            return 0
        
    
    def get_actions(self):
        '''Generates a list of possible moves'''
        return np.argwhere(self.marks == ' ')

    
    #is_terminal method created to determine whether a state is considered terminal (either gameboard full or there is a win on either side)
    #returns boolean pending on conditions, true if there is a terminal state and false if otherwise. Need this otherwise error thrown for assertion. 
    def is_terminal(self):
        if self.noMoreMoves() or self.checkWin ('O') or self.checkWin ('X'):
            return True
        return False

# Print out the header info
print("CLASS: Artificial Intelligence, Lewis University")
print("NAME: Joe Cruz")

LOST = 0
WON = 1
DRAW = 2    
wrongInput = False
boardSize = int(input("Please enter the size of the board n (e.g. n=3,4,5,...): "))
        
# Create the game board of the given size
board = GenGameBoard(boardSize)
        
board.printBoard()  # Print the board before starting the game loop
        
# Game loop
while True:
    # *** Player's move ***        
    
    # Try to make the move and check if it was possible
    # If not possible get col,row inputs from player    
    row, col = -1, -1
    while not board.makeMove(row, col, 'X'):
        print("Player's Move")
        row, col = input("Choose your move (row, column): ").split(',')
        row = int(row)
        col = int(col)

    # Display the board again
    board.printBoard()
            
    # Check for ending condition
    # If game is over, check if player won and end the game
    if board.checkWin('X'):
        # Player won
        result = WON
        break
    elif board.noMoreMoves():
        # No moves left -> draw
        result = DRAW
        break
            
    # *** Computer's move ***
    board.makeCompMove()
    
    # Print out the board again
    board.printBoard()    
    
    # Check for ending condition
    # If game is over, check if computer won and end the game
    if board.checkWin('O'):
        # Computer won
        result = LOST
        break
    elif board.noMoreMoves():
        # No moves left -> draw
        result = DRAW
        break
        
# Check the game result and print out the appropriate message
print("GAME OVER")
if result==WON:
    print("You Won!")            
elif result==LOST:
    print("You Lost!")
else: 
    print("It was a draw!")


