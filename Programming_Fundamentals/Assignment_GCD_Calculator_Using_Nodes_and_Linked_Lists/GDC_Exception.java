///Week 7 Assignment 						Author: Joe Cruz
///Part_4	GDC_Exception class extended from the Exception class.
///
///This program is meant to calculate the greatest common divisor between two positive integers. 
///
///This portion of the program is create the class for handling exceptions. By pulling from the exception class we can input a string message for the exception that will read out
///specific conditions are met in the previous code.

public class GDC_Exception extends Exception{

	GDC_Exception(String message) {
		super(message);
	}
}
