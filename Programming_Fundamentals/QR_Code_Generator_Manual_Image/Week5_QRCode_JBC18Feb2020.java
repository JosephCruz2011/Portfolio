//Week 5 Assignment							Author:Joe Cruz
//
//
//Purpose: To recreate example QR Code using JavaFX shapes. 




package application;
	
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
			//Larger corner square -left top
			Rectangle LT_LSquare=new Rectangle (96, 44,38,39);
			LT_LSquare.setStrokeWidth(6);
			LT_LSquare.setStroke(Color.BLACK);
			LT_LSquare.setFill(Color.WHITE);

			//Fill square for large corner square- left top
			Rectangle LT_SSquare=new Rectangle (105, 54,20,20);
			LT_SSquare.setStrokeWidth(1);
			LT_SSquare.setStroke(Color.BLACK);
			LT_SSquare.setFill(Color.BLACK);
			
			//Larger corner square -top right
			Rectangle TR_LSquare=new Rectangle (207, 44,38,39);
			TR_LSquare.setStrokeWidth(6);
			TR_LSquare.setStroke(Color.BLACK);
			TR_LSquare.setFill(Color.WHITE);
			
			//Fill square for large corner square- top right
			Rectangle TR_SSquare=new Rectangle (216, 54,20,20);
			TR_SSquare.setStrokeWidth(1);
			TR_SSquare.setStroke(Color.BLACK);
			TR_SSquare.setFill(Color.BLACK);
			
			//Larger corner square -left bottom
			Rectangle LB_LSquare=new Rectangle (96, 153,38,39);
			LB_LSquare.setStrokeWidth(6);
			LB_LSquare.setStroke(Color.BLACK);
			LB_LSquare.setFill(Color.WHITE);
			
			//Fill square for large corner square- left bottom
			Rectangle LB_SSquare=new Rectangle (105, 163,20,20);
			LB_SSquare.setStrokeWidth(1);
			LB_SSquare.setStroke(Color.BLACK);
			LB_SSquare.setFill(Color.BLACK);
			
	///BOTTTOM RIGHT CORNER RECTANGLES		
			//Mid_size box bottom right
			Rectangle BR_1=new Rectangle (193, 142,27,27);
			BR_1.setStrokeWidth(6);
			BR_1.setStroke(Color.BLACK);
			BR_1.setFill(Color.WHITE);
			
			//Smaller fill in bottom right mid_size  
			Rectangle BR_2=new Rectangle (203, 151,8,8);
			BR_2.setStrokeWidth(1);
			BR_2.setStroke(Color.WHITE);
			BR_2.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle BR_3=new Rectangle (223, 153,5,5);
			BR_3.setStrokeWidth(1);
			BR_3.setStroke(Color.BLACK);
			BR_3.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle BR_4=new Rectangle (229, 147,5,5);
			BR_4.setStrokeWidth(1);
			BR_4.setStroke(Color.BLACK);
			BR_4.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle BR_5=new Rectangle (242, 142,5,5);
			BR_5.setStrokeWidth(1);
			BR_5.setStroke(Color.BLACK);
			BR_5.setFill(Color.BLACK);
		
			//Filler rectangles small
			Rectangle BR_6=new Rectangle (242, 190,5,5);
			BR_6.setStrokeWidth(1);
			BR_6.setStroke(Color.BLACK);
			BR_6.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle BR_7=new Rectangle (242, 178, 5,5);
			BR_7.setStrokeWidth(1);
			BR_7.setStroke(Color.BLACK);
			BR_7.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle BR_8=new Rectangle (236, 184,5,5);
			BR_8.setStrokeWidth(1);
			BR_8.setStroke(Color.BLACK);
			BR_8.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle BR_9=new Rectangle (230, 178,5,5);
			BR_9.setStrokeWidth(1);
			BR_9.setStroke(Color.BLACK);
			BR_9.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle BR_10=new Rectangle (223, 184,5,5);
			BR_10.setStrokeWidth(1);
			BR_10.setStroke(Color.BLACK);
			BR_10.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle BR_11=new Rectangle (217, 190 ,5,5);
			BR_11.setStrokeWidth(1);
			BR_11.setStroke(Color.BLACK);
			BR_11.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle BR_12=new Rectangle (217, 178 ,5,5);
			BR_12.setStrokeWidth(1);
			BR_12.setStroke(Color.BLACK);
			BR_12.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle BR_13=new Rectangle (203, 178 ,5,5);
			BR_13.setStrokeWidth(1);
			BR_13.setStroke(Color.BLACK);
			BR_13.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle BR_14=new Rectangle (202, 190 ,5,5);
			BR_14.setStrokeWidth(1);
			BR_14.setStroke(Color.BLACK);
			BR_14.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle BR_15=new Rectangle (197, 184 ,5,5);
			BR_15.setStrokeWidth(1);
			BR_15.setStroke(Color.BLACK);
			BR_15.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle BR_16=new Rectangle (197, 172 ,5,5);
			BR_16.setStrokeWidth(1);
			BR_16.setStroke(Color.BLACK);
			BR_16.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle BR_17=new Rectangle (191, 178 ,5,5);
			BR_17.setStrokeWidth(1);
			BR_17.setStroke(Color.BLACK);
			BR_17.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle BR_18=new Rectangle (185, 190 ,5,5);
			BR_18.setStrokeWidth(1);
			BR_18.setStroke(Color.BLACK);
			BR_18.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle BR_19=new Rectangle (179, 184 ,5,5);
			BR_19.setStrokeWidth(1);
			BR_19.setStroke(Color.BLACK);
			BR_19.setFill(Color.BLACK);
			
			//Filler rectangles small - 12x12
			Rectangle BR_20=new Rectangle (235, 152 ,12,12);
			BR_20.setStrokeWidth(1);
			BR_20.setStroke(Color.BLACK);
			BR_20.setFill(Color.BLACK);
			
			//Filler rectangles small 12x12
			Rectangle BR_21=new Rectangle (223, 165 ,12,12);
			BR_21.setStrokeWidth(1);
			BR_21.setStroke(Color.BLACK);
			BR_21.setFill(Color.BLACK);
			
			//Filler rectangles small 12x12
			Rectangle BR_22=new Rectangle (172, 158 ,12,12);
			BR_22.setStrokeWidth(1);
			BR_22.setStroke(Color.BLACK);
			BR_22.setFill(Color.BLACK);
			
			
