///Week 7 Assignment 						Author: Joe Cruz
///	Part_1
///
///This program is meant to calculate the greatest common divisor between two positive integers. 
///
///This portion of the code houses the GCD class which is responsible for obtaining the input from the user for the two positive integers. 
import java.util.Scanner;

public class GCD {
	
	public double integer1;
	public double integer2;
		
	//Obtains input from user for the two integers
		private double getIntegers() {
			Scanner scan1 = new Scanner(System.in);
			double integer = scan1.nextDouble();
			return integer;
			}
		
	//Sets the input integers to the integer1 and integer2 variables
		private void setIntegers() {
			System.out.print("Integer 1: ");
			integer1 = getIntegers();
			System.out.print("Integer 2: ");
			integer2 = getIntegers();
		}
		
		private void check_for_neg_ints() throws GDC_Exception {
			
			GDC_Exception alert4= new GDC_Exception("Input values must be positive integers");
			if (integer1 < 0 || integer2 <0) {
				throw alert4;
			}
		}
	//Performs the input and variable setting
		public void GCD() throws GDC_Exception {
			System.out.println("This is the GCD Calculator.\nInput two positive integers to calculate their Greatest Common Divisor.");
			setIntegers();
			check_for_neg_ints();
		}
	public static void main(String[] args) throws GDC_Exception {
		GCD_calc sim = new GCD_calc();
	}

}
