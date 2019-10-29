Student 1 Name: Riwaj Shrestha
Student 1 Id: 101722868

Student 2 Name: Binay Dhawa
Student 2 Id: 101187399

Unit Code: COS80007

//Running Instructions
Unzip the folder into two files, a readme file and a final 101722868/101187399-Riwaj/Binay-PG/UG-19S2-AJ-Assign2 zip file
Use Winrar to unzip the file as follows:
	1. Right click on the zip file:101722868/101187399-Riwaj/Binay-PG/UG-19S2-AJ-Assign2
	2. Click open, Select the destination to extract the files
	3. Click ok to extract.

//Running program
	1. Firstly choose the imdb.xml file from the folder
	2. Then press Parse XML button. This will show all the movie details that is in the 
	   imdb.xml file in the text area below.
	3. Then search for any movie that you want and press Find.
	4. After that the searched movie will be displayed in the text area with all the details.
	5. If you press top 3 correlated keywords and press Bar chart button, then it shows all the top 3 keyword count from the searched movie and shows in the barchart.
	6. Likewise, the Top 5, Top 8 and Top 10 also shows the similar top keywords count with the bar chart.
	7. Similarly, if you press the piechart, then it shows the data in the pie chart.	
 	
//External Inclusion
A imdb.xml file that will be uploaded and parse and shown in the text area.

//List of known bugs
There are no any known bugs for this project. 

//Estimated marks to be obtained
Expected Marks: 300 out of 300

I have also used codes from source like stackoverflow and tutorialspoint. 
The code below was used in our project.
To convert array from the list
Map<String, Integer> sorted = str.entrySet()
				  .stream()
				  .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
				  .collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2,
				                LinkedHashMap::new));
