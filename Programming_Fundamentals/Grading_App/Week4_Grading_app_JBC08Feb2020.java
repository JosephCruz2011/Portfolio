//Week 4 Assignment                     Author: Joe Cruz
//
//
//Grading application that will ask for user input on how many students in class, give the ability to put in assignment and exam grades (with a max of 75 and 50 pts respectively),
//calculate the class average and standard deviation of the input data set, and determine whether or not to implement a curve 
//dependent upon how the class does as a whole. The end result will print off the grading scale being used and the student number with their letter grade and their point total.

import java.util.Scanner;
import java.util.ArrayList;

public class Week4_Grading_app_JBC08Feb2020 {

	public static void main(String[] args) {
		
		//Initiating array lists to hold the input exam scores, assignment scores, student total scores, and the students' determined letter grades.
		ArrayList<Integer> Exam_Scores = new ArrayList<Integer>();
		ArrayList<Integer> Assign_Scores = new ArrayList<Integer>();
		ArrayList<Integer> StudentScores = new ArrayList<Integer>();
		ArrayList<String> StudentGrades = new ArrayList<String>();
		
		//Welcomes user to the app
		System.out.println("Welcome to the Grade Generator.\nLet's start off with how many students' grades need to be calculated.\n");
		
		//allows user to input number of students so the following methods know how many students' grades will be calculated.
		int Student_count=student_number_input();		
		
		//Loops through number of students to be graded and prints identifier, allows entry of student exam and assignment scores, calculates student total scores and adds them to the student_scores arraylist.
		//list is cleared for entry of next student.
		for (int i=0; i<Student_count; i++) {
			System.out.println("Student "+ (i+1) + ":\n");
			System.out.println("Please input Exam Scores\n");
			Score_list_creationE(Exam_Scores);
		
			System.out.println("Please input Assignment Scores\n");
			Score_list_creationA(Assign_Scores);
				
			int Total= Student_total_score(Exam_Scores, Assign_Scores);
			StudentScores.add(Total);
			
			Exam_Scores.clear();
			Assign_Scores.clear();}
		
		
		//Initiates variable to hold collective points as a class to get the input data set. 
		int Student_total=0;
		for(int i =0; i<StudentScores.size(); i++) {
			int Student_Score = StudentScores.get(i);
			Student_total +=Student_Score;}
		
		//Calculates the average
		double Class_Average= (double)Student_total / (double)StudentScores.size();
		
		//Calculates the standard deviation
		double summation=0.00;
		for(int i=0; i<StudentScores.size(); i++) {
			double value = (double) StudentScores.get(i);
			double value2 = value-Class_Average;
			double squared = Math.pow(value2, 2);
			summation +=squared;}
		double Value_toSquare_root= summation /(double)StudentScores.size();
		double StdDev= Math.sqrt(Value_toSquare_root);
		
		//Prints out the class average and the standard deviation.
		System.out.println("\nClass Average: " + Class_Average);
		System.out.println("Stdv: "+ StdDev+ "\n");
		
		//Decision point for the program to determine whether or not the class should get a curve. 
		//Condition is whether or not the class average is above the minimum for a C.
		if(Class_Average > 350) {	
			Grad_Calc_noCurve(StudentGrades,StudentScores);
			Grade_Print_out(StudentGrades,StudentScores);}
		else {
			Grad_Calc_Curve(StudentGrades, StudentScores , Class_Average, StdDev);
			Grade_Print_out(StudentGrades,StudentScores);}
	}

	//allows user input to tell how many students are in the class.
	private static int student_number_input() {
		Scanner scan1 = new Scanner(System.in);
		System.out.println("Total Students in Class:\n");
		int count = scan1.nextInt();
		return count;
	}
	//allows user input to put in scores (used for both assignment scores and exam scores).
	private static int input_scores() {
		Scanner scan2 = new Scanner(System.in);
		int score = scan2.nextInt();
					
		return score;
	}	
	
