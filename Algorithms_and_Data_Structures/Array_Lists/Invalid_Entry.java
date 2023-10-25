//CPSC 50300 Assignment Week 4			
//Joe Cruz 
//Part_1C	
//Question 5
//
//This portion of the program is create the class for handling exceptions. By pulling from the exception class we can input a string message for the exception that will read out
//specific conditions are met in the previous code.

public class Invalid_Entry extends Exception {
		
		Invalid_Entry(String message) {
				super(message);
			}
		  
		}


