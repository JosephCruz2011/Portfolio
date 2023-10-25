# -*- coding: utf-8 -*-
"""
Created on Sun Jan 24 20:07:55 2021

CPSC-51100-Spring 2021
Joe Cruz, Megan Curran, Azjargal Ganbayar (Group 4)
Programming Assignment #2 Week 2 ("kMeans.py")
30Jan2021
"""

print('CPSC-51100', 'Spring 2021')
print('Joe Cruz, Megan Curran, Azjargal Ganbayar (Group 4)')
print('PROGRAMMING ASSIGNMENT #2')

#input_file that is in the same file folder as the program      
input_file = 'prog2-input-data.txt'

#Obtain the data from the input file
data = [float(x.rstrip()) for x in open(input_file, 'r')]

# Ask the user to input the number of clusters
k = int(input("Enter the number of clusters:"))

# Create dictionary to store centroids
centroids = dict(zip(range(k), data[0:k]))

# Create dictionary to store clusters
clusters = dict(zip(range(k), [[] for i in range(k)]))

# Create variable to store the point assignments
point_assignments = {p:0 for p in data}

#create dictionary for old_point assignments
old_point_assignment = {}

#Updates the centroids for the newly assigned clusters
def update_location (data, clusters, centroids):
       for z,value in enumerate(clusters):
           avg= sum(clusters.get(z))/len(clusters.get(z))
           centroids[z]=avg
       return
   
# Function which goes through each point and index of point and
# finds the closest centroid     
def assign_to_clusters (data, clusters, centroids, point_assignments): 
 
    #Temporary list for holding the values that go into each cluster
    value_hold=[]
    
    #Iterates through the data points 1 at a time and compares them to each centroid. These distances between the 
    #data points and the centroids are recorded in the temporary list value_hold, where, after the cycle of 
    #comparisons is finished, the index of the value with the minimum distance is taken (the centroid that
    #the data point is closest to). That index is used to obtain the proper list in the clusters dict, where we 
    #will append the data point. In other words, we used the index of the point with the least distance to
    #open up the cluster that the data point should belong to and we put that data point into the proper cluster.
    for i in range(len(data)):
        value_hold=[]
        for j,value in enumerate(centroids):    
            diff = abs(data[i]-centroids.get(j))
            value_hold.append(diff)
        closest_index= value_hold.index(min(value_hold))
        clusters.get(closest_index).append(data[i])
        point_assignments[data[i]]= closest_index
    return

#establishes iteration variable as 1.
iteration=1

#performs a loop until iteration become 0. This section utilizes a comparison between
#the old_point_assignment and the point_assignments. When the old_point assignment is the same
#as the point_assignment(meaning no change has occurred in these assignments and convergence has
#been achieved). Only after reaching convergence does the loop break and continue. 
while iteration !=0:
    
    # Save current point assignment into an old point assignment
    # from the previous iteration
    old_point_assignment = point_assignments.copy()
    assign_to_clusters (data, clusters, centroids, point_assignments)
    update_location (data, clusters, centroids)
    
    
    print("\nIteration " + str(iteration))

    #Displays the contents of each of the clusters 
    for x in (clusters):
        print(x, clusters.get(x))
    
    #compares the old_point_assignment to the current point_assignments and if there is no change
    #the loop is terminated and the program continues.Otherwise, the loop continues until
    #convergence is met.        
    if old_point_assignment == point_assignments:
        iteration=0
        break
    else:
        iteration += 1
    
    # Reinitialize the clusters variable to empty lists
    clusters = dict(zip(range(k), [[] for i in range(k)]))  

#format print command (only for additional space between output)
print()

#creates the output file ("prog2-output-data.txt") and allows for writing to it.
output_file=open("prog2-output-data.txt","w")

#creates a format string for the console and the output file 
formatted_string_console="Point %s in cluster %s"
formatted_string_output_file="Point %s in cluster %s\n"

#iterates through the point assignments and prints the point and their respective cluster.
#also writes this to the output fil
for z in (point_assignments):
        print(formatted_string_console % (z , point_assignments.get(z)))
        output_file.write(formatted_string_output_file % (z , point_assignments.get(z)))
        
#closes the output file
output_file.close()        

