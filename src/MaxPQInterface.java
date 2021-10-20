/**
 * Defines the methods for a Max Priority Queue Data Structure. Generics were
 * used.
 */

public interface MaxPQInterface<T> {

     /**
      * @return true if MaxPQ is empty
      */
     boolean isEmpty();

     /**
      * Inserts the specified element into this priority queue.
      *
      * @param item that will be inserted in the priority queue.
      */
     void insert(T item);

     /**
      * Retrieves, but does not remove,the item with the max priority, or returns
      * null if this queue is empty.
      *
      * @return the item with the max priority
      */
     T peek();

     /**
      * Retrieves and removes the item with the max priority.
      *
      * @return the item with the max priority
      */
     T getMax();

     /**
      * Refreshes the MaxPQ by sinking the element with the previous Max Priority.
      */
     void refresh();

     /**
      * Swaps elements in indexes i and j.
      * 
      * @param i index of the first table, whose element will be swapped.
      * @param j index of the second table, whose element will be swapped.
      */
     void swap(int i, int j);

}
