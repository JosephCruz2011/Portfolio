///Week 7 Assignment 						Author: Joe Cruz
///Part_5	ABC_test_program
///
///This program is meant to store the alphabet using the linked list queue from Queue_Nodes.


public class ABC_test_program {
	Queue_Nodes sList=new Queue_Nodes();
	
	private void Enqueue () {	
		sList.enqueue("a");
		sList.enqueue("b");
		sList.enqueue("c");
		sList.enqueue("d");
		sList.enqueue("e");
		sList.enqueue("f");
		sList.enqueue("g");
		sList.enqueue("h");
		sList.enqueue("i");
		sList.enqueue("j");
		sList.enqueue("k");
		sList.enqueue("l");
		sList.enqueue("m");
		sList.enqueue("n");
		sList.enqueue("o");
		sList.enqueue("p");
		sList.enqueue("q");
		sList.enqueue("r");
		sList.enqueue("s");
		sList.enqueue("t");
		sList.enqueue("u");
		sList.enqueue("v");
		sList.enqueue("w");
		sList.enqueue("x");
		sList.enqueue("y");
		sList.enqueue("z");

	}
	
	private void display_Linked_list() {
		sList.display();
	}
	
	
	
	
	public static void main(String[] args) {
		 ABC_test_program test = new ABC_test_program();
		 test.Enqueue();
		 test.display_Linked_list();
		 
		
	}

}