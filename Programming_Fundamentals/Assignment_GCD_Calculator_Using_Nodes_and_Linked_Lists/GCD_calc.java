///Week 7 Assignment 						Author: Joe Cruz
///Part_2	Extended from GCD class.
///
///This program is meant to calculate the greatest common divisor between two positive integers.
///
///This portion of the program is meant to perform the actual calculations for the GCD as well as put the input values into a linked list
///using the nodes created from the Queue_Nodes class. The values input are conveyed through the linked list and analyzed for length to ensure that
///no values input are larger than 10 characters. Then, the values are compared to determine which integer is larger. From there, the 
///the GCD is calculated via a recursive method then returned to the console.  

import java.text.DecimalFormat;
public class GCD_calc extends GCD{
		
	//initiating integer variables and double variables
	private double larger, smaller;
	private int Remainder, Greatest_Common_Divisor;
	
	//initiating linked list
	Queue_Nodes sList=new Queue_Nodes();
	
	//initiating string array to hold elements of the nodes from the linked list
	private String[] Elements_of_linked_list;
	
	//Compares the input integers and sets the larger of the two to large and the smaller to small (if both equal it doesnt matter)
	private void set_large_small_integers() {
		if (integer1 >= integer2) {
			larger = integer1;
			smaller = integer2;}
		else  {
			larger = integer2;
			smaller = integer1;}
	}
	
	//Calculates the remainder of the larger divided by the smaller
	private void Remainder() {
		double Remaind = larger % smaller;
		Remainder = (int)Remaind;
	}
	
	//Recursive method that calculates the GCD for the input values. 
	private int GCD_rec() {
		if (Remainder == 0) {
			Greatest_Common_Divisor = (int)smaller;
			return Remainder;}
		else {
			larger=smaller;
			smaller=Remainder;			
			Remainder();
			return GCD_rec();
		}
	}
	
	//Performs the GCD calculation and handles the exceptions for character length and GCD being 1.Also returns the GCD to the console.
	private void GCD_calculation() throws GDC_Exception {
		set_large_small_integers();
		Remainder();
		GCD_rec();
		GDC_Exception alert1= new GDC_Exception("GCD is 1");
		if (Greatest_Common_Divisor == 1) {
			throw alert1;
		}
		DecimalFormat df = new DecimalFormat("0");
		System.out.println("\nThe GCD of " + df.format(integer1) + " and " + df.format(integer2) + " is " + Greatest_Common_Divisor + ".");
	}
	
	//Loads the integer values into the linked list
	private void Enqueue() {
		sList.enqueue(Double.toString(integer1));
		sList.enqueue(Double.toString(integer2)); 
		}

	//analyzes the information put into the nodes to check if the length of characters is larger than 10 or not. 
	//Once check is performed that node is dequeued (removed from the linked list) and the next node is lined up for analysis.
	private void analyze_node() throws GDC_Exception{
		Elements_of_linked_list = sList.get_Elements_of_nodes();
		
		GDC_Exception alert2= new GDC_Exception("Cannot enter more than 10 characters per input");
		
		for(int i=0; i<sList.size(); i++) {
			String check= Elements_of_linked_list [i];		
			
			//this check is to make sure the input is less than 10 characters. It is set at 13 to account for the scientific notation used for the doubles (the ".", "EX" are 3 characters that are accounted for with the value of 13 instead of 10).
			//this check allows the user to input up to 10 characters in the input line for each value. 
			if (check.length()>13) {
				throw alert2;
			}
			sList.dequeue();
			}
		}
	
	//Used for the instantiation of the GCD_calc class in the main in the GCD file. This houses everything that is required to run this program effectively.
	GCD_calc () throws GDC_Exception {
		GCD();
		Enqueue();
		analyze_node();
		GCD_calculation();
	}
	}
	
