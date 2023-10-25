//CPSC 50300 Assignment Week 4				
//Joe Cruz 	
//Question 1
// 
//This test program is meant to create a list of 6 user-defined names using an ArrayList.
//After inserting these names to the list, the user can search for a user-defined name
//in the list. If the desired name is in the list, the name will be returned as well 
//as an indication that it was found. Further, if the name was found multiple times, the number
//of times it was found is also returned. If the name is not in the list, the program will
//return that there is no such name in the list.

import java.util.Iterator;
import java.util.Scanner;

public class Question_1 {
	//ArrayList created to hold the names that will be recorded
	ArrayList<String> Names = new ArrayList<String>();
	String search_name; 
	
	//This method is used to obtain the names from the user to put into the ArrayList.
	public String user_input() {
		System.out.println("Name: ");
		Scanner scan1 = new Scanner(System.in);
		String name = scan1.next(); 
		return name;
	}
	
	//This method is used to add the names obtained from the user into the ArrayList
	void add_value() {
		System.out.println("\nPlease type in a total of 6 names: ");
		for (int i=0; i<6; i++) 
			Names.add(i, user_input());
	}
	
	//This method is used to obtained the user-defined name that needs to be searched for in the ArrayList
	void user_search_input() {
		System.out.println("\nPlease enter the name that you are searching for:\nName to search: ");
		Scanner scan2 = new Scanner(System.in);
		search_name= scan2.next();
	}
	
	//This method obtains the search-for name and checks through the ArrayList using an iterator. 
	//If the name is found within the list, the user will be notified. If the name is found multiple times
	//within the ArrayList, the user will also be notified how many times the name was found. If it is not found in the ArrayList, the user will also be notified. 
	void search () {
		user_search_input();
		Iterator<String> iter= Names.iterator();
		int check=0;
		while(iter.hasNext()) {
			String var = iter.next();
		
			//found first occurrence of search name
			if(var.equalsIgnoreCase(search_name) && check==0) {
				System.out.print("Found " + var);
				check+= 1;}
			
			//found another occurrence of search name
			else if ((var.equalsIgnoreCase(search_name) && check!=0)) {
				check+=1;}
		}
		//prints how many times the search name was found if found multiple times
		if (check>1) {
			System.out.println("\n" + search_name + " was found " + check + " times" ); 
		}
		//notifies the user that the search name was not found in the ArrayList.
		if (check == 0) {
			System.out.print("\nThere is no " + search_name + " in the list.");}
		}
	
	//Method to run the program.
	void run_program () {
		System.out.println("Hello.\n\nThis test program is designed to take in 6 user-defined names and put them into an ArrayList. The user will then be instructed to provide a name to search for\nin the ArrayList. The user will be notified of whether the desired name is in the ArrayList or not. The user will also be notified the number of times the \ndesired name appears in the ArrayList if there are multiple instances.");
		add_value(); 
		search();
	}

	public static void main(String[] args) {
		Question_1 sim = new Question_1();
		sim.run_program();

	}

}
