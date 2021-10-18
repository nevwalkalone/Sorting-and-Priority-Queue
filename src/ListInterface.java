
public interface ListInterface <T>{
	/**
    
     * @return true if List is empty
     */
	boolean isEmpty();
	
	/**
     * Inserts the specified element into this List.
     *
     * @param item
     */
	void insert(T data);
	
	/**
     * @return head of the List.
     */
	Node<T> getHead();
	
	/**
     * @return tail of the List.
     */
	
	Node<T> getTail();
	
	/**
     * Inserts the specified element into this List.
     *
     * @return a Stringbuilder object with all the data of the List.
     */
	 
	String toString();
	 
	
}