//MIDRIGHT
			//Filler rectangles small
			Rectangle MR_1=new Rectangle (185, 134 ,5,5);
			MR_1.setStrokeWidth(1);
			MR_1.setStroke(Color.BLACK);
			MR_1.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle MR_2=new Rectangle (179, 140 ,5,5);
			MR_2.setStrokeWidth(1);
			MR_2.setStroke(Color.BLACK);
			MR_2.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle MR_3=new Rectangle (179, 128 ,5,5);
			MR_3.setStrokeWidth(1);
			MR_3.setStroke(Color.BLACK);
			MR_3.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle MR_4=new Rectangle (173, 134 ,5,5);
			MR_4.setStrokeWidth(1);
			MR_4.setStroke(Color.BLACK);
			MR_4.setFill(Color.BLACK);

			//Filler rectangles small
			Rectangle MR_5=new Rectangle (167, 128 ,5,5);
			MR_5.setStrokeWidth(1);
			MR_5.setStroke(Color.BLACK);
			MR_5.setFill(Color.BLACK);
	
			//Filler rectangles small 12x12
			Rectangle MR_6=new Rectangle (191, 116 ,12,12);
			MR_6.setStrokeWidth(1);
			MR_6.setStroke(Color.BLACK);
			MR_6.setFill(Color.BLACK);
		
			