	//allows user to input scores for 4 exams with an absolute max score of 50 pts. The scores are then added to an exam score list
	private static void Score_list_creationE(ArrayList<Integer> Score_list) {
		for (int i=0; i<4; i++) {
			System.out.println("Exam Score " + (i + 1) + ":");
			int score=input_scores();
			while (score>50) {
				System.out.println("Score above maximum possible, please re-enter score");
				score=input_scores();}
			
			Score_list.add(score);}
	}
	//allows user to input scores for 4 assignments with an absolute max score of 75 pts. The scores are then added to an assignment score list
	private static void Score_list_creationA(ArrayList<Integer> Score_list) {
		for (int i=0; i<4; i++) {
			System.out.println("Assignment Score " + (i + 1) + ":");
			int score=input_scores();
			while (score>75) {
				System.out.println("Score above maximum possible, please re-enter score");
				score=input_scores();}
			
			Score_list.add(score);}
	}
	//method calculates student's total point score based off the four assignment and four exam scores.
	private static int Student_total_score(ArrayList<Integer> Exam_Score_list, ArrayList<Integer> Assign_Score_list) {
		int Student_total = 0;
		for (int i=0; i<Exam_Score_list.size();i++) {
			int score_E = Exam_Score_list.get(i);
			Student_total += score_E;
			}
		for (int i=0; i<Assign_Score_list.size(); i++) {
			int score_A = Assign_Score_list.get(i);
			Student_total += score_A;
			}
		return Student_total;	
	}
	
	//prints out the grading scale and determines what letter grades each student gets based on their scores. 
	private static void Grad_Calc_noCurve (ArrayList<String> Grades, ArrayList<Integer> Scores) {
		System.out.println("Grading Scale:");
		System.out.println("A >= 450");
		System.out.println("B >= 400");
		System.out.println("C >= 350");
		System.out.println("D >= 300");
		System.out.println("F < 300\n");
		
		for (int i=0; i<Scores.size();i++) {
			int Score= Scores.get(i);
			String Grade= "";
			
			if (Score >=450) {
				Grade = "A";}
			if (Score >=400 && Score <450) {
				Grade = "B";}
			if (Score >=350 && Score <400) {
				Grade = "C";}
			if (Score >= 300 && Score <350) {
				Grade = "D";}
			if (Score <300) {
				Grade = "F";}
			Grades.add(Grade);
			}
	
		}
	
	//creates a curved grading scale and prints it out. Also determines what letter grades each student gets based on their scores according to the curve. 
	private static void Grad_Calc_Curve (ArrayList<String> Grades, ArrayList<Integer> Scores, double Average, double Standard_Dev) {
		double A= Math.round(Average + (Standard_Dev));
		double B= Math.round(Average) ;
		double C= Math.round(Average - (Standard_Dev));
		double D= Math.round(Average - (2 * Standard_Dev));

		System.out.println("Curve implemented.\nGrading scale recalculated based off the average:\n");
		System.out.println("A >= " + A);
		System.out.println("B >= " + B);
		System.out.println("C >= " + C);
		System.out.println("D >= " + D);
		System.out.println("F < " + D +"\n");
		
		for (int i=0; i<Scores.size();i++) {
			int Score= Scores.get(i);
			String Grade= "";
			if (Score >=A) {
				Grade = "A";}
			if (Score >=B && Score <A) {
				Grade = "B";}
			if (Score >=C && Score <B) {
				Grade = "C";}
			if (Score >= D && Score <C) {
				Grade = "D";}
			if (Score < D) {
				Grade = "F";}
			Grades.add(Grade);}
	}
	
	//Prints out the students identifier (ie. Student 1), letter grade, and total points.
	private static void Grade_Print_out (ArrayList<String> Grades, ArrayList<Integer> StudentScores) {
		for (int i=0; i<Grades.size();i++) {
			String grade= Grades.get(i);
			int student_total= StudentScores.get(i);
			System.out.println("Student " + (i+1) + ": " + grade + " (" + student_total+" points)");
		}
	}
	
	
	}

