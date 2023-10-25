
# coding: utf-8

# In[31]:


"""
Artificial Intelligence
MP1: A* for Sliding Puzzle
SEMESTER: Fall 2021
NAME: Joe Cruz

The purpose of this program is to implement the A* search algorithm for solving instances of a 3x3 0-9 sliding tile puzzle. 
This program is largely based upon the base code provided by Piotr Szczurek (view below information). 


Created on Thu Jan  3 14:24:06 2019

@author: Piotr Szczurek

This program implements A* for solving a sliding tile puzzle
"""
import numpy as np
import queue

class PuzzleState():
    #Creates the SOLVED PUZZLE goal that will be used for comparisons.
    SOLVED_PUZZLE = np.arange(9).reshape((3, 3))
    
    #initialization method 
    def __init__(self,conf,g,predState):
        
        self.puzzle = conf     # Configuration of the state
        self.gcost = g         # Path cost
        self._compute_heuristic_cost()  # Set heuristic cost
        self.fcost = self.gcost + self.hcost
        self.pred = predState  # Predecesor state
        self.zeroloc = np.argwhere(self.puzzle == 0)[0]
        self.action_from_pred = None
    
    #hash method
    def __hash__(self):
        return tuple(self.puzzle.ravel()).__hash__()
    
    #computation of heuristic cost utilizing a Manhattan Distance heuristic.
    def _compute_heuristic_cost(self):
        #Rests self hcost to 0
        self.hcost= 0
        
        #Cycles through values in sliding tile puzzle (1-8, 9 is the 0). Determines whether the location of the 
        #value z in the self puzzle and compares it to the location of value z in the goal function. If it is not the same,
        #then the Manhattan distance is calculated (y difference [dif_between_loc_z[0]] + x difference [dif_between_loc_z[1]])
        #The hcost is returned at the end of the iteration.
        for z in [1,2,3,4,5,6,7,8]:
            if not np.array_equal(np.argwhere(self.puzzle==z), np.argwhere(PuzzleState.SOLVED_PUZZLE==z)):
                dif_between_loc_z=abs(np.argwhere(PuzzleState.SOLVED_PUZZLE ==z)[0]- np.argwhere(a==z)[0])
                self.hcost += dif_between_loc_z[0] + dif_between_loc_z[1]
        return self.hcost

    #comparison method to determine if puzzle is solved (returns Boolean)
    def is_goal(self):
        return np.array_equal(PuzzleState.SOLVED_PUZZLE,self.puzzle)
    
    #comparison method to determine if puzzle is equal to the other. (returns Boolean)
    def __eq__(self, other):
        return np.array_equal(self.puzzle, other.puzzle)
    
    #comparison method to determine which fcost is larger (returns Boolean)
    def __lt__(self, other):
        return self.fcost < other.fcost
    
    #returns string version of the self
    def __str__(self):
        return np.str(self.puzzle)
    
    #sets number of moves to 0
    move = 0
    
    #method to show the path taken to obtain the goal state from original
    def show_path(self):
        #determines if predecesor state exists then allows the function to progress
        if self.pred is not None:
            self.pred.show_path()
        
        #points out the first move (when move is 0 it is the start)
        if PuzzleState.move==0:
            print('START')
        
        #prints out move number (then adds to the move counter by 1 for each iteration) and the 
        #action made (from up, left, right, or down)
        else:
            print('Move',PuzzleState.move, 'ACTION:', self.action_from_pred)
        PuzzleState.move = PuzzleState.move + 1
        print(self)
    
    
    #method to determine whether a given action can be performed on given puzzle configuration. Each action type has
    #restricted coordinates that the 0 cannot be in if the action can happen. I.e. if left the 0 cannot be in the 
    #bottom left hand corner. If the 0 is in an allowable spot for the given action it is allowed. (returns Boolean)
    def can_move(self, direction):
        Loc_0= np.argwhere(self.puzzle == 0)[0]
      
        if direction == 'left':
            if (np.array_equal(Loc_0, [0,0])):
                return False
            if (np.array_equal(Loc_0, [1,0])):
                return False
            if (np.array_equal(Loc_0, [2,0])):
                return False
            else: 
                return True
        elif direction == 'down':
            if (np.array_equal(Loc_0, [2,0])):
                return False
            if (np.array_equal(Loc_0, [2,1])):
                return False
            if (np.array_equal(Loc_0, [2,2])):
                return False
            else:
                return True
        elif direction == 'up':
            if (np.array_equal(Loc_0, [0,0])):
                return False
            if (np.array_equal(Loc_0, [0,1])):
                return False
            if (np.array_equal(Loc_0, [0,2])):
                return False
            else: 
                return True
        elif direction == 'right':
            if (np.array_equal(Loc_0, [0,2])):
                return False
            if (np.array_equal(Loc_0, [1,2])):
                return False
            if (np.array_equal(Loc_0, [2,2])):
                return False
            else:
                return True

    #method to generate the next puzzle state based off the current puzzle and the direction action used.     
    def gen_next_state(self, direction):
        #creates a copy of the self object
        copy = self
        
        #creates two copies of the puzzle array (for comparisons later)
        copy_puzzle_1 = self.puzzle.copy()
        copy_puzzle = self.puzzle.copy()
        
        #establishes dictionary to hold directional values for the move actions
        directions = {'up': [-1, 0],'down': [1, 0],'left': [0, -1],'right': [0, 1]}
        
        #Determines where the 0 is and creates the new coordinate for the 0 based on the cost of the  
        Loc_0_old = np.argwhere(copy_puzzle == 0)[0]
        Loc_0_new = Loc_0_old + directions[direction]
        
        #Determines the value that will be swapped out
        swap_value= copy_puzzle[Loc_0_new[0]] [Loc_0_new[1]]
        
        #performs swap between 0 and the value that needs to be swapped.
        copy_puzzle[Loc_0_new[0]] [Loc_0_new[1]] = 0
        copy_puzzle[Loc_0_old[0]] [Loc_0_old[1]] = swap_value
        
        #creates g cost (since g is equal to number of moves needs to add 1 to account for the move)
        g=copy.gcost + 1
        
        #establishes the predecesor state to use for creation of the next puzzle state (used copy to preserve the original)
        predState=copy_puzzle_1
        
        #creates next puzzle state
        next_state = PuzzleState(copy_puzzle, g, self)
        
        ###TESTING MATERIAL TO CHECK THE predecesor state and new state to compare and make sure it is working
        #print("This is the predSTATE: \n", predState)
        #print("This is the suggested new_state =\n", next_state)
 
        ##TESTING TO MAKE SURE F COSTS ARE CHANGING AND CORRECT
        #print("newconfig_fcost: ", next_state.fcost)
        #pred_State_f= self.fcost
        #print("old_config_fcost: ", pred_State_f)
        
        #compares the next state to the pred state f costs to the next state f costs and returns the original state
        #if f cost of new is larger than the previous and returns the next state if it is not larger than the original
        if self.__lt__(next_state):
            return self
        else:
            self=copy
            return next_state
        
        
###MAIN METHOD

print('Artificial Intelligence')
print('MP1: A* for Sliding Puzzle')
print('SEMESTER: Fall 2021')
print('NAME: Joe Cruz')
print()

# load random start state onto frontier priority queue
frontier = queue.PriorityQueue()
a = np.loadtxt('mp1input1.txt', dtype=np.int32)

#These are the commands for importing the other test documents 'mp1input2.txt' and 'mp1input3.txt' (TESTING PURPOSES ONLY)
#a = np.loadtxt('mp1input2.txt', dtype=np.int32)
#a = np.loadtxt('mp1input3.txt', dtype=np.int32)

#creates the start state, initializes the puzzle as what is found in a text file
start_state = PuzzleState(a,0,None)

#puts the start_state in the frontier (basically the goal path states)
frontier.put(start_state)

#creates the closed_set (to hold all states that do not work)
closed_set = set()

#sets number of states to 0
num_states = 0

#while loop (while there are still states in the frontier---> (LIFO grab the last puzzle state put in and put as next_state))
while not frontier.empty():
    #  choose state at front of priority queue
    next_state = frontier.get()
    
    #  rolling counter for number of states visited
    num_states = num_states + 1

    #  if goal then quit and return path
    if next_state.is_goal():
        next_state.show_path()
        break
    
    # Add state chosen for expansion to closed_set
    closed_set.add(next_state)
    
    # Expand state (up to 4 moves possible)
    possible_moves = ['up','down','left','right']
    for move in possible_moves:
        
        #if the next_state move is possible the perform action else next move
        if next_state.can_move(move):
            
            #generates the next puzzle state 
            neighbor = next_state.gen_next_state(move)
            
            #checks if the puzzle state is already in the closed_set (record of all states possible and not)
            if neighbor in closed_set:
                continue
            
            #checks if current puzzle state in is the frontier (if it is not then the puzzle state is put into the frontier)
            #since it is in the frontier, it will have lower cost than the other states so this is effectively the goal path
            #Also the move taken is recorded and set with that puzzle state (i.e. puzzle state x is associated with the 'left' move)
            if neighbor not in frontier.queue:                           
                frontier.put(neighbor)
                neighbor.action_from_pred = move
            # If it's already in the frontier, it's gauranteed to have lower cost, so no need to update

#Final report out of the number of states visited          
print('\nNumber of states visited =',num_states)


# In[ ]:



