//CPSC 50300 Assignment Week 4				
//Joe Cruz 
//Question 2
//
//This test program is similar to that of Question 2, where the user is asked to define 10 integers that will be put into the ArrayList.
//From there, the user will be asked to search for an integer and the program will search through the ArrayList for that integer.
//The user will be notified if the integer exists in the list and if so how many times. Otherwise, the user will be notified
//that the integer searched for does not exist in the list. 
 

import java.util.Iterator;
import java.util.Scanner;

public class Question_2 {
	//Creates ArrayList to hold the integers to be defined by the user. 
	ArrayList<Integer> Numbers = new ArrayList<Integer>();
	Integer search_number; 
	
	//This method is meant to obtain the integers that will be put into the ArrayList from the user. 
	public Integer user_input() {
		System.out.println("Integer: ");
		Scanner scan1 = new Scanner(System.in);
		Integer number = scan1.nextInt(); 
		return number;
	}
	
	//This method adds the integers defined by the user to the ArrayList
	void add_value() {
		System.out.println("\nPlease type in a total of 10 integers: ");
		for (int i=0; i<10; i++) 
			Numbers.add(i, user_input());
	}
	
	//This method is used to obtained the user-defined integer that needs to be searched for in the ArrayList
	void user_search_input() {
		System.out.println("\nPlease enter the integer that you are searching for:\nName to search: ");
		Scanner scan2 = new Scanner(System.in);
		search_number= scan2.nextInt();
	}

	//This method obtains the search for integer and checks through the ArrayList using an iterator. 
	//If the integer is found within the list, the user is notified and if it is found multiple times within the ArrayList, 
	//the user will be notified how many times the integer was found. If it is not found in the ArrayList, the user will also be notified. 
	
	void search () {
		user_search_input();
		Iterator<Integer> iter= Numbers.iterator();
		int check=0;
		while(iter.hasNext()) {
			Integer var = iter.next();
			
			//found first occurrence of integer
			if(var == search_number && check==0) {
				System.out.print("Found " + var);
				check+= 1;}
			
			//found another occurrence of integer
			else if(var == search_number && check!=0) {
				check+= 1;}
		}
		//Prints number of times the integer was found if it was found multiple times.
		if (check>1) {
			System.out.println("\n" + search_number + " was found " + check + " times" ); 
		}
		//notifies user that the integer was not found in the ArrayList
		if (check == 0) {
			System.out.print("There is no such integer in the list.");
		}
		
	}
	
	//This method is to run the full program.
	void run_program () {
		System.out.println("Hello.\n\nThis test program is designed to take in 10 user-defined integers and put them into an ArrayList. The user will then be instructed to provide an integer to search for\nin the ArrayList. The user will be notified of whether the desired integer is in the ArrayList or not. The user will also be notified the number of times the \ndesired integer appears in the ArrayList if there are multiple instances.");
		add_value(); 
		search();
	}


	public static void main(String[] args) {
		Question_2 sim = new Question_2();
		sim.run_program();

	}

}
