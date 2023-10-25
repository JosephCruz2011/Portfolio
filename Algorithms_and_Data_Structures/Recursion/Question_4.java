//CPSC 50300 Assignment Week 3				
//Joe Cruz 
//Part_1	
//Question 4
//
//This program is designed to implement a queue and demonstrate the 
//rotate method, which takes the first element of the queue and places it in the
//end of the queue. 

public class Question_4 {

	public static void main(String[] args) {
		
		//Initializes an integer queue 
		Queue<Integer> S = new ArrayQueue<>();  
		
		//adds the elements 5, 3, and 2 to the queue in that order
	    S.enqueue(5);                           
	    S.enqueue(3); 
	    S.enqueue(2);
	    System.out.println("The elements added to the queue are as follows in this order: \n5, 3, 2\n");
	    
	    //the first element of the queue is printed out along with the current size of the queue
	    System.out.println("First element: " +  S.first());
	    
	    //the current size of the queue is printed out
	    System.out.println("Current size: " + S.size()); 
	    
	    //the queue is rotated so that the current first element is moved to the back of the queue
	    S.rotate();
	    System.out.println("\nRotation occuring\n");
	    
	    //the first element of the queue is printed out along with the current size of the queue
	    System.out.println("First element: " +  S.first());
	    System.out.println("Current size: " + S.size()); 
	    
	    //the queue is rotated so that the current first element is moved to the back of the queue
	    S.rotate();
	    System.out.println("\nRotation occuring\n");
	    
	    //the first element of the queue is printed out along with the current size of the queue
	    System.out.println("First element: " +  S.first());
	    System.out.println("Current size: " + S.size()); 
	    
	    //the queue is emptied and each element leaving the queue is printed out to display the order
	    //the queue was in. Since queues are FIFO (First in-First out) then we can assume that the 
	    //order in which the queue is deuqued is the order that the queue was in at the time. 
	    System.out.println("\nEmptying Queue\n");
	    System.out.println("Dequeued: " + S.dequeue());      
	    System.out.println("Dequeued: " + S.dequeue());
	    System.out.println("Dequeued: " + S.dequeue());
	    
	    //status of queue being emptied is checked. 
	    System.out.println("Empty Status: " + S.isEmpty());   
	    
	    System.out.println("\nThe queue order has been changed twice due to rotations and now\nthe order is 2, 5, 3. The original order was 5,3,2 thus we can see\nthat there was a total of two rotations performed on the original queue.\n(5,3,2 --> 3,2,5 --> 2,5,3)");
	
}
}

