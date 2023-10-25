//CPSC 50300 Assignment Week 2				
//Joe Cruz 	
//Question 3
//
//This program is designed to create a DoublyLinked List and return the size
//of the Doubly Linked List created. 

public class DoublyLinkedList {

	//method to create the actual node within the Doubly Linked List.
	public static Node move(Node head, int data) 
	{
		Node new_node = new Node(data);
		new_node.next = head;
		new_node.prev = null;
		if (head !=null) {
			head.prev=new_node;}
		head = new_node;
		return head;
		}
	
	//method to capture the size of the established Doubly Linked List
	//by counting the nodes. 
	public static int size(Node node) {
		int size_of_Double_Linked= 0;
		while (node != null) {
			size_of_Double_Linked +=1;
			node =node.next;
		}
		return size_of_Double_Linked;
	}


public static void main(String[] args) {
	//creates the Doubly Linked List
	Node head= null;
	
	//creates a Node containing the value 35
	head = move(head, 35);
	
	//creates a Node containing the value 22
	head = move(head, 22);
	
	//creates a Node containing the value 78
	head = move(head, 78);
	
	//creates a Node containing the value 1
	head = move(head, 1);
	
	//Obtains the size of the created Doubly Linked list and prints out. 
	System.out.print("The size of the Doubly Linked List is " + size(head)+".");
	
}

	
}
