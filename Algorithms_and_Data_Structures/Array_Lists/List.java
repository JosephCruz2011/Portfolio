//CPSC 50300 Assignment Week 4				
//Joe Cruz 	
//
//ArrayList Interface from the Assignment
 
import java.util.Iterator;
public interface List<O> extends Iterable<O>{
	int size();
	boolean isEmpty();
	O get(int i) throws IndexOutOfBoundsException;
	O set(int i, O o) throws IndexOutOfBoundsException;
	void add(int i, O o)throws IndexOutOfBoundsException;
	O remove(int i) throws IndexOutOfBoundsException;
	Iterator<O> iterator();
	
	//added for question 4 to prove capacity changes
	int capacity_check();
}
