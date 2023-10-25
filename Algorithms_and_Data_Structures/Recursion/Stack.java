//CPSC 50300 Assignment Week 3				
//Joe Cruz 
//Part_1B	
//Question 3
//
//This portion of the program is to establish the Stack interface for the Stack class that is used for creating and manipulating the stack array. 

public interface Stack <O> {
 	int size();
	boolean isEmpty();
	void push(O o);
	O top();
	O pop();
}

