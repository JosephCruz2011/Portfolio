//CPSC 50300 Assignment Week 5				
//Joe Cruz 	
//Question 1
// 
//This program is designed to display the preorderNext, inorderNext, and postorderNext methods functionality utilizing the binary 
//tree shown in the supplementary word doc 'JBC_Week_5 Created Binary Tree'. These methods were added in the AbstractTree class 
//and are implemented in this test program. In each of these methods, an input position is utilized to determine the position 
//visited after the input position in its respective traversal method. For instance, with the preorderNext method, the input 
//position will determine the next position that is visited using the preorder traversal method, and etc. That next position is 
//then returned as well as the contents of said position. The preorderseq, inorderseq, and postorderseq methods act as a reference of
//how the traversal methods would be with the aforementioned binary tree. These methods are purely for comparison of the Next methods
//to confirm that the programs are working properly. THE BOTTOM COMMENTS ADDRESS PART D OF THE QUESTION 1.


public class Traversals {
	LinkedBinaryTree<String> T = new LinkedBinaryTree<String>();
	
	//populates the tree with the values shown in 'JBC_Week_5 Created Binary Tree'
	void populate_tree () {
		T.addRoot("Start");
		T.addLeft(T.root(), "left");
		T.addRight(T.root(), "right");
		T.addRight(T.right(T.root()), "right of right");
		T.addLeft(T.left(T.root()), "left of left");
		T.addRight(T.left(T.root()), "right of left");
		T.addLeft(T.right(T.root()), "left of right");
		T.addLeft(T.right(T.left(T.root())), "LOROL");
		T.addRight(T.right(T.left(T.root())), "ROROL");
	}
	
	//performs a preorder traversal of the binary tree and prints out the traversal for reference.
	void preorderseq()	 {			
		for (Position element: T.preorder()) {
			String var = (String) element.getElement();
			System.out.println(var);}
	}
	
	//performs an inorder traversal of the binary tree and prints out the traversal for reference
	void inorderseq() {
		for (Position element: T.positions()) {
			String var = (String) element.getElement();
			System.out.println(var);}
	}
	
	//performs a postorder traversal of the binary tree and prints out the traversal for reference
	void postorderseq() {
		for (Position element: T.postorder()) {
			String var = (String) element.getElement();
			System.out.println(var);}
	}
	
	//runs the program
	void run_program() {
		System.out.println("Hello. \n\nThis program is designed to display the preorderNext, inorderNext, and postorderNext methods functionality utilizing \nthe binary tree shown in the supplementary word doc 'JBC_Week_5 Created Binary Tree'. In each of these methods, an input \nposition is utilized to determine the position visited after the input position in its respective traversal method. For\ninstance, with the preorderNext method, the input position will determine the next position that is visited using \nthe preorder traversal method. That next position is then returned as well as the contents of said position.");
		System.out.println("\nThe respective traversal method for the aforementioned binary tree will be displayed before each Next function \ncomparison of results to the traversal method.\n-----------------------------------------------------------------------");
		populate_tree();
		
		System.out.println("\nThis is the sequence produced by a preorder traversal across the created binary tree:\n");
		preorderseq();
		System.out.println("\nThe following two lines are the result of the preorderNext(p) method:\n");
		//This is the call to the preorderNext method found in the AbstractTree class. The input position is the root(Start) of the tree and should be the first value of the traversal. Thus the value returned by the method should be the next value in the traversal (left).
		T.preorderNext((T.root()));
		System.out.println("\nAs you can see, the preorderNext method takes in the root(Start) as the input position and the resulting postion that is returned is the one after it in the preorder sequence(left).");
		System.out.println("\nThis method will also return null in the event that the input position is the last one in the traversal. For instance, we will input the right child of the right node (right of right):\n");
		//This input position is the last one in the preorder traversal (right of right) and the next position returned should be null since the input position is the last position in the traversal. 
		T.preorderNext(T.right(T.right(T.root())));
		
		System.out.println("-----------------------------------------------------------------------\n\nThis is the sequence produced by an inorder traversal across the created binary tree: \n");
		inorderseq();
		System.out.println("\nThe following two lines are the result of the inorderNext(p) method:\n");
		//This is the call to the inorderNext method found in the AbstractTree class. The input position is the left child of the left node(left of left) of the tree and should be the first value of the traversal. Thus the value returned by the method should be the next value in the traversal (left).
		T.inorderNext(T.left(T.left(T.root())));
		System.out.println("\nAs you can see, the inorderNext method takes in the left child of the left node(left of left) as the input position and the resulting postion that is returned is the one after it in the inorder sequence(left).");
		System.out.println("\nThis method will also return null in the event that the input position is the last one in the traversal. For instance, we will input the right child of the right node (right of right):\n");
		//This input position is the last one in the inorder traversal (right of right) and the next position returned should be null since the input position is the last position in the traversal. 
		T.inorderNext(T.right(T.right(T.root())));
		
		System.out.println("-----------------------------------------------------------------------\n\nThis is the sequence produced by a postorder traversal across the created binary tree:\n");
		postorderseq();	
		System.out.println("\nThe following two lines are the result of the postorderNext(p) method:\n");
		//This is the call to the postorderNext method found in the AbstractTree class. The input position is the left child of the left node(left of left) of the tree and should be the first value of the traversal. Thus the value returned by the method should be the next value in the traversal (LOROL).
		T.postorderNext(T.left(T.left(T.root())));
		System.out.println("\nAs you can see, the postorderNext method takes in the left child of the left node(left of left) as the input position and the resulting postion that is returned is the one after it in the postorder sequence(LOROL).");
		System.out.println("\nThis method will also return null in the event that the input position is the last one in the traversal. For instance, we will input the root node (Start):\n");
		//This input position is the last one in the postorder traversal (Start) and the next position returned should be null since the input position is the last position in the traversal. 
		T.postorderNext(T.root());
		System.out.println("-----------------------------------------------------------------------\n");
		
	}
	public static void main(String[] args) {
		Traversals sim = new Traversals();
		sim.run_program();


	}

}


//part D

//Each of the algorithms we will assume that a single loop will be considered as n, a nested loop will
//be considered n^2 and the collective number of operations will be a constant a. For the sake of argument
//we will not assign values to constants or multipliers. For each of the Next algorithms, we utilize a 
//loop within a loop as well as a single loop and other operations outside of these loops. So, we have 
//T(n)= n^2 + n + a for the algorithm. In terms of O(n), since at larger values, n^2 will far outscale n 
//in importance, so ultimately, the worst case time complexity would be O(n^2). This makes sense since
//binary tree traversals have a time complexity of O(n) and since the traversal is performed within a loop
//then it would be O(n) * O(n) = O(n^2).
//