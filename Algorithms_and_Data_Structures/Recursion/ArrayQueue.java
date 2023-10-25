//CPSC 50300 Assignment Week 3				
//Joe Cruz 
//Part_1A	
//Question 4
//
//This portion of the program is to establish the ArrayQueue class that is used for creating and manipulating the queue array. 


public class ArrayQueue<Z> implements Queue<Z> {
  //creates the default array capacity
  public static final int CAPACITY = 1000;      
  
  //creates an array 
  private Z[] data;                            
  
  //variable initialized to represent the front element's index and the size of the queue(current quantity of elements in the queue)
  private int front = 0;          
  private int siz = 0;                           
  
  //queue is created utilizing the default capacity
  public ArrayQueue() {this(CAPACITY);}       
  
  //queue created with the given capacity
  public ArrayQueue(int capacity) {   
    data = (Z[]) new Object[capacity];}
  
  //size method that returns the size of the queue
  public int size() { 
	  return siz; }
  
  //method to return boolean as to whether the queue is empty or not
  public boolean isEmpty() { 
	  return (siz == 0); }
  
  //method to place an element into the queue. An exception is thrown when the queue is full and no more elements can be added.
  public void enqueue(Z z) throws IllegalStateException {
    if (siz == data.length) throw new IllegalStateException("Queue is full");
    int avail = (front + siz) % data.length;   
    data[avail] = z;
    siz++;
  }
  
  //method to return the first element in the queue
  public Z first() {
    if (isEmpty()) return null;
    return data[front];
  }
  
  //method to remove the first element from the queue (FIFO First-in, First-out)
  public Z dequeue() {
    if (isEmpty()) return null;
    Z answer = data[front];
    data[front] = null;                           
    front = (front + 1) % data.length;
    siz--;
    return answer;}

  
//rotate method that takes first element of the current queue and moves it to the back of the queue
//for instance for a queue array 3,4,5 the rotate method will change the queue array to 4,5,3.
public Z rotate() throws IllegalStateException{
	
	if (isEmpty()) return null;
    Z to_move = data[front];
    data[front] = null;                             
    front = (front + 1) % data.length;
    siz--;
	if (siz == data.length) throw new IllegalStateException("Queue is full");
    int avail = (front + siz) % data.length;   
    data[avail] = to_move;
    siz++;
	
	return to_move;}
}