//MIDLEFT
			//Filler rectangles small
			Rectangle ML_1=new Rectangle (161, 134 ,5,5);
			ML_1.setStrokeWidth(1);
			ML_1.setStroke(Color.BLACK);
			ML_1.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle ML_2=new Rectangle (149, 127 ,5,5);
			ML_2.setStrokeWidth(1);
			ML_2.setStroke(Color.BLACK);
			ML_2.setFill(Color.BLACK);
			
			//Filler rectangles small 12x12
			Rectangle ML_3=new Rectangle (142, 133 ,12,12);
			ML_3.setStrokeWidth(1);
			ML_3.setStroke(Color.BLACK);
			ML_3.setFill(Color.BLACK);
			
			//Filler rectangles small 12x12
			Rectangle ML_4=new Rectangle (154, 145 ,12,12);
			ML_4.setStrokeWidth(1);
			ML_4.setStroke(Color.BLACK);
			ML_4.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle ML_5=new Rectangle (131, 140 ,5,5);
			ML_5.setStrokeWidth(1);
			ML_5.setStroke(Color.BLACK);
			ML_5.setFill(Color.BLACK);
			
			//Filler rectangles small 12x12
			Rectangle ML_6=new Rectangle (118, 133 ,12,12);
			ML_6.setStrokeWidth(1);
			ML_6.setStroke(Color.BLACK);
			ML_6.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle ML_7=new Rectangle (106, 140 ,5,5);
			ML_7.setStrokeWidth(1);
			ML_7.setStroke(Color.BLACK);
			ML_7.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle ML_8=new Rectangle (94, 140 ,5,5);
			ML_8.setStrokeWidth(1);
			ML_8.setStroke(Color.BLACK);
			ML_8.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle ML_9=new Rectangle (100, 134 ,5,5);
			ML_9.setStrokeWidth(1);
			ML_9.setStroke(Color.BLACK);
			ML_9.setFill(Color.BLACK); 
			
			//Filler rectangles small
			Rectangle ML_10=new Rectangle (94, 128 ,5,5);
			ML_10.setStrokeWidth(1);
			ML_10.setStroke(Color.BLACK);
			ML_10.setFill(Color.BLACK); 
			
			//Filler rectangles small
			Rectangle ML_11=new Rectangle (106, 128 ,5,5);
			ML_11.setStrokeWidth(1);
			ML_11.setStroke(Color.BLACK);
			ML_11.setFill(Color.BLACK); 
			
			//Filler rectangles small
			Rectangle ML_12=new Rectangle (100, 122 ,5,5);
			ML_12.setStrokeWidth(1);
			ML_12.setStroke(Color.BLACK);
			ML_12.setFill(Color.BLACK); 
			
			//Filler rectangles small
			Rectangle ML_13=new Rectangle (106, 110 ,5,5);
			ML_13.setStrokeWidth(1);
			ML_13.setStroke(Color.BLACK);
			ML_13.setFill(Color.BLACK); 
			
			//Filler rectangles small 12x12
			Rectangle ML_14=new Rectangle (112, 115 ,12,12);
			ML_14.setStrokeWidth(1);
			ML_14.setStroke(Color.BLACK);
			ML_14.setFill(Color.BLACK);
			
			//Filler rectangles small 12x12
			Rectangle ML_15=new Rectangle (118, 109 ,12,12);
			ML_15.setStrokeWidth(1);
			ML_15.setStroke(Color.BLACK);
			ML_15.setFill(Color.BLACK);
			
			//Filler rectangles small 12x12
			Rectangle ML_16=new Rectangle (118, 109 ,12,12);
			ML_16.setStrokeWidth(1);
			ML_16.setStroke(Color.BLACK);
			ML_16.setFill(Color.BLACK);
			
			//Filler rectangles small 12x12
			Rectangle ML_17=new Rectangle (137, 115 ,12,12);
			ML_17.setStrokeWidth(1);
			ML_17.setStroke(Color.BLACK);
			ML_17.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle ML_18=new Rectangle (131, 128 ,5,5);
			ML_18.setStrokeWidth(1);
			ML_18.setStroke(Color.BLACK);
			ML_18.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle ML_19=new Rectangle (150, 109 ,5,5);
			ML_19.setStrokeWidth(1);
			ML_19.setStroke(Color.BLACK);
			ML_19.setFill(Color.BLACK);
			
			//Filler rectangles small 12x12
			Rectangle ML_20=new Rectangle (155, 115 ,12,12);
			ML_20.setStrokeWidth(1);
			ML_20.setStroke(Color.BLACK);
			ML_20.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle ML_21=new Rectangle (168, 115 ,5,5);
			ML_21.setStrokeWidth(1);
			ML_21.setStroke(Color.BLACK);
			ML_21.setFill(Color.BLACK);
			
			
		
			
			
	//TOP Left CORNER				
			
			//Filler rectangles small 11x11
			Rectangle TL_1=new Rectangle (94, 98,11,11);
			TL_1.setStrokeWidth(1);
			TL_1.setStroke(Color.BLACK);
			TL_1.setFill(Color.BLACK);
	
			
			//Filler rectangles small
			Rectangle TL_2=new Rectangle (106, 92 ,5,5);
			TL_2.setStrokeWidth(1);
			TL_2.setStroke(Color.BLACK);
			TL_2.setFill(Color.BLACK); 
			
			//Filler rectangles small
			Rectangle TL_3=new Rectangle (112, 98 ,5,5);
			TL_3.setStrokeWidth(1);
			TL_3.setStroke(Color.BLACK);
			TL_3.setFill(Color.BLACK); 
			
			//Filler rectangles small
			Rectangle TL_4=new Rectangle (118, 92 ,5,5);
			TL_4.setStrokeWidth(1);
			TL_4.setStroke(Color.BLACK);
			TL_4.setFill(Color.BLACK); 
			
			//Filler rectangles small
			Rectangle TL_5=new Rectangle (131, 103 ,5,5);
			TL_5.setStrokeWidth(1);
			TL_5.setStroke(Color.BLACK);
			TL_5.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle TL_6=new Rectangle (137, 97 ,5,5);
			TL_6.setStrokeWidth(1);
			TL_6.setStroke(Color.BLACK);
			TL_6.setFill(Color.BLACK);
			
			//Filler rectangles small 12x12
			Rectangle TL_7=new Rectangle (143, 90 ,12,12);
			TL_7.setStrokeWidth(1);
			TL_7.setStroke(Color.BLACK);
			TL_7.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle TL_8=new Rectangle (155, 97 ,5,5);
			TL_8.setStrokeWidth(1);
			TL_8.setStroke(Color.BLACK);
			TL_8.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle TL_9=new Rectangle (161, 91 ,5,5);
			TL_9.setStrokeWidth(1);
			TL_9.setStroke(Color.BLACK);
			TL_9.setFill(Color.BLACK);
			
			//Filler rectangles small 12x12
			Rectangle TL_10=new Rectangle (167, 84 ,12,12);
			TL_10.setStrokeWidth(1);
			TL_10.setStroke(Color.BLACK);
			TL_10.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle TL_11=new Rectangle (167, 78 ,5,5);
			TL_11.setStrokeWidth(1);
			TL_11.setStroke(Color.BLACK);
			TL_11.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle TL_12=new Rectangle (149, 78 ,5,5);
			TL_12.setStrokeWidth(1);
			TL_12.setStroke(Color.BLACK);
			TL_12.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle TL_13=new Rectangle (143, 78 ,5,5);
			TL_13.setStrokeWidth(1);
			TL_13.setStroke(Color.BLACK);
			TL_13.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle TL_14=new Rectangle (149, 72 ,5,5);
			TL_14.setStrokeWidth(1);
			TL_14.setStroke(Color.BLACK);
			TL_14.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle TL_15=new Rectangle (149, 60 ,5,5);
			TL_15.setStrokeWidth(1);
			TL_15.setStroke(Color.BLACK);
			TL_15.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle TL_16=new Rectangle (149, 48 ,5,5);
			TL_16.setStrokeWidth(1);
			TL_16.setStroke(Color.BLACK);
			TL_16.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle TL_17=new Rectangle (143, 42 ,5,5);
			TL_17.setStrokeWidth(1);
			TL_17.setStroke(Color.BLACK);
			TL_17.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle TL_18=new Rectangle (155, 42 ,5,5);
			TL_18.setStrokeWidth(1);
			TL_18.setStroke(Color.BLACK);
			TL_18.setFill(Color.BLACK);
			
			//Filler rectangles small 11x11
			Rectangle TL_19=new Rectangle (155, 66 ,11,11);
			TL_19.setStrokeWidth(1);
			TL_19.setStroke(Color.BLACK);
			TL_19.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle TL_20=new Rectangle (155, 54 ,5,5);
			TL_20.setStrokeWidth(1);
			TL_20.setStroke(Color.BLACK);
			TL_20.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle TL_21=new Rectangle (173, 54 ,5,5);
			TL_21.setStrokeWidth(1);
			TL_21.setStroke(Color.BLACK);
			TL_21.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle TL_22=new Rectangle (167, 60 ,5,5);
			TL_22.setStrokeWidth(1);
			TL_22.setStroke(Color.BLACK);
			TL_22.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle TL_23=new Rectangle (167, 48 ,5,5);
			TL_23.setStrokeWidth(1);
			TL_23.setStroke(Color.BLACK);
			TL_23.setFill(Color.BLACK);


			
			
	///TOP RIGHT CORNER
			//Filler rectangles small
			Rectangle tr1=new Rectangle (179, 60 ,5,5);
			tr1.setStrokeWidth(1);
			tr1.setStroke(Color.BLACK);
			tr1.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle tr2=new Rectangle (185, 54 ,5,5);
			tr2.setStrokeWidth(1);
			tr2.setStroke(Color.BLACK);
			tr2.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle tr3=new Rectangle (185, 48 ,5,5);
			tr3.setStrokeWidth(1);
			tr3.setStroke(Color.BLACK);
			tr3.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle tr4=new Rectangle (179, 42 ,5,5);
			tr4.setStrokeWidth(1);
			tr4.setStroke(Color.BLACK);
			tr4.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle tr5=new Rectangle (191, 54 ,5,5);
			tr5.setStrokeWidth(1);
			tr5.setStroke(Color.BLACK);
			tr5.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle tr6=new Rectangle (185, 84 ,5,5);
			tr6.setStrokeWidth(1);
			tr6.setStroke(Color.BLACK);
			tr6.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle tr7=new Rectangle (179, 78 ,5,5);
			tr7.setStrokeWidth(1);
			tr7.setStroke(Color.BLACK);
			tr7.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle tr8=new Rectangle (191, 78 ,5,5);
			tr8.setStrokeWidth(1);
			tr8.setStroke(Color.BLACK);
			tr8.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle tr9=new Rectangle (185, 72 ,5,5);
			tr9.setStrokeWidth(1);
			tr9.setStroke(Color.BLACK);
			tr9.setFill(Color.BLACK);
			
			//Filler rectangles small 11x11
			Rectangle tr10=new Rectangle (173, 66 ,11,11);
			tr10.setStrokeWidth(1);
			tr10.setStroke(Color.BLACK);
			tr10.setFill(Color.BLACK);
			
			
			//Filler rectangles small 12x12
			Rectangle tr11=new Rectangle (179, 97 ,12,12);
			tr11.setStrokeWidth(1);
			tr11.setStroke(Color.BLACK);
			tr11.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle tr12=new Rectangle (192, 97 ,5,5);
			tr12.setStrokeWidth(1);
			tr12.setStroke(Color.BLACK);
			tr12.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle tr13=new Rectangle (198, 91 ,5,5);
			tr13.setStrokeWidth(1);
			tr13.setStroke(Color.BLACK);
			tr13.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle tr14=new Rectangle (204, 129 ,5,5);
			tr14.setStrokeWidth(1);
			tr14.setStroke(Color.BLACK);
			tr14.setFill(Color.BLACK);
			
			
			//Filler rectangles small
			Rectangle tr15=new Rectangle (223, 129 ,5,5);
			tr15.setStrokeWidth(1);
			tr15.setStroke(Color.BLACK);
			tr15.setFill(Color.BLACK);
			
			//Filler rectangles small 12x12
			Rectangle tr16=new Rectangle (210, 116 ,12,12);
			tr16.setStrokeWidth(1);
			tr16.setStroke(Color.BLACK);
			tr16.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle tr17=new Rectangle (223, 116 ,5,5);
			tr17.setStrokeWidth(1);
			tr17.setStroke(Color.BLACK);
			tr17.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle tr18=new Rectangle (229, 116 ,5,5);
			tr18.setStrokeWidth(1);
			tr18.setStroke(Color.BLACK);
			tr18.setFill(Color.BLACK);
			
			//Filler rectangles small 12x12
			Rectangle tr19=new Rectangle (235, 122 ,12,12);
			tr19.setStrokeWidth(1);
			tr19.setStroke(Color.BLACK);
			tr19.setFill(Color.BLACK);
			
			//Filler rectangles small 12x12
			Rectangle tr20=new Rectangle (235, 103 ,12,12);
			tr20.setStrokeWidth(1);
			tr20.setStroke(Color.BLACK);
			tr20.setFill(Color.BLACK);
			
			
			//Filler rectangles small
			Rectangle tr21=new Rectangle (235, 91 ,5,5);
			tr21.setStrokeWidth(1);
			tr21.setStroke(Color.BLACK);
			tr21.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle tr22=new Rectangle (229, 97 ,5,5);
			tr22.setStrokeWidth(1);
			tr22.setStroke(Color.BLACK);
			tr22.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle tr23=new Rectangle (223, 91 ,5,5);
			tr23.setStrokeWidth(1);
			tr23.setStroke(Color.BLACK);
			tr23.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle tr24=new Rectangle (217, 97 ,5,5);
			tr24.setStrokeWidth(1);
			tr24.setStroke(Color.BLACK);
			tr24.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle tr25=new Rectangle (211, 97 ,5,5);
			tr25.setStrokeWidth(1);
			tr25.setStroke(Color.BLACK);
			tr25.setFill(Color.BLACK);
			
			//Filler rectangles small 12x12
			Rectangle tr26=new Rectangle (204, 103 ,12,12);
			tr26.setStrokeWidth(1);
			tr26.setStroke(Color.BLACK);
			tr26.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle tr27=new Rectangle (217, 110 ,5,5);
			tr27.setStrokeWidth(1);
			tr27.setStroke(Color.BLACK);
			tr27.setFill(Color.BLACK);
			
			
			
			
	//BOTTOM LEFT/MID RECTANGLES
			
			//Filler rectangles small 12x12
			Rectangle LB_1=new Rectangle (167, 171 ,12,12);
			LB_1.setStrokeWidth(1);
			LB_1.setStroke(Color.BLACK);
			LB_1.setFill(Color.BLACK);
			

			//Filler rectangles small
			Rectangle LB_2=new Rectangle (142, 177 ,5,5);
			LB_2.setStrokeWidth(1);
			LB_2.setStroke(Color.BLACK);
			LB_2.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle LB_3=new Rectangle (142, 164 ,5,5);
			LB_3.setStrokeWidth(1);
			LB_3.setStroke(Color.BLACK);
			LB_3.setFill(Color.BLACK);
			
			//Filler rectangles mid 12x22
			Rectangle LB_4=new Rectangle (148, 170 ,12,22);
			LB_4.setStrokeWidth(1);
			LB_4.setStroke(Color.BLACK);
			LB_4.setFill(Color.BLACK);
			
		
			//Filler rectangles small
			Rectangle LB_5=new Rectangle (148, 158 ,5,5);
			LB_5.setStrokeWidth(1);
			LB_5.setStroke(Color.BLACK);
			LB_5.setFill(Color.BLACK);
			
			//Filler rectangles small
			Rectangle LB_6=new Rectangle (142, 152 ,5,5);
			LB_6.setStrokeWidth(1);
			LB_6.setStroke(Color.BLACK);
			LB_6.setFill(Color.BLACK);
			
			
			Group root = new Group(LT_LSquare,LT_SSquare,TR_LSquare,TR_SSquare, LB_LSquare, LB_SSquare, BR_1, BR_2, BR_3, BR_4, BR_5, BR_6, BR_7, BR_8, BR_9, BR_10, BR_11, BR_12, BR_13, BR_14, BR_15, BR_16, BR_17, BR_18, BR_19, BR_20, BR_21, BR_22, MR_1, MR_2, MR_3, MR_4, MR_5, MR_6, ML_1, ML_2, ML_3, ML_4, ML_5, ML_6, ML_7, ML_8, ML_9, ML_10, ML_11, ML_12, ML_13, ML_14, ML_15, ML_16, ML_17, ML_18, ML_19, ML_20, ML_21, TL_1, TL_2, TL_3, TL_4, TL_5, TL_6, TL_7, TL_8, TL_9, TL_10, TL_11, TL_12, TL_13, TL_14, TL_15, TL_16, TL_17, TL_18, TL_19, TL_20, TL_21, TL_22, TL_23,tr1, tr2, tr3, tr4, tr5, tr6, tr7, tr8, tr9, tr10, tr11, tr12, tr13, tr14, tr15, tr16, tr17, tr18, tr19, tr20, tr21, tr22, tr23, tr24, tr25, tr26, tr27, LB_1, LB_2, LB_3, LB_4, LB_5, LB_6);
			Scene scene = new Scene(root,300, 250, Color.WHITE);
			primaryStage.setTitle("QR Code Generated");
			primaryStage.setScene(scene);
			primaryStage.show();
	
}
	public static void main(String[] args) {
		launch(args);
	}
}