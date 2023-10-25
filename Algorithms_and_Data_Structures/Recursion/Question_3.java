//CPSC 50300 Assignment Week 3				
//Joe Cruz 
//Part_1	
//Question 3
//
//This program is designed to implement two stack arrays and transfer the contents
//of the first stack to the second stack. The elements that were at the beginning
//of the first stack will then be at the top of the second stack and the elements at
//the top of the first stack will be at the bottom of the second stack. 

public class Question_3 {
	//Initializes two integer Stacks
	Stack<Integer> Stack1 = new ArrayStack<>();  
	Stack<Integer> Stack2 = new ArrayStack<>();  
	int Size;
	
	//method to fill the first stack. 
	public void fill_stack1 ( ) {
		System.out.println("Creating Stack1 entries\n" );
		for(int i =1; i<=10;i++) {
			Stack1.push(i);
			System.out.println("Top of Stack1: " + Stack1.top());}
		Size= Stack1.size();}
	
	//method to transfer elements from Stack1 into Stack2. This will transfer the top values of Stack1 into Stack2 until the stack is empty.
	public void transfer(Stack<Integer> S, Stack<Integer> T) {
			T.push(S.pop());
			System.out.println("Top of Stack2: " + T.top());}
	
	//run method to perform the filling of Stack1 with elements and the transfer of them to
	//Stack2. Further print statements are made to show the status of the size
	//of each stack, the top of stack 1 when creating and top of stack 2 when transferring
	//and the empty status of each stack.
	public void run_program() {
		
		//Stack1 will consist of the numbers 1-10 where 1 is at the bottom of the stack
		//and 10 is at the top of the stack. Stack2 is an empty stack for the moment. 
		fill_stack1();
		
		//Empty status and size of the stacks are checked.
		System.out.println("\nEmpty status of Stack1: " + Stack1.isEmpty());
		System.out.println("Empty status of Stack2: " + Stack2.isEmpty());
		System.out.println("Current size of Stack1: " + Stack1.size());
		System.out.println("Current size of Stack2: " +Stack2.size());
		
		System.out.println("\nTransfering to new stack\n");
		
		//Now Stack2 will have the value 10-1 where 10 is at the bottom of the stack and 1 is at the top of the stack. 
		for (int i = 0; i < Size;i++) {
			transfer(Stack1,Stack2);}	
		
		//Empty status and size of the stacks are checked.
		System.out.println("\nEmpty status of Stack1: " + Stack1.isEmpty());
		System.out.println("Empty status of Stack2: " + Stack2.isEmpty());
		System.out.println("Current size of Stack1: " + Stack1.size());
		System.out.println("Current size of Stack2: " +Stack2.size());}
	
	public static void main(String[] args) {
		Question_3 sim = new Question_3();
		sim.run_program();
		
		System.out.println("\nWe now see that the transfer method successfully transfered the contents of Stack1\nto Stack 2 so that the elements are in reverse order. In other words, the top of \nStack1 is now the bottom of Stack 2 and the bottom of Stack1 is now on the top of \nStack2.");
	}

}
