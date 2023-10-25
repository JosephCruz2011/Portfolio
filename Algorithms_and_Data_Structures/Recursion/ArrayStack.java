//CPSC 50300 Assignment Week 3				
//Joe Cruz 
//Part_1A	
//Question 3
//
//This portion of the program is to establish the ArrayStack class that is used for creating and manipulating the stack array. 

public class ArrayStack<O> implements Stack<O> {
	
	  //establishes the default array capacity
	  public static final int CAPACITY = 1000;
	  //creates an array
	  private O[] data; 
	  
	  //sets the variable to the index of the top element in the stack. 
	  private int top = -1;                       
	  
	  //stack is created utilizing the default array capacity
	  public ArrayStack(){
		  this (CAPACITY);}     
	  
	  //constructs the stack with the given entry
	  public ArrayStack(int capacity){           
		  data = (O[]) new Object[capacity];}
	  
	  //returns the size of the stack
	  public int size() {
		  return top+1;}
	  
	  //returns boolean for whether the stack is empty or not
	  public boolean isEmpty() {
		  return top==-1;}
	  
	  //push command that throws an exception when stack is full (where size equals the capacity of the created array)
	  //push adds an element to the stack utilizing the LIFO technique
	  public void push (O o) throws IllegalStateException {
		  if (size() == data.length) {throw new IllegalStateException ("Stack is full.");}
		  data[++top] = o;}
	  
	  //returns the element that is at the top of the stack
	  public O top() {
		  if (isEmpty()) return null;
		  return data[top];}
	  
	  //removes the element that is at the top of the stack (LIFO)
	  //the element being removed is returned. 
	  public O pop() {
		  if (isEmpty()) return null;
	      	O removed = data[top];
	      	data[top] = null;
	      	top --;
	      	return removed;}
  }

