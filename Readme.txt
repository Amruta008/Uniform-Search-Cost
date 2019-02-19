Name: Amruta Desai
Student ID: 1001653925

Programming language used: Java
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Program Structure :

The zip file contains four Java classes namely, Node_Formation, Compare_Node, Navigate and Find_route.

The map is created as a graph. Every node is the city and it's connecting cities are edges and weight for each edge.

Find_Route.java reads the command line arguments. It takes in three arguments namely, input filename, source city and destination city (heauristic_filename optional). 
 > The Node_Formation method handles the graph formation from the given input text .
 > Compare_Node function sorts the given data in the fringe. 
 > The arguments for the cities is not case sensitive.
 > In Navigate class the UninformerdSearch(string,source, destination) method implements the uniform cost search  algorithm to find the shortest path from the source node and destination node.
 > In Navigate class the InformedSearch(string,source, destination, string) method implements the uniform cost search  algorithm to find the shortest path from the source node and destination node using the given heauristics.
 > Generates path
 > Prints out distance and route, if exists.

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
How to run :

The program takes three arguments for uninformed search and four arguments for informed search.

Example,
	Find_Route input_filename source_city destination_city
To compile the program,
	javac Compare_Node.java
	javac Node_Formation.java
	javac Find_Route.java
	javac Navigate.java

To run the program,
	java Find_Route input1.txt Bremen Kassel  

  The input1.txt and h_kassel.txt are already present in the directory(axd3925@omega amruta) as a sample input to work with.
  
  This program will then compute the shortest route between the two cities, calculate the cost and display the distance and route with the cities that fall in the route.

Example, for:  java Find_Route input1.txt Bremen Kassel

Output will be,
Nodes Expanded: 12
Distance: 297.0
Route :
bremen to hannover 132.0 km
hannover to kassel 165.0 km

Example for informed search : java Find_Route input1.txt Bremen Kassel h_kassel.txt
Nodes Expanded: 3
Distance : 297.0
Route :
bremen to hannover 132.0 km
hannover to kassel 165.0 km



If there is no route between the provided two cities the distance will be displayed as infinity and route as none.

Example, for: java Find_Route input1.txt London Kassel

Output will be,
Nodes Expanded: 7
Distance: Infinity
Route :
None