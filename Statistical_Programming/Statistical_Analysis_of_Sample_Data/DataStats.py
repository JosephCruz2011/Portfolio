# -*- coding: utf-8 -*-
"""
CPSC-51100-Spring 2021
Joe Cruz
Programming Assignment #5 Week 5 ("DataStats.py")
18Feb2021
"""
print('CPSC-51100', 'Spring 2021')
print('Joe Cruz')
print('PROGRAMMING ASSIGNMENT #5\n')
      
import pandas as pd
import re

#This was used for debugging since would throw setting with copy warning
pd.set_option('mode.chained_assignment', None)

#loads cps.csv file into pandas DataFrame
school_info = pd.read_csv('cps.csv')

#cleans DataFrame so that only the 'School_ID', 'Short_Name', 'Is_High_School', 'Zip', 'Student_Count_Total', 
#'College_Enrollment_Rate_School', 'Grades_Offered_All', 'School_Hours' columns are present
school_info_df = school_info[['School_ID', 'Short_Name', 'Is_High_School', 'Zip', 'Student_Count_Total', 'College_Enrollment_Rate_School', 'Grades_Offered_All', 'School_Hours']]

#strips the 'Grades_Offerred_All' column data
grades= school_info['Grades_Offered_All'].str.split(',')

#used for determination of the lowest grade taught by taking the first index of the 'Grades_Offered_All' data. 
lowest_grades=grades.apply(lambda x: x[0])

#used for determination of the highest grade taught by taking the last index of the 'Grade_Offered_All' data.
highest_grades= grades.apply(lambda x: x[(len(x))-1])

#function used to obtain the start_time for each school which will be used to create a new compiled column of the int of the start_time.
def get_start_time(x):
    if str(x[0]) == 'nan':
        return 0        
    else:
        return int(re.findall(r'[1-9]', x[0])[0])


#start_times are obtained and captured for later use
start_times = school_info_df[['School_Hours']].apply(get_start_time, axis=1)

#the frequency of 7, 8, and 9 start times is calculated for the required start time distribution on the report out
start_7_count = start_times.isin([7]).sum()
start_8_count = start_times.isin([8]).sum()
start_9_count = start_times.isin([9]).sum()

#schools outside of the loop are calculated by counting how many schools have zip codes inside the loop and then 
#subtracting that value from the total_number of schools present in the data.
schools_outside_loop= school_info_df['Zip'].count() - school_info_df['Zip'].isin([60601,60602,60603,60604,60605,60606,60607,60616]).sum()


#changes null values in College_Enrollment_Rate_School column into the mean of the column
school_info_df['College_Enrollment_Rate_School'] = school_info_df['College_Enrollment_Rate_School'].fillna(school_info_df['College_Enrollment_Rate_School'].mean())

#obtains the mean and standard deviation of the 'College_Enrollement_Rate_School' for high schools (given that it is a high school) for later report out.
col_enrol_rate_hs_mean = school_info_df['College_Enrollment_Rate_School'][school_info_df['Is_High_School']  == True].mean()
col_enrol_rate_hs_std = school_info_df['College_Enrollment_Rate_School'][school_info_df['Is_High_School']  == True].std()


#calculates the student_count mean and standard deviation for schools that are not high schools.
stud_count_non_hs_mean = school_info_df['Student_Count_Total'][school_info_df['Is_High_School']  == False].mean()
stud_count_non_hs_std = school_info_df['Student_Count_Total'][school_info_df['Is_High_School']  == False].std()

#setting to allow all columns for the dataframe to be printed to console.
pd.set_option("display.max_rows", None, "display.max_columns", None)

#creates the dataframe that will be printed to console. This is composed of 'School_ID', 'Short_Name', 'Is_High_School', 'Zip', 
#'Student_Count_Total', 'College_Enrollment_Rate_School', 'Lowest_Grade', 'Highest_Grade', 'School_Start_Hour'.
school_to_display = school_info_df[['School_ID', 'Short_Name', 'Is_High_School', 'Zip', 'Student_Count_Total', 'College_Enrollment_Rate_School']]

#assigned the Lowest_Grade, Highest_Grade, and School_Start_Hour from their respective data into the data frame to print to console. 
school_to_display = school_to_display.assign(Lowest_Grade = lowest_grades, Highest_Grade = highest_grades, School_Start_Hour=start_times)

#prints the final report out (first 10 columns of the dataframe)
print(school_to_display.head(10))
print()

#prints the College_Enrollment_Rate_average for schools that are high schools
print('College Enrollment Rate for High Schools = %.2f (sd=%.2f)' % (col_enrol_rate_hs_mean,col_enrol_rate_hs_std))
print()

#prints the mean total number of students with its std for schools that are not high schools
print('Total Student Count for non-High Schools: %.2f (sd=%.2f)' % (stud_count_non_hs_mean, stud_count_non_hs_std))
print()

#prints off the starting hour distribution, 8AM, 7AM, 9AM
print('Distribution of Starting Hours:\n 8am:  %s\n 7am:  %s\n 9am:  %s' %(start_8_count,start_7_count,start_9_count))
print()

#prints off the number of schools that are outside of the loop zipcodes.
print('Number of schools outside Loop: %s' % (schools_outside_loop))
