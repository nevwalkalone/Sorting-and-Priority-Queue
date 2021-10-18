//check interface and pdf-report for more details
public class List<T> implements ListInterface<T>{
	
	private Node<T> head;
	
	private Node<T> tail;
	
	
	public List() {
		
	}
	
	public boolean isEmpty() {
        return head == null;
    }
	
	public void insert(T data) {
        Node<T> node = new Node<T>(data);

        if (isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
    }
	
	public Node<T> getHead() {
		return head;
	}
	
	public Node<T> getTail(){
		return tail;
	}
	
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
