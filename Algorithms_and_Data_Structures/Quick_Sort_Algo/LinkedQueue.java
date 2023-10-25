//CPSC 50300 Assignment Week 8			
//Joe Cruz 	 
//
//LinkedQueue class for assignment
// 
public class LinkedQueue<E> implements Queue<E> {

  private SinglyLinkedList<E> list = new SinglyLinkedList<>();   // an empty  list

  public LinkedQueue() { }                  // new queue relies on the initially empty list

  public int size() { return list.size(); }

  public boolean isEmpty() { return list.isEmpty(); }

  public void enqueue(E element) { list.addLast(element); }

  public E first() { return list.first(); }

  public E dequeue() { return list.removeFirst(); }

  public String toString() {
    return list.toString();
  }
}