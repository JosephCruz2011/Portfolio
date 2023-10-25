"""
Created on Wed Feb 24 17:05:46 2021

CPSC-51100-Spring 2021
Joe Cruz
Programming Assignment #7 Week 7 ("tables.py")
03Mar2021

"""

print('CPSC-51100', 'Spring 2021')
print('Joe Cruz')
print('PROGRAMMING ASSIGNMENT #7\n')     
     
import pandas as pd

#pd options changed to display full contents of the columns and the tables displayed.
pd.set_option('display.max_columns', 500)
pd.set_option('display.width', 1000)
pd.set_option('display.max_colwidth', -1)

# Loads the Pums Dataset
pums_data = pd.read_csv('ss13hil.csv', na_values='')

#########################################Table 1 creation: Statistics of HINCP -Household income (past 12 months) grouped by HHT-Household/family type###############################

#creates mapping dict for the hht column in the pums dataset with their representative values and text names
hht_household_family_type={
 1: 'Married couple household', 
 2: 'Other family household:Male householder, no wife present',
 3: 'Other family household:Female householder, no husband present',
 4: 'Nonfamily household:Male householder:Living alone',
 5: 'Nonfamily household:Male householder:Not living alone',
 6: 'Nonfamily household:Female householder:Living alone',
 7: 'Nonfamily household:Female householder:Not living alone'}

#maps the HHT data to the mapping dictionary
pums_data['HHT - Household/family type'] = pd.DataFrame(pums_data['HHT'].map(hht_household_family_type))

#performs groupby to group the HINCP data by the HHT type
grouped_HINCP = pums_data.groupby('HHT - Household/family type')['HINCP']

#aggregates the groupby object to display the mean, std, count, min, and max
grouped_HINCP.agg(['mean', 'std', 'count', 'min', 'max'])

#creates a dataframe of the groupby object
hincp_stat_dataframe =pd.DataFrame(grouped_HINCP.agg(['mean', 'std', 'count', 'min', 'max']))

#print statement for the name of the Descriptive Statitics of HINCP (table 1)
print('*** Table 1 - Descriptive Statistics of HINCP, grouped by HHT ***')

#prints the Table that is sorted in descending fashion based on the mean. 
print(hincp_stat_dataframe.sort_values('mean', ascending=False))

#format print statement
print()


###########################################Table 2 creation: HHL- Household language vs ACCESS- Access to the internet (Frequency Table)################################

#creates mapping dict for the hhl column in the pums dataset with their representative values and text names
hhl_languages_mapping={
 1: 'English Only', 
 2: 'Spanish',
 3: 'Other Indo-European languages',
 4: 'Asian and Pacific Island languages',
 5: 'Other language'}

#creates mapping dict for the access column in the pums dataset with their representative values and text names
access_mapping={
 1: 'Yes w/ Subsrc.',
 2: 'Yes wo/ Subsrc.',
 3: 'No',}

#maps the Access and HHL columns using their respective mapping dictionaries
pums_data['ACCESS'] = pd.DataFrame(pums_data['ACCESS'].map(access_mapping))
pums_data['HHL - Household language'] = pd.DataFrame(pums_data['HHL'].map(hhl_languages_mapping))

#performs crosstabulation of the HHL and the ACCESS mapped dataframes with values of the WGTP sums for each language and access. 
hhl_vs_access = pd.crosstab(index = pums_data['HHL - Household language'], columns = pums_data.ACCESS, values=pums_data.WGTP, aggfunc ='sum', margins=True, normalize='all')

#creates a dataframe object of the crosstabulated data and formats the data to bt XX.XX%
hhl_vs_access_dataframe = pd.DataFrame(hhl_vs_access).applymap(lambda x: "{0:.2f}%".format(x*100))

#changes the order of the columns in the newly created dataframe object
hhl_vs_access_dataframe= hhl_vs_access_dataframe[['Yes w/ Subsrc.', 'Yes wo/ Subsrc.', 'No', 'All']]

#reindexes the dataframe object
hhl_vs_access_dataframe= hhl_vs_access_dataframe.reindex(['English Only', 'Spanish','Other Indo-European languages','Asian and Pacific Island languages','Other language', 'All'])

#print statement for the name of HHL vs ACCESS Frequency table (table 2)
print('*** Table 2 - HHL vs ACCESS - Frequency Table ***')

#format print statement for the sum/WGTP output
print('                                     sum')
print('                                    WGTP')

#prints the HHL vs ACCESS Frequency table
print(hhl_vs_access_dataframe)

#format print statement
print()


#########################################Table 3 creation: Quantile Analysis of HINCP - Household income (past 12 months)##############################################

#generates dataframe holding the HINCP and WGTP data (indexes the same number now instead of two different sizes)
housing_counts_df = pd.DataFrame(pums_data[['HINCP', 'WGTP']]).dropna()

#drops null values
housing_counts_df.dropna()

#performs quantile cut based of the HINCP column splitting data into low, medium or high
group_quant = pd.qcut(housing_counts_df.HINCP, 3, labels=['low','medium', 'high']) 

#groups the HINCP data together and creates groupby object
grouped_HINCP = housing_counts_df.HINCP.groupby(group_quant)

#saves an aggregation of the grouped_HINCP groupby object to a data frame with min, max, and mean as the columns.
quan_analysis_HINCP =pd.DataFrame(grouped_HINCP.agg(['min', 'max', 'mean']))

#groups the WGTP data using the qcut for HINCP group (this will effectively map the WGTP data to the respective label [high, low, medium] )
grouped_WGTP = housing_counts_df['WGTP'].groupby(group_quant)

#The house_count is created through the sum of these groups
house_count_col = grouped_WGTP.sum()

#The household count column is added to the table. 
quan_analysis_HINCP['household_count'] = house_count_col

#print statement for name of the Quantile Analysis of HINCP table (table 3)
print('*** Table 3 - Quantile Analysis of HINCP - Household income (past 12 months) ***')

#print quantile analysis of HINCP table
print(quan_analysis_HINCP)