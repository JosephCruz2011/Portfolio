//CPSC 50300 Assignment Week 4				
//Joe Cruz 
//Question 3
//
//This test program builds an ArrayList and populates it with 10 elements (numbers 100-109).
//The user is then asked to input the desired element of the list that they want to view. The
//input for the user will be between 1 and 10, where the element 1 represents index 0 and 
//element 10 represents index 9. If the element desired is within 1-10, the corresponding element
//will be returned. In the event that the element desired is larger than 10 or less than 0, then the program
//will return the IndexOutofBounds error. 
 

import java.util.Scanner;

public class Question_3 {
	//Creates a string array to hold the elements of the ArrayList
	ArrayList<String> Names = new ArrayList<String>();
	Integer search_element; 
	
	
	//This method adds the values 100-109 to the ArrayList. There are a total of 10 elements created in this ArrayList.
	void add_values() {
		for (int i=0; i<10; i++) 
			Names.add(i, String.valueOf(i+100));
	}
	
	//This method asks the user to define the desired element to view in the ArrayList. 
	void user_search_input() {
		System.out.println("\nPlease enter the element of the list desired (i.e. 1-10):\nElement : ");
		Scanner scan1 = new Scanner(System.in);
		search_element= scan1.nextInt()-1;
	}
	
	//This method obtains the desired element from the ArrayList and returns it for the user.
	//In the case that the desired element is out of bounds of the list (higher than 10), an error occurs. 
	void search () throws IndexOutOfBoundsException {
		user_search_input();
		System.out.print("Element " + (search_element + 1) + " : " + Names.get(search_element));}

	//This method runs the program. 
	void run_program () {
		System.out.println("Hello. \n\nThis test program creates a pre-defined ArrayList containing the integers 100-109.\nThe user is then instructed to provide the element they desire to view (1-10). The \ncorresponding element will be returned to the user, but, in the event that the \ndesired element is out of bounds (<0 or >10), an error will be thrown.");
		add_values(); 
		search();
	}

	public static void main(String[] args) {
		Question_3 sim = new Question_3();
		sim.run_program();

	}
}
