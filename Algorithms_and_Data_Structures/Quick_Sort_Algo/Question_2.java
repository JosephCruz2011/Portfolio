//CPSC 50300 Assignment Week 8			
//Joe Cruz 	 
//Question 2
//
//This test program creates an array of size 20 populated with random values between 1 and 20, inclusive. The created array is shown to the 
//user and then the array is sorted using a partial implementation of the Quick-sort algorithm. This puts the values from the array into a LinkedQueue
//that is used for the quickSort implementation. The resulting sorted array is then shown to the user. 


import java.util.Random;

public class Question_2 {
	 //creates array of size 20.
	int data1[] = new int[20];
	
	//creates the LinkedQueue for the quicksort.
	Queue<Integer> data = new LinkedQueue<Integer>();
	
	//static reference of the comparator - used for comp.compare call
	static Sortcomp comp = new Sortcomp();
	public int compare(Integer arg0, Integer arg1) {
		 return arg0 - arg1;}
	
	//method to perform the Quick-sort algorithm on the LinkedQueue that has all the values of the created array.
	public static void quickSort(Queue<Integer> S) {
		    int n = S.size();
		    if (n < 2) return;                       // queue is trivially sorted
		    // divide
		    Integer pivot = S.first();                     // using first as arbitrary pivot
		    Queue<Integer> L = new LinkedQueue<>();
		    Queue<Integer> E = new LinkedQueue<>();
		    Queue<Integer> G = new LinkedQueue<>();
		    while (!S.isEmpty()) {                   // divide original into L, E, and G
		    	Integer element = S.dequeue();
		      int c = comp.compare(element, pivot);
		      if (c < 0)                             // element is less than pivot
		        L.enqueue(element);
		      else if (c == 0)                       // element is equal to pivot
		        E.enqueue(element);
		      else                                   // element is greater than pivot
		        G.enqueue(element);
		    }
		    // conquer
		    quickSort(L);                      // sort elements less than pivot
		    quickSort(G);                      // sort elements greater than pivot
		    // concatenate results
		    while (!L.isEmpty())
		      S.enqueue(L.dequeue());
		    while (!E.isEmpty())
		      S.enqueue(E.dequeue());
		    while (!G.isEmpty())
		      S.enqueue(G.dequeue());
	  }
	  
	////method to generate the random array values from 1 to 20, inclusive. This also puts the values from the array into the LinkedQueue in that order.
	//The LinkedQueue is used for the transition between the array and the required Queue. The values created in the array are shown to the user . 
	public void generate_array_values() {
		  Random r = new Random();
		  for(int i = 0; i<data1.length; i++) {
		  int value= r.nextInt(20-1)+1;
		  data1[i] = value;
		  data.enqueue(data1[i]);
		  }
		  System.out.println("Randomly generated array of size 20:");
		  System.out.print("[ ");
		  int si= data.size();
		  for (int z=0; z<si; z++) {
				  System.out.print(data1[z]+ " ");}
		  System.out.println("]");
	  }
	  
	//method to run the program. 
	  public void run_program() {
		  generate_array_values();
		  int si= data.size();
		  System.out.println("\nArray being sorted...\n");
		  quickSort(data);
		  System.out.println("Array sorted.\n\nSorted array: ");
		  System.out.print("[ ");
		  for (int z=0; z<si; z++) {
			  System.out.print(data.dequeue() + " ");
			  }
		  System.out.print("]");
	  }
	  
	public static void main(String[] args) {
		System.out.println("Hello.\n\nThis program is to meant to create an array with random values (1-20 inclusive) and show it to the user. The array is \nthen sorted using a partial implementation of the Quick-sort algorithm. The resulting sorted array is then presented \nto the user.\n\n");
		Question_2 sim = new Question_2();
		sim.run_program();
	}

}
