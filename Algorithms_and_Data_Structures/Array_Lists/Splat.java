//CPSC 50300 Assignment Week 4				
//Joe Cruz 	
//Part_1
//Question 5
//
//This test program allows the user to create a circle within a new window with a black background. The user will input the desired diameter, color, 
//x coordinate, and y coordinate of the circle and then it will be made. Exceptions are thrown in the event of an improper input (non integer or not
//proper color selection). 

import javax.swing.*;
import java.awt.*;

public class Splat {
	
	public static void main(String[] args) throws Invalid_Entry {
		   { 
			      JFrame frame = new JFrame("Splat");
			      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			     
			      //This is the command that begins the user entry and creation of the circle.
			      frame.getContentPane().add(new SplatPanel());
			      frame.pack();
			      frame.setVisible(true);
			   }
			}}
