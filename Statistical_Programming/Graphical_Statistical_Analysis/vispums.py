"""
Created on Wed Feb 24 17:05:46 2021

CPSC-51100-Spring 2021
Joe Cruz, Megan Curran, Azjargal Ganbayar (Group 4)
Programming Assignment #6 Week 6 ("vispums.py")
24Jan2021

"""

print('CPSC-51100', 'Spring 2021')
print('Joe Cruz, Megan Curran, Azjargal Ganbayar (Group 4)')
print('PROGRAMMING ASSIGNMENT #6')     
     
import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
from matplotlib import cm

# Loads the Pums Dataset
pums_data = pd.read_csv('ss13hil.csv', na_values='')

# Creates the figure object that will be used for the subplot space and creates figure title 'Sample Output'
fig = plt.figure(figsize=(18,18))
fig.suptitle('Sample Output', fontsize=20, fontweight='bold')

### Creation of subplot 1 (top left pie chart)
ax1 = fig.add_subplot(2, 2, 1)

# Creates a dictionary mapping the numeric values to their respective languages. 
hhl_languages={
 1: 'English Only', 
 2: 'Spanish',
 3: 'Other Indo-European',
 4: 'Asian and Pacific Island languages',
 5: 'Other'}

# Creates a new data frames that takes the HHL Column and maps it to the dictionary
pums_data['Languages'] = pd.DataFrame(pums_data['HHL'].map(hhl_languages))
total_hhl_lang= pd.DataFrame(pums_data.Languages.value_counts().reset_index().values,columns = ['Language', 'Number of households'])

# Pulls the data to be used in the pie chart
hhl_data = total_hhl_lang['Number of households']

# Creates the labels to be used for the pie chart
hhl_labels = 'English Only', 'Spanish', 'Other Indo-European', 'Asian and Pacific Island languages','Other'

# Creates the pie chart
ax1.pie(hhl_data, startangle = 242)

# Creates the title of the pie chart
ax1.set_title('Household Languages')

# Creates the label for the y axis
ax1.set_ylabel('HHL')

# Creates the legend and its location 
ax1.legend(hhl_labels,loc ='upper left')

# loads the Household income data from pums dataframe
hincp = pums_data['HINCP']

# Establishes logspace bins for the histogram
hincp_bins = np.logspace(1,7, num=100)

### Creates subplot 2 (top right histogram with kde plot)
ax2 = fig.add_subplot(2, 2, 2)
ax2.set_title('Distribution of Household Income')
ax2.set_ylabel('Density')
ax2.set_xlabel('Household Income($) - Log Scaled')
ax2.set_xscale('log')

# Plots histogram in subplot 2
ax2.hist(hincp, bins=hincp_bins , facecolor = 'g', alpha=0.4, histtype='bar', density = True,  range= (0,len(pums_data['HINCP'])))

# Plots KDE plot that is superimposed onto the ax2 subplot.
hincp_plot=hincp.plot(kind='kde', color= 'k', ls='dashed')
hincp_plot.grid()


### Creates subplot 3 (bottom left bar graph) 
ax3 = fig.add_subplot(2, 2, 3)

# Function to draw the bar graph
def draw_bar(ax):
    grouped = pums_data.groupby('VEH')['WGTP'].sum()/1000 #use the WGTP value to count how many households are represented by each household record and divide the sum by 1000
    ax.bar(grouped.index,grouped.values,width=0.9,bottom=None,color='r',align='center')
    ax.set_title('Vehicles Available in Households')
    ax.set_xlabel('# of Vehicles')
    ax.set_ylabel('Thousands of Households')
    ax.set_xticks(grouped.index)

# Draws the bar graph
draw_bar(ax3)
ax3.tick_params(axis='both', which='major', labelsize=12)
ax3.tick_params(axis='both', which='minor', labelsize=12)


### Creates subplot 4 (bottom right scatter plot)
ax4 = fig.add_subplot(2, 2, 4)

# Get the taxp dict made
def get_taxp_mapp_dict():
    taxp_dict={}
    taxp_dict[1] =np.NAN
    taxp_dict[2] = 1
    counter = 50
    for key in range (3,23):
        taxp_dict[key]=counter
        counter+=50
    counter = 1100   
    for key in range (23,63):
        taxp_dict[key]=counter
        counter+=100    
    taxp_dict[63] = 5500
    taxp_dict[64] = 6000
    counter = 6000
    for key in range (65,69):
        counter+=1000
        taxp_dict[key]=counter
    return taxp_dict

# Returns the taxp_dict
taxp_dict = get_taxp_mapp_dict()  

# Maps the pums_data to the taxp_dict values
taxp= pums_data['TAXP']
taxp = pd.DataFrame(pums_data['TAXP'].map(taxp_dict))

# Pulls valp data
valp = pums_data['VALP']

# Sets axis limits
ax4.set_ylim([0,11000])
ax4.set_xlim([0,1200000])

# Plots scatter plot taxp against valp using the WGTP as the size factor, MRGP as the color factor (using color map 'seismic') and marker type as 'o'
scatter= ax4.scatter(valp, taxp, c=pums_data['MRGP'], cmap=cm.get_cmap('seismic'), alpha = 0.2, s= pums_data['WGTP'], marker = 'o')
ax4.set_title('Property Taxes vs Property Values')
ax4.set_xlabel('Property Values($)')
ax4.set_ylabel('Taxes($)')

# Creates and displays the color bar for the scatter plot.
color_bar=plt.colorbar(scatter, ax=ax4)
color_bar.set_label('First Mortgage Payment (Monthly $)')

# Final formatting of the subplots
fig.subplots_adjust(left = 0.04,bottom= .14, right = .96, top = .93, wspace = .2, hspace = .2 )

# Saves the figure of subplots as a png file.
fig.savefig('pums.png')
