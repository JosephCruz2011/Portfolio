//CPSC 50300 Assignment Week 2				
//Joe Cruz 
//Part_1	
//Question 1
//
//This program is designed to create an array of any size larger than n>=2 and fill it with
//integers between 1 and n-1 with only one of them being repeated. The program then finds the repeat
//and displays how many times the integer repeats in the array. 

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Question_1 {

	//initiates variables required for the program
	private int n_value;
	private int[] nums;
	private int repeated = 0;
	private int place_holder;
	private int times_repeated;
	
	//creates an exception alert for input of the array size (must be greater than or equal to 2
	Exception_class alert= new Exception_class("Array size must be greater than or equal to 2 (n>=2)");
	
	//creates random object required for random value generation.
	Random rand= new Random();
	
	//method to obtain the size of the desired array from the user 
	//throws exception mentioned in Line 23.
	private void get_n() throws Exception_class {
		System.out.print("Input the value of n: \n");
		Scanner scan1 = new Scanner(System.in);
		n_value = scan1.nextInt();
		if (n_value < 2) {
			throw alert;}}
	
	//method cycles through the created array and creates a random value between 1 and n-1 inclusive that
	//will be checked utilizing a recursive method below
	private void array_check() {
		for(int  i = 1; i<n_value; i++) {
			place_holder=rand.nextInt(n_value-1)+1;
			recursive_array_element(i);
			}
	}
		 
	//recursive method to compare the random value generated to the elements already in the array. This is to 
	//ensure that only 1 value can be repeated and that no other value can be. 
	private void recursive_array_element (int y) {
		for(int z=0; z<n_value; z++) {
		//System.out.println("Current value to check: " + place_holder);
		int temp_hold;
		temp_hold = nums[z];
		//System.out.println("Value compared to: " + temp_hold);
		if (temp_hold == 0) {
			if(temp_hold == place_holder) {	
				if (repeated == 0 && y != z) {
					repeated = place_holder; } 
				nums[y]=place_holder;}
			}
		else  {
			if(temp_hold == place_holder) {
				if (repeated == 0 && y != z) {
					repeated = place_holder;} 
				else if (temp_hold == repeated) {
					nums[y]=place_holder;}
				else if(repeated !=0 && y !=z) {
					place_holder=rand.nextInt(n_value-1)+1;
					recursive_array_element(y);}
				nums[y]=place_holder;
			}
			nums[y]=place_holder;}
		}}
	
	//method to obtain the number of times the repeated value was repeated. 
	private void times_repeated_calc () {
		for(int a=0; a<n_value; a++) {
		int temp_hold_Time = nums[a];
		if (temp_hold_Time == repeated) {
			times_repeated +=1;
		}
	}}

	//method to perform array establishment and prints out the array created, the integer repeated, and the number of times repeated.
	private void initial_array() throws Exception_class{
		get_n();
		nums= new int[n_value];
		nums[0]=rand.nextInt(n_value-1)+1;
		array_check();
		times_repeated_calc ();
		System.out.println("The array is as follows:\n" + Arrays.toString(nums) + ".");
		System.out.println("\nThe integer that is repeated is: " +repeated + ".");
		System.out.println("\nThe integer " + repeated + " is repeated " + times_repeated + " times.");
	}
	
	
	public static void main(String[] args) throws Exception_class {
		Question_1 Run = new Question_1();
		System.out.print("Hello,\n\nThis program is used to create an array of n size that is larger than or equal to 2. The array is filled with random numbers between 1 and n-1 with only 1 value repeating. \nThe program then finds the value that repeats and determines how many times it does so in the array.\nThe output is the array created along with the value repeated and its number of times repeated.\n\nPlease enter an integer value of n>=2\n\n");
		Run.initial_array();
	}

}

