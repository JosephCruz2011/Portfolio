# -*- coding: utf-8 -*-
"""
CPSC-51100-Spring 2021
Joe Cruz
Programming Assignment #4 Week 4 ("ProbEst.py")
03Feb2021
"""
print('CPSC-51100', 'Spring 2021')
print('Joe Cruz')
print('PROGRAMMING ASSIGNMENT #4\n')
      
import pandas as pd

#loads cars.csv file into pandas DataFrame
cars = pd.read_csv('cars.csv')

#cleans DataFrame so that only the 'make' and 'aspiration' column are present
cars_cleaned_df = cars[['make', 'aspiration']]

#counts how many times each model is found in the data set (total_number per model)
make_counts= cars_cleaned_df.make.value_counts().sort_index()

#determines the total number of data points in the dataset (205)
total_instances= cars_cleaned_df['make'].count()

#Conditional probability of a make being either std or turbo for its aspiration is calculated using crosstab
#the normalization is set to index to calculate these values and they are rounded to 2 decimals for ease of printing.  
probability= (pd.crosstab(cars_cleaned_df.make, cars_cleaned_df.aspiration, normalize= 'index')*100).round(decimals=2).stack()

#The aspiration conditional probabilies are stored in a DataFrame in such a way that these are paired with their respective makes.
probability_df= pd.DataFrame({'id':probability.index.to_list(), 'probability':probability})

#lambda function to print the conditional probabilities of each aspiration for its make. 
print_probabilites= lambda z: print("Prob(aspiration=" + z.id[1] + "|make=" +z.id[0] + ") = " + str(z.probability) + "%")

#performs the previously described lambda function.
probability_df.apply(print_probabilites, axis=1)

#format_print statement for space
print()

#determines the probabilties of each make based on the total data set.
make_probabilities = (make_counts / total_instances *100).round(decimals=2)

#The probabilities of the makes are stored in the data frame with their respective makes                 
make_probabilities_df=pd.DataFrame({'make_name':cars_cleaned_df['make'].unique(), 'make_probability': make_probabilities})

#lambda function to pair the make with it's respective probability in a print statement on the console.
print_make_probability = lambda x: print('Prob(make=' + x.make_name+') =', x.make_probability, '%')

#perform the print to console of the make probabilities.
make_probabilities_df.apply(print_make_probability, axis=1)
