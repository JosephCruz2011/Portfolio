//CPSC 50300 Assignment Week 4				
//Joe Cruz 	
//
//ArrayList Class from the Assignment
 
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<O> implements List<O> {
	  public static final int CAPACITY=16;     // default array capacity
	  private O[] data;                        // generic array used for storage
	  private int size = 0;                    // current number of elements
	  public ArrayList() { this(CAPACITY); }   // constructs list with default capacity
	  public ArrayList(int capacity) {         // constructs list with given capacity
	    data = (O[]) new Object[capacity];     // safe cast; compiler may give warning
	  }
	  public int size() { return size; }
	  public boolean isEmpty() { return size == 0; }
	  public O get(int i) throws IndexOutOfBoundsException {
	    checkIndex(i, size);
	    return data[i];
	  }
	  public O set(int i, O o) throws IndexOutOfBoundsException {
	    checkIndex(i, size);
	    O temp = data[i];
	    data[i] = o;
	    return temp;
	  }
	  
	  //added for Question 4 to check current capacity of the ArrayList
	  public int capacity_check() {
		  int length_of=data.length;
		  return length_of;
	  }
	  
	  public void add(int i, O o) throws IndexOutOfBoundsException {
	    checkIndex(i, size + 1);
	    if (size == data.length)               // not enough capacity
	      resize(2 * data.length);             // so double the current capacity
	    for (int k=size-1; k >= i; k--)        // start by shifting rightmost
	      data[k+1] = data[k];
	    data[i] = o;                           // ready to place the new element
	    size++;
	  }
	  public O remove(int i) throws IndexOutOfBoundsException {
	    checkIndex(i, size);
	    O temp = data[i];
	    for (int k=i; k < size-1; k++)         // shift elements to fill hole
	      data[k] = data[k+1];
	    data[size-1] = null;                   // help garbage collection
	    size--;
	    return temp;
	  }
	  
	  protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
	    if (i < 0 || i >= n)
	      throw new IndexOutOfBoundsException("Illegal index: " + i);
	  }
	  
	  protected void resize(int capacity) {
	    O[] temp = (O[]) new Object[capacity];     // safe cast; compiler may give warning
	    for (int k=0; k < size; k++)
	      temp[k] = data[k];
	    data = temp;                               // start using the new array
	  }
	 
	  
 private class ArrayIterator implements Iterator<O> {
		    /** Index of the next element to report. */
		    private int j = 0;                   // index of the next element to report
		    private boolean removable = false;   // can remove be called at this time?
		    public boolean hasNext() { return j < size; }   // size is field of outer instance
		    public O next() throws NoSuchElementException {
		      if (j == size) throw new NoSuchElementException("No next element");
		      removable = true;   // this element can subsequently be removed
		      return data[j++];   // post-increment j, so it is ready for future call to next
		    }
		    public void remove() throws IllegalStateException {
		      if (!removable) throw new IllegalStateException("nothing to remove");
		      ArrayList.this.remove(j-1);  // that was the last one returned
		      j--;                         // next element has shifted one cell to the left
		      removable = false;           // do not allow remove again until next is called
		    }
		  } //------------ end of nested ArrayIterator class ------------
		  public Iterator<O> iterator() {
		    return new ArrayIterator();     // create a new instance of the inner class
		  }
		  public String toString() {
		    StringBuilder sb = new StringBuilder("(");
		    for (int j = 0; j < size; j++) {
		      if (j > 0) sb.append(", ");
		      sb.append(data[j]);
		    }
		    sb.append(")");
		    return sb.toString();
		  }

}


