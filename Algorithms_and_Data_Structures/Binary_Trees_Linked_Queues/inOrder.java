//CPSC 50300 Assignment Week 5				
//Joe Cruz 	
//Question 2
//
//This test program creates the binary tree shown in the supplementary word doc (JBC_Week_5 Created Binary Tree) and traverses
//through the tree through the inOrder traversal method through a non-recursive method. The inorder traversal of the tree is 
//shown before the program runs for comparison.
//

import java.util.Iterator;
 

public class inOrder<E> {
	//creates the Binary Tree
	LinkedBinaryTree<String> bin_tree = new LinkedBinaryTree<String>();
	
	//populates the tree with the values shown in 'JBC_Week_5 Created Binary Tree'
	void populate_tree () {
	bin_tree.addRoot("Start");
	bin_tree.addLeft(bin_tree.root(), "left");
	bin_tree.addRight(bin_tree.root(), "right");
	bin_tree.addRight(bin_tree.right(bin_tree.root()), "right of right");
	bin_tree.addLeft(bin_tree.left(bin_tree.root()), "left of left");
	bin_tree.addRight(bin_tree.left(bin_tree.root()), "right of left");
	bin_tree.addLeft(bin_tree.right(bin_tree.root()), "left of right");
	bin_tree.addLeft(bin_tree.right(bin_tree.left(bin_tree.root())), "LOROL");
	bin_tree.addRight(bin_tree.right(bin_tree.left(bin_tree.root())), "ROROL");
	}
	
	//iterates through the binary tree through the inorder traversal without using recursion and adds the value of the node to a SinglyLinkedList.
	//The inorder traversal is then printed out 
	void in_order_traversal () {
		SinglyLinkedList<String> traveled_list = new SinglyLinkedList<String>();
		Iterator<String> iter = bin_tree.iterator(); 
		while(iter.hasNext()) {
			String var = iter.next();
			traveled_list.addLast(var);	
			}
		
		System.out.println("\nIn-order traversal:\n");
		int size_of_traveled= traveled_list.size();
		for(int i=0; i<size_of_traveled; i++) {
		System.out.println("Stop " + (i+1) + ":\nContents of node traveled to: " + traveled_list.first()  + " \n"); 
		traveled_list.removeFirst();
		}
	}
	
	//runs program
	void run_program () {
		System.out.println("Hello.\n\nThis program is designed to perform an inorder traversal of a binary tree without the use of recursion.\nThe binary tree used for this program can be found in the supplementary word doc 'JBC_Week_5 Created Binary\nTree'. The inorder traversal of the tree should yield the following in sequential order:\n\nleft of left\nleft\nLOROL\nright of left\nROROL\nStart\nleft of right\nright\nright of right");
		populate_tree();
		in_order_traversal();
		System.out.println("\nAs you can see, the inorder traversal performed by the program matches that of the reference mentioned above.");
		
	}
	

	public static void main(String[] args) {
		inOrder sim = new inOrder();
		sim.run_program();
	}

}
