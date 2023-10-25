//CPSC 50300 Assignment Week 6			
//Joe Cruz 	
//Question 1
// 
//This program is designed perform the selection-sort scheme outlined in question 1 of the assignment for Week 6. 
//Elements of a sequence S, (generated in the order of 7,4,8,2,5,3,9) are transferred from the sequence to a 
//priority queue. The elements are then returned sorted in numerical order (2,3,4,5,7,8,9) into the original 
//sequence. 

import java.util.Iterator;
import java.util.PriorityQueue;


public class Question_1 {

	PositionalList<Integer> S = new LinkedPositionalList<Integer>();
	PriorityQueue<Integer> P = new PriorityQueue(); 
	
	//generates Sequence S
	void generate_sequence () {
		System.out.println("Sequence to sort: ");
		S.addLast(7);
		S.addLast(4);
		S.addLast(8);
		S.addLast(2);
		S.addLast(5);
		S.addLast(3);
		S.addLast(9);
		
		//prints out the current sequence
		System.out.println(S.toString());
		
		//prints out the size of sequence S, the size of the priority queue and whether the priority queue is empty
		System.out.println("\nSize of sequence S: " + S.size());
		System.out.println("Size of priority queue P: " + P.size());
		System.out.println("Priority Queue empty: " + P.isEmpty()+"\n");
	}
	
	//moves elements from sequence S to the priority queue. 
	void move_to_priorityQueue() {
		Iterator<Integer> iter= S.iterator();
		while(iter.hasNext()) {
			P.add(S.first().getElement());
			System.out.println("Element transfering to priority queue: " + S.first().getElement());
			S.remove(S.first());
			iter= S.iterator();}
		System.out.println("Transfer complete.");
		
		//prints out the size of sequence S, the size of the priority queue and whether the priority queue is empty
		System.out.println("\nSize of sequence S: " + S.size());
		System.out.println("Size of priority queue P: " + P.size());
		System.out.println("Priority Queue empty: " + P.isEmpty()+"\n");
		}
	
	//transfers the sequence back to S in a sorted fashion (numerical with minimum in the front and max in the back)
	void sortandreturn() {
		System.out.println("Sorting sequence.");
		int size_=P.size();
		for(int i=0; i<size_;i++) {
			S.addLast((int)P.poll());
		 
		}
		System.out.println("\nSorting complete.");
		
		//prints out the size of sequence S, the size of the priority queue and whether the priority queue is empty
		System.out.println("\nSize of sequence S: " + S.size());
		System.out.println("Size of priority queue P: " + P.size());
		System.out.println("Priority Queue empty: " + P.isEmpty());
		
		//prints out the current sequence S
		System.out.println("\nSorted Sequence:\n" + S.toString());
	}
	
	//runs the program
	void run_program() {
		System.out.println("Hello.\n\nThis program is designed to perform the selection-sort scheme outlined in question 1 of the assignment for Week 6.\nElements of a sequence S, (generated in the order of 7,4,8,2,5,3,9) are transferred from the sequence to a \npriority queue. The elements are then returned sorted in numerical order (2,3,4,5,7,8,9) into the original\nsequence\n\n");
		generate_sequence ();
		move_to_priorityQueue();
		sortandreturn();
	}


	public static void main(String[] args) {
		Question_1 sim = new Question_1();
		sim.run_program();
		
	}

}
