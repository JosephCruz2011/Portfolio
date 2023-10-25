# -*- coding: utf-8 -*-
"""
CPSC-51100-Spring 2021
Joseph Cruz
Programming Assignment #1 Week 1 ("OnlineStats.py")
23Jan2021

"""
     
#Hello. This program is designed to calculate the mean and variance of non-negative
#numbers by utilizing online update formulas given in the homework. The program will terminate upon entry 
#of a negative number or if "q" is input. 

#The following are the update formulas used:
#updated_mean = current mean + ((newly entered value - current mean)/size_of_data_set)
#updated_variance = ((size_of_data_set -2)/(size_of_data_set-1))*current variance + (((newly entered value - current mean)^2)/size_of_data_set)
# *** updated_variance only works assuming that the sample size is greater than 1 



print("\nData 51100-Spring 2021")
print("Joseph Cruz")
print("Programming Assignment #1 Week 1")
 
#initialize list, variables, and formatted string for final report out
number_list=[]
mean = 0
variance = 0
formatted_string="Mean is %.2f and variance is %.4f"

#User input entry
number=int(input("Enter a number: "))

#perform update on mean and variance as long as the entered number is not a negative number.
while number >=0:
    number_list.append(number)  
    sample_size= len(number_list)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           
    
    #as long as the sample size is above 1, the variance 
    if sample_size>1:
        variance =  (((sample_size-2)/(sample_size -1) * variance) + ((number-mean)**2/ (sample_size)))
    
    #updated mean
    mean += (number-mean)/sample_size
    
    #result is printed out to user
    print(formatted_string % (mean , variance))
        
    #user can continue entering numbers to continue calculating means and variances of the data set entered.
    #it is important to note that since these variances and means are updated based on each entry, that the 
    #user will continue to obtain newly updated means and variances with each entry of data. 
    number=int(input("Enter a number: "))
    
    #breaks the while loop through use of "q". 
    if number == "q":
        break
    


