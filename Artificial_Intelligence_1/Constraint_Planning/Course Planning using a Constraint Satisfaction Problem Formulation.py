#!/usr/bin/env python
# coding: utf-8

# In[7]:


#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
COURSE: Artificial Intelligence I
MP3: Course Planning using a Constraint Satisfaction Problem Formulation
SEMESTER: Fall 2021
NAME: Joe Cruz
DATE: 07Oct2021

The purpose of this algorithm is to generate potential schedules for students given start and finish term, given all the following constraints:

1. Student will take one and only one course per term.
2. Course that has prerequisites must be taken in a term that follows the term in which all prerequisites are done.
3. The student does not need to repeat courses.
4. Some terms may be skipped as long as the student finishes in Year 3 Fall 2.
5. Student needs to take 3 out of the 8 elective courses. It doesn’t matter which ones are included in the degree plan. Those
courses which are not taken will be labeled as “Not Taken” (see sample output).
6. Student must take all foundation and core courses. 


Program checks if there are possible schedules for students for a given
start and finish term, given all constraints.
This works by mapping a term number to each course, given all constraints.
It assigns a negative term number if course is not taken (e.g. elective that is not needed)

ASSUMPTION: term numbers start with 1
"""

import pandas as pd
import numpy as np
from constraint import *

def create_term_list(terms, years=4):
    '''Create a list of term indexes for years in the future'''
    all_terms = []
    for year in range(years):
        for term in terms:    
            all_terms.append(year*6+term)
    return all_terms
    
def map_to_term_label(term_num):
    '''Returns the label of a term, given its number'''
    term_num_to_label_map = {
            0: 'Fall 1',
            1: 'Fall 2',
            2: 'Spring 1',
            3: 'Spring 2',
            4: 'Summer 1',
            5: 'Summer 2',
    }
    if (term_num < 1):
        return 'Not Taken'
    else:
        return 'Year ' + str((term_num - 1) // 6 + 1) + ' ' + term_num_to_label_map[(term_num - 1) % 6]

def prereq(a, b):
    '''Used for encoding prerequisite constraints, a is a prerequisite for b'''
    if a > 0 and b > 0: # Taking both prereq a and course b
        return a < b
    elif a > 0 and b < 0: # Taking prereq a, but not course b
        return True
    elif a < 0 and b > 0: #  Taking course b, but not prereq a
        return False
    else:
        return True # Not taking prereq a or course b

def get_possible_course_list(start, finish):
    '''Returns a possible course schedule, assuming student starts in start term
       finishes in finish term'''
    problem = Problem()
    
    # Read course_offerings file and stores the sheets in two different sheets
    course_offerings = pd.read_excel('csp_course_rotations.xlsx', sheet_name='course_rotations')
    course_prereqs = pd.read_excel('csp_course_rotations.xlsx', sheet_name='prereqs')
    
    #IF PROGRAM IS NOT WORKING DUE TO ERROR IN READING THIS PREREQS SHEET IT IS A CONSEQUENCE OF VERSION OF PYTHON BEING USED
    #THE PROBLEM IS THAT THE sheet_name VARIABLE WAS CHANGED IN THE NEWER PYTHON VERSION FROM sheetname to sheet_name. 
    #THE FOLLOWING LINE IS FOR IN CASE THE COURSE_PREREQS CANNOT BE READ. 
    #course_prereqs = pd.read_excel('csp_course_rotations.xlsx', sheetname='prereqs')    
    
    
    # Foundation course terms dataframe: Creates the dataframe with the foundation course name as well as the available semester slots.
    foundation_courses = course_offerings[course_offerings.Type=='foundation']
    for r,row in foundation_courses.iterrows():
        problem.addVariable(row.Course, create_term_list(list(row[row==1].index)))
        #TEST:
        #print(row.Course, ':', create_term_list(list(row[row==1].index)))
      
    # Core course terms dataframe: Creates the dataframe with the core course name as well as the available semester slots. 
    core_courses = course_offerings[course_offerings.Type=='core']
    for r,row in core_courses.iterrows():
        problem.addVariable(row.Course, create_term_list(list(row[row==1].index)))
        #TEST:
        #print(row.Course, ':', create_term_list(list(row[row==1].index)))
        
    
    # CS Electives course terms (-x = elective not taken): Creates the dataframe with the elective course name as well as the 
    #the available semester slots. This also adds a negative value at the end of each of the courses so that they can be selected
    #for the constraint at a later time. 
    elective_courses = course_offerings[course_offerings.Type=='elective']
    for r,row in elective_courses.iterrows():
        problem.addVariable(row.Course, create_term_list(list(row[row==1].index)) + [-r])
        #Test:
        #print(row.Course, ':', create_term_list(list(row[row==1].index)) + [-r])
    
    
    # Capstone: Creates the dataframe with the capstone course name as well as the available semester slots. (Should only be 1 course for the given data.)
    capstone_courses = course_offerings[course_offerings.Type=='capstone']
    for r, row in capstone_courses.iterrows():
        problem.addVariable(row.Course, create_term_list(list(row[row==1].index)))
        #TEST:
        #print(row.Course, ':', create_term_list(list(row[row==1].index)))
     
    #CONSTRAINTS:

    #Ensures the student starts in the first term: Year 1, Fall 1.
    #Sets constraint to make student start in the Year 1, Fall 1 term.
    problem.addConstraint(SomeInSetConstraint([1]))
    
    #1. Student will take one and only one course per term. 
    #3. The student does not need to repeat courses.
    #Gurantees no repeats in terms and ensures that courses are not repeated.  
    problem.addConstraint(AllDifferentConstraint())
    
    #2. Course that has prerequisites must be taken in a term that follows the term in which all prerequisites are done.
    #Control prerequisites.
    for z, row in course_prereqs.iterrows():
        problem.addConstraint(prereq, [course_prereqs.prereq.values[z], course_prereqs.course.values[z]])
    
    #4. Some terms may be skipped as long as the student finishes in Year 3 Fall 2.
    #Sets the constraint to make the student finish the degree by Year 3, Fall 2 term. 
    problem.addConstraint(NotInSetConstraint([15, 16, 17, 18, 19, 20, 21, 22, 23, 24]))

    #5. Student needs to take 3 out of the 8 elective courses. It doesn’t matter which ones are included in the degree plan. Those
    #courses which are not taken will be labeled as “Not Taken” (see sample output).
    # Control electives - exactly 3 courses are chosen given the options. 
    problem.addConstraint(SomeInSetConstraint([-9, -10, -11, -12, -13, -14, -15, -16], n = 5, exact=True))
    
    #6. Student must take all foundation and core courses. 
    #This constraint is satisfied given that there are no restrictions placed on the foundation or core classes. 
    #Unlike the electives, all the classes in foundation and core are required to get put up on the board just because they
    #have not been controlled similar to that of the electives. 

    
    # Generate a possible solution
    sol = problem.getSolutions()
    print("Number of Possible Degree Plans is ", len(sol))
    print("\nSample Degree Plan")
    s = pd.Series(sol[0])
    #TEST 
    #print(s.sort_values().map(map_to_term_label))
    return s.sort_values().map(map_to_term_label)

# Print heading
print("CLASS: Artificial Intelligence, Lewis University")
print("NAME: Joe Cruz\n")

# Check for possible schedules for all start terms
for start in [1]:
    print('START TERM = ' + map_to_term_label(start))
    s = get_possible_course_list(start,start+13)
    if s.empty:
        print('NO POSSIBLE SCHEDULE!')
    else:
        s2 = pd.Series(s.index.values, index=s)
        print(s2.to_string())
    print()


# In[ ]:





# In[ ]:




