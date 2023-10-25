// Week 8 Assignment Word Sorting			Author: Joe Cruz
//08Mar2020
//Part 1_Input Class
//
//This code is meant to take in either manual input user words or a file of words and sort them.
//This portion of the code houses the main function that runs everything.
//Furthermore, this portion of the code houses the Input class, which is responsible for the input the user desires to use.
//The code is written so that the user can choose between uploading a txt file of words to sort or to manually input the words.
//Methods are implemented for file handling, user input handling, etc.
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Input {

	//Initiate variables and the array list for strings
	String stringvalue= "";
	int string_check = 0;
	ArrayList<String> to_sort_list= new ArrayList<String>();

	//method to take in user input for words to sort.
	private String getString() {
		Scanner scan1 = new Scanner(System.in);
		stringvalue = scan1.next();
		return stringvalue;
		
		}
	
	//method to check for user indicator to stop taking in input for the sorting program.
	private int input_check() {
		if (stringvalue.equals("---")) {
			string_check= 1;}
		return string_check;
	}
	
	//method for determination of file input or manual input
	private int file_manual_input_choice() {
		int input_check= 0;
		while (input_check == 0) {
		Scanner scan2 = new Scanner(System.in);
		String choice = scan2.next();
		if (choice.compareToIgnoreCase("y") == 0) {
			input_check = 1;}
		if (choice.compareToIgnoreCase("n")== 0) {
			input_check = 2;}
		if (choice.compareToIgnoreCase("y") != 0 && choice.compareToIgnoreCase("n")!= 0)
			input_check= 0;}
		return input_check;
	}
	
	//method for file handling
	private void IO_manipulation () throws FileNotFoundException {
            		 
		 FileDialog File_Dil = new FileDialog((Frame)null, "Select File", FileDialog.LOAD);
		 File_Dil.setFile("*.txt");
		 File_Dil.setVisible(true);
         File inputFile = new File(File_Dil.getDirectory() + File_Dil.getFile());
         System.out.println("\nFile " + File_Dil.getDirectory() + File_Dil.getFile() + " selected.");
         Scanner fileScan = new Scanner(inputFile);
       while(fileScan.hasNext()) {
               try {
                     to_sort_list.add(fileScan.nextLine());                                
              } catch (Exception e) {
                   System.out.println("Input Error!");
            }
    }
         fileScan.close();    
	}
//method to perform the intro to the program, determine whehter file or manual entry, add the string value input by the user to an Arraylist or the file value input would also be added to the arraylist. 
	public void Input() throws FileNotFoundException {
		System.out.println("Welcome to the Word Sorting Program! \nWould you like to sort words from a text file(y/n)?");
		int checkpoint = file_manual_input_choice();
		if(checkpoint ==2) {
				System.out.println("\nPlease enter the words you want to be sorted.(Enter '---' to end the input phase)");
				while (string_check == 0) {
					getString();
					input_check(); 
					if (string_check != 1) {
						to_sort_list.add(stringvalue);}}}
		if (checkpoint == 1) {
			IO_manipulation ();}
	}
	//main calls an instantiation of the Sorting class 
	public static void main(String[] args) throws FileNotFoundException {
		Sorting sim = new Sorting();
	}
}
