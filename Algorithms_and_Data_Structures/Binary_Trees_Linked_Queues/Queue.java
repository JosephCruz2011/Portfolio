//CPSC 50300 Assignment Week 5				
//Joe Cruz 	
//
//Queue interface class for assignment
// 
public interface Queue<E> {

  int size();

  boolean isEmpty();

  void enqueue(E e);

  E first();

  E dequeue();
}