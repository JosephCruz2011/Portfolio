//Week 6 Assignment Part 2				Author: Joe Cruz

// This class is a subclass of Person(found in Person.java)

//This class is used to perform the employee pay calculations as well 
//as gather input from the data as to how many hours worked and if special hours
//were worked. 


import java.util.Scanner;

public class PaidAdvisor extends Person {

		//initiating float variables.
		float regularPayRate, specialPayRate, overtimePayRate, hoursRegular, hoursSpecial, hoursOvertime, regular_pay, special_pay, overtime_pay, pay;
	
		//constructor to set variable values for this instantiation of class
		PaidAdvisor (String firstName, String lastName) {
			super(firstName, lastName);
			regularPayRate = 25;
			specialPayRate = 50;
			overtimePayRate =(float)37.50; 
			hoursRegular = 0;
			hoursSpecial = 0;
			hoursOvertime = 0;
			pay = 0;
			regular_pay = 0;
			special_pay = 0;
			overtime_pay = 0;
		}
		
		//Gets the hours worked from the user.
		private float gethoursWorked() {
			Scanner scan1 = new Scanner(System.in);
			System.out.println("Total Hours Worked:");
			float hoursRegular = scan1.nextFloat();
			
			return hoursRegular;
		}
		 
			
		//returns the pay rate pending on the kind of work that the function calls.
		private float getPayRate (int work_type) {
			if (work_type == 1) {
				return regularPayRate;}
			if (work_type == 2) {
				return overtimePayRate;}
			if (work_type == 3) {
				return specialPayRate;}
			else {
				return 0;}
			}
		
		//Asks user for input to if they worked a special session.
		private String Special() {
			System.out.println("Have you worked for a special session? (y/n)");
			Scanner scan2= new Scanner(System.in);
			String special_ses= scan2.next();
			return special_ses; }
			
		//Obtains input for number of special hours worked.
		private float hoursSpecial() {
			System.out.println("Total Special Session Hours Worked:");
			Scanner scan3= new Scanner(System.in);
			hoursSpecial= scan3.nextFloat();
			return hoursSpecial; }
		
		//performs the special session section_asks question, recieves input, if no continues on, if yes asks for further input as to how many hours.
		private float Special_Session() {
			String Special_confirmation = Special();
			int check =confirmation(Special_confirmation);
			while (check == 3) {
				String re_check=Special();
				check =confirmation(re_check);}
			if (check == 1) {			
			hoursSpecial=hoursSpecial();
			return hoursSpecial;}
			else {
				hoursSpecial= 0;
				return hoursSpecial;
			}
		}
			
		//confirmation check for user input
		private int confirmation(String input) {
			int result = 0;
			if (input.equalsIgnoreCase("y")) {
				result = 1;}
			
			if (input.equalsIgnoreCase("n")) { 
				result = 2;}
				
			if (input.equalsIgnoreCase("y") == false && input.equalsIgnoreCase("n") == false) {
				System.out.println ("Please select y or n");
				result = 3;}	
			return result;
		}
			
		//subtracts special hours from regular hours.
		private float Special_calc() {
			float Result = hoursRegular - hoursSpecial;
			return Result;}
		//calculates overtime hours from total number of hours worked.
		private float overtime_calc() {
			if (hoursRegular > 30) { 
				hoursOvertime= hoursRegular- 30; }
			else {
				hoursOvertime=0; }
			return hoursOvertime;
			}
		
		//overwrites original toString to return reg pay, overtime pay, and special pay as well as a total paid for the employee.
		public String toString()
		{
			String reg= "Regular Pay:  $" + regular_pay + "\n";
			String over="Overtime Pay: $" + overtime_pay + "\n";
			String spec= "Special Pay:  $" + special_pay + "\n";
			String total= "Total:       $" + pay + "\n";
			String output=reg + over + spec + total;
			return (output);
		}
		
		//returns  the regular, overtime, and special hour pay rate for employee.
		public String to_String_rates_hours ()
		{
			String reg= "\nRegular Rate: " + " $" + regularPayRate + "/hr " + hoursRegular + " hrs worked\n";
			String over="Overtime Rate: " + "$" + overtimePayRate + "/hr " + hoursOvertime + " hrs worked\n" ;
			String spec= "Special Rate: " + " $" + specialPayRate + "/hr " + hoursSpecial + " hrs worked\n";
			String output=reg+over+spec;
			return (output);
		}
		
		//performs pay calculation by obtaining hours worked from user, figuring out special hours then subtracting those special hours from the hours worked,
		//then take the overtime from the remaining hours worked and calculate total pay from all of these.
		public void calculatePay() {
			
			
			hoursRegular = gethoursWorked();
			hoursSpecial = Special_Session();
			while (hoursSpecial > hoursRegular) {
				System.out.println("Special hours cannot exceed hours worked.\n");
				hoursSpecial=Special_Session();}
			hoursRegular= Special_calc();
			hoursOvertime= overtime_calc();
			hoursRegular= hoursRegular-hoursOvertime;
			regular_pay= getPayRate(1) *hoursRegular;
			overtime_pay= getPayRate(2) * hoursOvertime;
			special_pay= getPayRate(3) * hoursSpecial;
			pay= regular_pay + overtime_pay + special_pay;
			setNameRateHours();
			System.out.println(toString());
			
		}
		
		//Prints out the employee name with their associated rates /hour.
		public void setNameRateHours () {
			String Name = super.toString();
			String Rate_hours = to_String_rates_hours();
			String Name_Rate_Hours= Name+Rate_hours;
			System.out.println(Name_Rate_Hours);
			
		}
	}
		
		
