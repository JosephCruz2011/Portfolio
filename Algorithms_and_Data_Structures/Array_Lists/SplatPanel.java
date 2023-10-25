//CPSC 50300 Assignment Week 4				
//Joe Cruz 	
//Part_1A
//Question 5
//
//This part of the program is used to obtain the user defined circle parameters as well as create the circle and the 
//background size and color for the panel that will pop up after creating the circle. Input windows will appear to the user with the 
//various parameters that must be defined. Methods were added to this section in order to obtain the user input. 

import javax.swing.*;
import java.awt.*;
import javax.swing.text.html.StyleSheet;

public class SplatPanel extends JPanel
{
   private Circle circle1;
    //New ArrayList is created to hold the details entered by the user.
	ArrayList<String> Circle_details = new ArrayList<String>(4);
	
	//method used to add the diameter, color, x-coord, and y-coord to the ArrayList.  The entry of an improper color will prompt an exception
	//Further, the entry of an improper integer will not prompt an exception until the entry of all values is complete. So if a string of abc
	//is entered for the diameter, an exception will not be initially thrown, rather after the y coordinate entry is performed an exception will occur. 
	void add_value() throws Invalid_Entry{
		 //Entry of the diameter of the circle. 
		String inputStr=JOptionPane.showInputDialog("Please enter the desired diameter of the circle as an integer: ");
		Circle_details.add(0,inputStr);
		
		//Entry of the desired color. This allows user to chose the circle color from the colors listed, where if the entry is not equal to one of the choices, as error is thrown. The case of the entry does not matter. 
		//The colors are as follows: Aqua, Black, Blue, Fuchsia, Gray, Green, Orange, Purple, Red, Teal, White, or Yellow.
		String colorStr=JOptionPane.showInputDialog("Please enter the desired color of the circle. Choose from the following: \nAqua, Black, Blue, Fuchsia, Gray, Green, Orange, Purple, Red, Teal, White, or Yellow: ");
		Circle_details.add(1, colorStr);
		
			//Checks for proper entry of color and throws exception if there is an improper entry.
			if (Circle_details.get(1).equalsIgnoreCase("aqua") || Circle_details.get(1).equalsIgnoreCase("black") || Circle_details.get(1).equalsIgnoreCase("blue") || Circle_details.get(1).equalsIgnoreCase("fuchsia") || Circle_details.get(1).equalsIgnoreCase("gray") || Circle_details.get(1).equalsIgnoreCase("green") || Circle_details.get(1).equalsIgnoreCase("orange") || Circle_details.get(1).equalsIgnoreCase("purple") || Circle_details.get(1).equalsIgnoreCase("red") || Circle_details.get(1).equalsIgnoreCase("teal") || Circle_details.get(1).equalsIgnoreCase("white") ||Circle_details.get(1).equalsIgnoreCase("yellow")) {}
			else {throw new Invalid_Entry("Color entry not valid");}
				
		//Entry of the x coordinate of the circle.
		String x_cordStr=JOptionPane.showInputDialog("Please enter the desired X coordinate as an integer: ");		
		Circle_details.add(2,x_cordStr);
		
		//Entry of the y coordinate of the circle.
		String y_cordStr=JOptionPane.showInputDialog("Please enter the desired Y coordinate as an integer:");
		Circle_details.add(3,y_cordStr);
	}

   //runs the program when prompted. 
   public SplatPanel() throws Invalid_Entry
   {
	   String welcome= "Hello. This program is designed to create a circle from user-defined input. The diameter, color, x-coordinate, and y-coordinate will be collected from the user and a circle will be made."; 
	  
	   JOptionPane.showMessageDialog(null, welcome,"Circle Generation Program",JOptionPane.INFORMATION_MESSAGE);
	 
	  //obtains user input for the aforementioned details.
	  add_value(); 
	  
	  //converts the user entry for color into a usable color.
	  StyleSheet sheet = new StyleSheet();
      String color_str = Circle_details.get(1).toUpperCase();
      Color color = sheet.stringToColor(color_str);
	  
      //creates the circle with user defined diameter, color, x-coordinate, and y-coordinate.
	  circle1 = new Circle(Integer.valueOf(Circle_details.get(0)), color , Integer.valueOf(Circle_details.get(2)), Integer.valueOf(Circle_details.get(3)));
	  setPreferredSize(new Dimension(300, 200));
      setBackground(Color.black);
   }
   //-----------------------------------------------------------------
   //  Draws this panel by requesting that each circle draw itself.
   //-----------------------------------------------------------------
   public void paintComponent(Graphics page)
   {
      super.paintComponent(page);
      circle1.draw(page);      
   }
}

