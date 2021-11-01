/*
 * Class that implements the List Interface's methods. Comments for each method
 * can be found in the List Interface. Generics were used.
 */

public class List<T> implements ListInterface<T> {

    private Node<T> head;
    private Node<T> tail;

    // Constructor
    public List() {

    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void insert(T data) {
        Node<T> node = new Node<T>(data);

        if (isEmpty()) {
            head = node;
            tail = node;
        }

        else {
            tail.setNext(node);
            tail = node;
        }
    }

    @Override
    public Node<T> getHead() {
        return head;
    }

    @Override
    public Node<T> getTail() {
        return tail;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "List is empty ";
        }

        Node<T> current = head;
        StringBuilder ret = new StringBuilder();

        while (current != null) {
            ret.append(current.getData().toString());
            ret.append(" ");
            current = current.getNext();
        }

        return ret.toString();
    }

}
