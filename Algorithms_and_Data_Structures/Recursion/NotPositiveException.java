//CPSC 50300 Assignment Week 3				
//Joe Cruz 
//Part_1A	
//Question 1
//
//This portion of the program is create the class for handling exceptions. By pulling from the exception class we can input a string message for the exception that will read out
//specific conditions are met in the previous code.

public class NotPositiveException extends Exception {
	
	NotPositiveException(String message) {
			super(message);
		}
	 
	}


