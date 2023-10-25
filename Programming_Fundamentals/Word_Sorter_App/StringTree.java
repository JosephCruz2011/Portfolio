// Week 8 Assignment Word Sorting			Author: Joe Cruz
//08Mar2020
//Part 4_StringTree Class
//
//This code is meant to take in either manual input user words or a file of words and sort them.
//This portion of the code houses the StringTree class, which is responsible for code to actually create the binary tree. 


public class StringTree {
	//instantiated variable
	 Node node; 
	 
	 //for class instantiation 
	 StringTree(String value) {
		  node = new Node(value);
	  }
	  
	 //method to add node to the binary tree from a new word to sort. basically, if in a node that has no value creates a node, if in a node with a value
	 //it determines if it is lower or higher value compared to the node and eventually places the node where it fits in the tree.
	  public Node insert_Word_node(Node node, String newWord) {
	    	newWord=newWord.toLowerCase();
		  	if (node ==null) {
	    		node = new Node(newWord);
	    		return node; }
	
	    	if (newWord.equals(node.value)) {
	    		return node;}
	    		
	    	if (newWord.compareTo(node.value) < 0) {
	    		if (node.left == null) { 
	    			node.left = new Node(newWord);
	    			return node;}
	    		else {
	    			insert_Word_node(node.left, newWord);} }
	    	else {	
	    		if (node.right ==null) {
	    			node.right =new Node(newWord);
	    			return node; }
	    		else {
	    			insert_Word_node(node.right, newWord);}
	    			}
	    	return node;
	}
	  
	    //traverses the binary tree (used for printing out to the console).
	    public void Trav_order(Node node) {
	    	if (node !=null) {
	    		Trav_order(node.left);
	    		System.out.println(node.value + " ");
	    		Trav_order(node.right);} 
	    	}
}

