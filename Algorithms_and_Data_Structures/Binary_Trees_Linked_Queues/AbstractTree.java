//CPSC 50300 Assignment Week 5				
//Joe Cruz 	
//
//AbstractTree Class for assignment. 4 methods were added to address question 1 of the assignment. The following were added: preorderNext(Position<E> p),
//inorderNext(Position<E> p), postorderNext(Position<E> p), position_compare (Position<E> p,  SinglyLinkedList<Position<E>> list). The "Next" methods will
//return the next position in the traversal sequence based on an input position. The position_compare method is used to compare the traversal method to the
//input position and determine what the next position is(used by the "Next" methods). 
 
import java.util.Iterator;
import java.util.List;         // for use as snapshot iterator
import java.util.ArrayList;    // for use as snapshot iterator
public abstract class AbstractTree<E> implements Tree<E> {
  public boolean isInternal(Position<E> p) { return numChildren(p) > 0; }
  public boolean isExternal(Position<E> p) { return numChildren(p) == 0; }
  public boolean isRoot(Position<E> p) { return p == root(); }
  public int numChildren(Position<E> p) {
    int count=0;
    for (Position child : children(p)) count++;
    return count;
  }
  public int size() {
    int count=0;
    for (Position p : positions()) count++;
    return count;
  }
  public boolean isEmpty() { return size() == 0; }
  public int depth(Position<E> p) throws IllegalArgumentException {
    if (isRoot(p))
      return 0;
    else
      return 1 + depth(parent(p));
  }
  private int heightBad() {             // works, but quadratic worst-case time
    int h = 0;
    for (Position<E> p : positions())
      if (isExternal(p))                // only consider leaf positions
        h = Math.max(h, depth(p));
    return h;
  }
  public int height(Position<E> p) throws IllegalArgumentException {
    int h = 0;                          // base case if p is external
    for (Position<E> c : children(p))
      h = Math.max(h, 1 + height(c));
    return h;
  }
  private class ElementIterator implements Iterator<E> {
    Iterator<Position<E>> posIterator = positions().iterator();
    public boolean hasNext() { return posIterator.hasNext(); }
    public E next() { return posIterator.next().getElement(); } // return element!
    public void remove() { posIterator.remove(); }
  }
  public Iterator<E> iterator() { return new ElementIterator(); }
  public Iterable<Position<E>> positions() { return preorder(); }

  private void preorderSubtree(Position<E> p, List<Position<E>> snapshot) {
    snapshot.add(p); // for preorder, we add position p before exploring subtrees
    for (Position<E> c : children(p))
      preorderSubtree(c, snapshot);
  }  
  public Iterable<Position<E>> preorder() {
    List<Position<E>> snapshot = new ArrayList<>();
    if (!isEmpty())
      preorderSubtree(root(), snapshot);   // fill the snapshot recursively
    return snapshot;
  }
 
  
///////// ADDED FOR Question 1 in Assignment
  //method preorderNext to return the position visited after input position p in the preorder traversal of a binary tree.
  public Position<E> preorderNext(Position<E> p)	 {			
	  SinglyLinkedList<Position<E>> list = new SinglyLinkedList<Position<E>>();
	  Position<E> pos =null;
	  for (Position element: preorder()) {
		pos = (Position<E>) element;
		list.addLast(pos);
		}
	  pos=position_compare(p, list);
	  return pos;
	}
	
  //method inorderNext to return the position visited after input position p in the inorder traversal of a binary tree.
  public Position<E> inorderNext(Position<E> p) {		
		  SinglyLinkedList<Position<E>> list = new SinglyLinkedList<Position<E>>();
		  Position<E> pos =null;
		  for (Position element: positions()) {
			pos = (Position<E>) element;
			list.addLast(pos);
			}
		  pos=position_compare(p, list);
		  return pos;
		}
  
  //method postorderNext to return the position visited after input position p in the postorder traversal of a binary tree.
  public Position<E> postorderNext(Position<E> p) {		
		  SinglyLinkedList<Position<E>> list = new SinglyLinkedList<Position<E>>();
		  Position<E> pos =null;
		  for (Position element: postorder()) {
			pos = (Position<E>) element;
			list.addLast(pos);
			}
		  pos=position_compare(p, list);
		  return pos;
		}
  
  //method position_compare which is used to iterate through a SinglyLinkedList that contains the contents of a binary tree traversal.
  //the elements are then compared to the input position and if a match is found, the next position in the SinglyLinkedList is returned. Furthermore, 
  //the input position is printed out along with the contents of the next position. In the event that the initial position is the last stop in the traversal, 
  //the method will return a null value. 
  private Position <E> position_compare (Position<E> p,  SinglyLinkedList<Position<E>> list) {
	  int size_list= list.size();
	  Position<E> list_element = null;
	  for(int i=0; i<size_list; i++) {
		list_element = list.first();
		if(list_element == p) {
			list.removeFirst();
			list_element=list.first();
			String input= (String) p.getElement();
			System.out.println("The input position contents were: " + input);
			if (list.isEmpty()) {
				list_element=null;
				System.out.println("The next position after visiting the input position is: " + list_element + "  (input position was last visited node)");}
			if(!list.isEmpty()) { 
				String contents= (String) list_element.getElement();
				
				System.out.println("The next position after visiting the input position is: "+ list_element);
				System.out.println("These are the contents of that position in the tree: " + contents);}
		}
		list.removeFirst();
		list_element=list.first();
	  }
		return list_element;
	}
////////End of additions for Question 1
  
  
  private void postorderSubtree(Position<E> p, List<Position<E>> snapshot) {
    for (Position<E> c : children(p))
      postorderSubtree(c, snapshot);
    snapshot.add(p);                       // for postorder, we add position p after exploring subtrees
  }

  public Iterable<Position<E>> postorder() {
    List<Position<E>> snapshot = new ArrayList<>();
    if (!isEmpty())
      postorderSubtree(root(), snapshot);   // fill the snapshot recursively
    return snapshot;
  }

  public Iterable<Position<E>> breadthfirst() {
    List<Position<E>> snapshot = new ArrayList<>();
    if (!isEmpty()) {
      Queue<Position<E>> fringe = new LinkedQueue<>();
      fringe.enqueue(root());                 // start with the root
      while (!fringe.isEmpty()) {
        Position<E> p = fringe.dequeue();     // remove from front of the queue
        snapshot.add(p);                      // report this position
        for (Position<E> c : children(p))
          fringe.enqueue(c);                  // add children to back of queue
      }
    }
    return snapshot;
  }
}