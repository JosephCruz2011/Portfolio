# -*- coding: utf-8 -*-
"""
CPSC-51100-Spring 2021
Joe Cruz
Programming Assignment #3 Week 3 ("NearestNeighbor.py")
03Feb2021
"""


import numpy as np

print('CPSC-51100', 'Spring 2021')
print('Joe Cruz')
print('PROGRAMMING ASSIGNMENT #3\n')

#Initialize training and testing data and labels from csv files
iris_training_data = np.loadtxt('iris-training-data.csv', delimiter=',', usecols=(0,1,2,3))
iris_training_labels =  np.loadtxt('iris-training-data.csv', dtype = '<U15', delimiter=',', usecols=(4))

iris_testing_data=  np.loadtxt('iris-testing-data.csv', delimiter=',', usecols=(0,1,2,3))
iris_testing_labels =  np.loadtxt('iris-testing-data.csv', dtype = '<U15', delimiter=',', usecols=(4))

#computes distance between testing and training data points and returns an array of minimum indices 
distances = np.sqrt(((iris_testing_data[:,np.newaxis] - iris_training_data [np.newaxis,:])**2).sum(2)).argmin(1)

#The testing samples are classified using the minimum indices arrays and finding the training data with the closest distance. 
predicted_labels = iris_training_labels[distances]

#Performs comparison between the iris_testing labels (actual labels) and the predicted labels
compare_actual_to_prediction = (iris_testing_labels == predicted_labels)

#Performs calculation of percent accuracy of the predicted_labels. 
accuracy = ((compare_actual_to_prediction ==True).sum() / compare_actual_to_prediction.shape)*100

#Creates formatted string used for printing to the console and to generate strings that will be saved into an array
formatted_string_console="%s,%s,%s"

#Creates formatted string used for printing the percent accuracy
formatted_string_accuracy="Accuracy: %.2f%s"

#list of results are created to house all the string values of #, True, Predicted that will be then converted into an array.
result_list=[]

#output #, True, Predicted is printed for the console. 
print("#, True, Predicted")

#An iteration is performed to go through and create the formatted string that will be output to the console and saved into the temp list for the array
for i in range(len(iris_testing_labels)):
  print(formatted_string_console % (i+1 , iris_training_labels[i], predicted_labels[i]))
  result_list.append(formatted_string_console % (i+1 , iris_training_labels[i], predicted_labels[i]))

#Accuracy is printed to the console
print(formatted_string_accuracy % (accuracy[0],"%"))

#The temporary list is used to create an array of #, True, and Predicted as a 1D Array of Strings.
result_array= np.array(result_list)
#print(result_array)