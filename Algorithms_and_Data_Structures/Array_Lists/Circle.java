//CPSC 50300 Assignment Week 4				
//Joe Cruz 	
//Part_1B
//Question 5
//
//This part of the program defines the class Circle, which is used to create the actual circle. This was obtained from the assignment and no changes have been made to it. 

import java.awt.*;
public class Circle
{
   private int diameter, x, y;
   private Color color;
   //-----------------------------------------------------------------
   //  Constructor: Sets up this circle with the specified values.
   //-----------------------------------------------------------------
   public Circle(int size, Color shade, int upperX, int upperY) 
   {
      diameter = size;
      color = shade;
      x = upperX;
      y = upperY;
   }
   //-----------------------------------------------------------------
   //  Draws this circle in the specified graphics context.
   //-----------------------------------------------------------------
   public void draw(Graphics page)
   {
      page.setColor(color);
      page.fillOval(x, y, diameter, diameter);
   }

   //-----------------------------------------------------------------
   //  Diameter mutator.
   //-----------------------------------------------------------------
   public void setDiameter(int size)
   {
      diameter = size;
   }

   //-----------------------------------------------------------------
   //  Color mutator.
   //-----------------------------------------------------------------
   public void setColor(Color shade)
   {
      color = shade;
   }

   //-----------------------------------------------------------------
   //  X mutator.
   //-----------------------------------------------------------------
   public void setX(int upperX)
   {
      x = upperX;
   }

   //-----------------------------------------------------------------
   //  Y mutator.
   //-----------------------------------------------------------------
   public void setY(int upperY)
   {
      y = upperY;
   }

   //-----------------------------------------------------------------
   //  Diameter accessor.
   //-----------------------------------------------------------------
   public int getDiameter()
   {
      return diameter;
   }
   //-----------------------------------------------------------------
   //  Color accessor.
   //-----------------------------------------------------------------
   public Color getColor()
   {
      return color;
   }

   //-----------------------------------------------------------------
   //  X accessor.
   //-----------------------------------------------------------------
   public int getX()
   {
      return x;
   }

   //-----------------------------------------------------------------
   //  Y accessor.
   //-----------------------------------------------------------------
   public int getY()
   {
      return y;
   }
}
