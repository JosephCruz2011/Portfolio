//CPSC 50300 Assignment Week 4				
//Joe Cruz 	
//Question 4
//
//This test program creates an ArrayList with an initial capacity of 1000. The user
//is then asked how many elements they desire in the ArrayList. The user is then asked to
//define the elements of the ArrayList. The ArrayList is then resized so the capacity of the arrayList
//matches the quantity of elements actually in the ArrayList(size). For instance, say an ArrayList is populated
//with 50 elements. After resizing the ArrayList, the capacity will change from 1000 to 50. 
//

import java.util.Scanner; 

public class Question_4 {
	//ArrayList is created with a capacity of 1000
	ArrayList<String> Names = new ArrayList<String>(1000);
	Integer num_elements;
	
	//This method obtains user_input.
	public String user_input() {
		Scanner scan1 = new Scanner(System.in);
		String name = scan1.next(); 
		return name;
	}
	
	//This method asks the user for the quantity of elements desired in the ArrayList 
	//and then has the user populate the ArrayList with the desired elements.
	void gen_elements() {
		System.out.println("\nHow many elements would you like the ArrayList to contain?\nNumber of Elements:  ");
		num_elements = Integer.valueOf(user_input());
		for (int i=0; i<num_elements; i++) {
			System.out.println("Element contents: ");
			Names.add(i, user_input());}
	}
	
	//This method adjusts the capacity of the ArrayList from 1000 to the size of the ArrayList.
	//For instance, if there are 20 elements in the list (ArrayList size=20), then the ArrayList
	//capacity will be resized to 20. 
	void trimToExactSize() {
		System.out.println("ArrayList being resized\n");
		
		//ArrayList is resized based on the size of the ArrayList.
		Names.resize(Names.size()); 
		
		//New capacity and size is shown to the user
		System.out.println("New capacity of ArrayList: " + Names.capacity_check());
		System.out.println("Current size of ArrayList: " + Names.size() +"\n");
		
	}
	//This method runs the full program
	void run_program () {
		//Initial capacity of the ArrayList is shown to the user
		System.out.println("Hello.\n\nThis test program creates an ArrayList of capacity 1000 and allows the user to \ndetermine the size and element contents of the ArrayList. The ArrayList is\nthen resized so that the capacity of the ArrayList is changed to the size of \nthe ArrayList. For instance, if the ArrayList contains 15 elements, the \ncapacity will be resized to 15 from 1000.");
		System.out.println("\nInital capacity of ArrayList: " + Names.capacity_check());
		gen_elements(); 
		//Capacity and size of the ArrayList is shown after generating the elements.
		System.out.println("Current capacity of ArrayList: " + Names.capacity_check());
		System.out.println("Current size of ArrayList: " + Names.size() +"\n");
		//Array is trimmed to size
		trimToExactSize();
	}
	
	public static void main(String[] args) {
		Question_4 sim = new Question_4();
		sim.run_program();

	}

}
