//CPSC 50300 Assignment Week 2				
//Joe Cruz 
//Part_3A
//Question 3
//
//This establishes the class Node that will be used for the creation of the Doubly
//Linked List nodes. 

class Node {
	
	int data;
	Node next, prev;
	Node(int val) {
		
		data = val;
		next = null;
		prev = null;
	}
}