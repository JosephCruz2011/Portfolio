//CPSC 50300 Assignment Week 5				
//Joe Cruz 	
//
//Position Interface for assignment
//
 
public interface Position<E> {
// Returns the element stored at this position.
	  E getElement() throws IllegalStateException;
	}