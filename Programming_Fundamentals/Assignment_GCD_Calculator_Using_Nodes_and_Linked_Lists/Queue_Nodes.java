///Week 7 Assignment 						Author: Joe Cruz
///Part_3	Queue_Nodes class.
///
///This program is meant to calculate the greatest common divisor between two positive integers. 
///
///This portion of the program is meant to create the nodes for the linked list that the input values are going into.
///The class has a series of methods including an insertion method(enqueue), a deletion method (dequeue), and an element retrieval method(get_Elements_of_nodes

public class Queue_Nodes {
	//sets the variables for the front and end nodes of the linked list to initialize the linked list nodes.Initiates a size variable as well 
	public Node head= null;
	public Node tail = null;
	public int size = 0;

	//class for the node
	class Node{
		String input_data;
		Node next;
	
	//method that puts the data put into the method into a node.
	public Node(String data) {
		this.input_data = data;
		this.next = null;
	}
	}
	

	//method to actually put the data into the node via class instantiation
	public void enqueue(String data) {
		Node newNode=new Node(data);
		
		if(head== null) {
			head= newNode;
			tail= newNode;
		}
		else 
			tail.next= newNode;
			tail =newNode;
		size++;
		}
	
	//displays the nodes for the linked list. Can also return whether the list is empty or not. 
	public void display() {
		Node current = head;
		if(head == null) {
			System.out.println("The list is empty");
			return;
		}
		System.out.println("Adding nodes to the end of the list: ");
		while (current != null) {
			System.out.print(current.input_data + " ");
			current = current.next;
		}
		System.out.println();
		}
	
	//method to delete nodes from the linked list. can throw an exception for when there is nothing in the linked list to delete. 
	public void dequeue() throws GDC_Exception{
		
		GDC_Exception alert3 = new GDC_Exception("Queue underflow");
		
		if (head==null) {
			throw alert3;}
		head = head.next;
		
		if (size()==0) {
			tail = null;
		}
		size--;
	}
	
	//method to return the size of the linked list.
	public int size() {
		return size;
	}
	
	//method to obtain that elements that are in the nodes of the linked list. 
	public String[] get_Elements_of_nodes() {
		String[]Elements;
		Node iter = head;
		int i=0;
		Elements = new String[size()];
		iter = head;
		while(iter !=null) {
			Elements[i]=iter.input_data;
			i++;
			iter=iter.next;
		}
			return Elements;}
	} 
	