//CPSC 50300 Assignment Week 3				
//Joe Cruz 
//	
//Question 1
//
//This program is designed to input two positive integers and output the product between them. The program utilizes a recursive method
//of addition to simulate the multiplication of the integers. The base case for the recursion returns the value of n when m is equal to 1 and
//the general case returns n+ the recursive call(n, m-1).


import java.util.Scanner;

public class Question_1 {
	private int n_value;
	private int m_value;
	
	//value of n is obtained from the user
	private void get_n() {
		System.out.print("Input the value of n: \n");
		Scanner scan1 = new Scanner(System.in);
		n_value = scan1.nextInt();
		}
	
	//value of m is obtained from the user
	private void get_m(){
		System.out.print("Input the value of m: \n");
		Scanner scan2 = new Scanner(System.in);
		m_value = scan2.nextInt();
		}
	
	//recursive method to compute the product between n and m 
	private int product(int n, int m) {
		
		if (m==1) {
			return n; }
		else {
			return n + product(n, m-1);
		}
		}
	//method runs program and returns the product between n and m. throws exception if either of the values are less than or equal to 0.
	private void run_program() throws NotPositiveException {
		get_n();
		get_m();
		NotPositiveException alert= new NotPositiveException("Input values must be positive integers");
		if (n_value <= 0 || m_value <=0) {
			throw alert;}
		System.out.print(product(n_value, m_value));
		
	}
	
	public static void main(String[] args)throws NotPositiveException {
		Question_1 sim = new Question_1();
		sim.run_program();
	}
}
