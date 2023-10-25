//CPSC 50300 Assignment Week 3				
//Joe Cruz 
//Part_1B	
//Question 4
//
//This portion of the program is to establish the Queue interface for the ArrayQueue class that is used for creating and manipulating the queue array. 

public interface Queue <Z> {
	  int size();
	  boolean isEmpty();
	  void enqueue(Z z);
	  Z first();
	  Z dequeue();
	  
	  //rotate method required for question 4.
	  Z rotate();
	}

