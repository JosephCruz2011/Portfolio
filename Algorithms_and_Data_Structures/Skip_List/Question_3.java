//CPSC 50300 Assignment Week 7			
//Joe Cruz 	
//Question 3
//  
//This driver program is meant to create a skiplist with keys 1, 11, 15, 33, 45, 46, 84, 99 and their respective values.
//The skiplist created is then shown to the user and the user can input a desired search key. The program 
//will then look for the key in the skiplist and return the key if it is found. If it is not found the program
//return that it is not found. 

import java.util.Scanner;

public class Question_3  {
	//creates the skiplist
	SkipList map = new SkipList();
	
	//this method adds and key and its associated value into the skiplist.
	public  void add_values() {
		map.put("15", 0);
		map.put("33", 1);
		map.put("84",2);
		map.put("45", 3);
		map.put("1",4);
		map.put("46", 5);
		map.put("11", 6);
		map.put("99",7);
	}
	
	//this method takes in user input for the desired key to search for in the skiplist.
	public String input() {
		System.out.println("\nPlease input the desired key to search for:");
		System.out.println("Search input: ");
		Scanner scan1 = new Scanner(System.in);
		String input = scan1.next();
		return input;
	}
	
	//this method is used to find the desired key within the skiplist.
	 public void find_value() {
		map.printHorizontal();
		System.out.println("Map size: " + map.size());
		System.out.println("Map height: " + map.h);
		System.out.println("Num entries in map: "+ map.n);
		String input_key = input();
		
		if (map.findEntry(input_key).getKey().equalsIgnoreCase(input_key)) {
			System.out.print("Value found in Skiplist: ");
			System.out.println(map.findEntry(input_key).getKey());
		}
		else {
			System.out.println("Value not found in Skiplist");
		}

	}
	 //this method runs the program.
	 public void run_program() {
		 add_values();
		 find_value();
	 }

	public static void main(String[] args) {
		System.out.println("Hello.\n\nThis driver program is meant to create a skiplist with keys 1, 11, 15, 33, 45, 46, 84, 99 and their respective \nvalues.The skiplist created is then shown to the user and the user can input a desired search key. The program \nwill then look for the key in the skiplist and return the key if it is found. If it is not found the program\nreturn that it is not found.\n\n ");
		Question_3 sim = new Question_3();
		sim.run_program();

	}

}
