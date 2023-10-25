//CPSC 50300 Assignment Week 8			
//Joe Cruz 	
//Question 1 
//
//This test program creates an array of size 20 populated with random values between 1 and 20, inclusive. The created array is shown to the 
//user and then the array is sorted using a partial implementation of the Merge-sort algorithm. The resulting sorted array is then shown
//to the user. 
//
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Question_1 implements Comparator<Integer>{
	 //creates array of size 20.
	 int data[] = new int[20];
	 
	 //static reference of the comparator - used for comp.compare call
	 static Sortcomp comp = new Sortcomp();
	 
	 public int compare(Integer arg0, Integer arg1) {
		 return arg0 - arg1;}
	 
	 //method to merge the resulting sorted arrays for the merge-sort algorithm
	 public static void merge(int[] S1, int[] S2, int[] S) {
		    int i = 0, j = 0;
		    while (i + j < S.length) {
		      if (j == S2.length || (i < S1.length && comp.compare(S1[i], S2[j]) < 0)) {
		    	   S[i+j] = S1[i++];     }                // copy ith element of S1 and increment i
		      else {
		
		        S[i+j] = S2[j++];                     // copy jth element of S2 and increment j
		    }}
		}
	 
	 //recursive method to sort the array (calls to merge to merge back into final sorted array)
	 public static  void mergeSort(int[] S) {
		    int n = S.length;
		    if (n < 2) return;                        // array is trivially sorted
		    // divide
		    int mid = n/2;
		    int[] S1 = Arrays.copyOfRange(S, 0, mid);   // copy of first half
		    int[] S2 = Arrays.copyOfRange(S, mid, n);   // copy of second half
		    // conquer (with recursion)
		    mergeSort(S1);                      // sort copy of first half
		    mergeSort(S2);                      // sort copy of second half
		    // merge results
		    merge(S1, S2, S);               // merge sorted halves back into original
		  }

	
	 //method to generate the random array values from 1 to 20 inclusive.
	 public void generate_array_values() {
			  Random r = new Random();
			  System.out.println("Randomly generated array of size 20:");
			  System.out.print("[ ");
			  for(int i = 0; i<data.length; i++) {
			  int value= r.nextInt(20-1)+1;
			  data[i] = value;
			  System.out.print(data[i]+ " ");}
			  System.out.println("]");
		  }
	 
	 //method to run the program
	 public void run_program() {
			  generate_array_values();
			  System.out.println("\nArray being sorted...\n");
			  mergeSort(data);
			  System.out.println("Array sorted.\n\nSorted array: ");
			  System.out.print("[ ");
			  for (int z=0; z<data.length; z++) {
				  System.out.print(data[z]+ " ");}
			  System.out.print("]");
		  }
		  
	public static void main(String[] args) {
		System.out.println("Hello.\n\nThis program is to meant to create an array with random values (1-20 inclusive) and show it to the user. The array is \nthen sorted using a partial implementation of the Merge-sort algorithm. The resulting sorted array is then presented \nto the user.\n\n");
		Question_1 sim = new Question_1();
		sim.run_program();

	}



	}