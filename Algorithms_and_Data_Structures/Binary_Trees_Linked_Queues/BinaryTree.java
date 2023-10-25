//CPSC 50300 Assignment Week 5				
//Joe Cruz 	
// 
//BinaryTree Interface for assignment
//
public interface BinaryTree<E> extends Tree<E> {

	  Position<E> left(Position<E> p) throws IllegalArgumentException;
	  Position<E> right(Position<E> p) throws IllegalArgumentException;
	  Position<E> sibling(Position<E> p) throws IllegalArgumentException;
	}