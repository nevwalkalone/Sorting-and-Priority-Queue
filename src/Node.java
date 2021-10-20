/**
 * Class representing a Node, contains data and a reference to the next node.
 * Generics were used.
 */

public class Node<T> {

    private T data;
    private Node<T> next;

    // Constructor
    public Node(T data) {
        this.data = data;
        next = null;
    }

    /**
     * @return the data of the specific node.
     */
    public T getData() {
        return data;
    }

    /**
     * @return the reference to the next node.
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Sets the reference to the next node
     * 
     * @param next the node that will be referenced.
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

}
