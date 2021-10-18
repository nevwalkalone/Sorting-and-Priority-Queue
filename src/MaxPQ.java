//check interface and pdf-report for more details
public class MaxPQ<T> implements MaxPQInterface<T>{
	
	private T[] PQ; 
    private int size;
  
   
    
    @SuppressWarnings("unchecked")
    //constructs the Priority Queue
    public MaxPQ(int maxN) {
    	PQ=(T[]) new Object[maxN];
    	size=0;
    }
   
    public boolean isEmpty() {
    	return size==0;
    }
	
    @Override
	public void insert(T item) {
    		
    	//inserts an item as a leaf
		PQ[++size]=item;
			
		//the item swims to the top, stops when tree becomes a heap
		swim(size);
		
	}

	@Override
	public T peek() {
		
		if(isEmpty()) {
		return null;
		}
		
		//returns item with max priority
		return PQ[1];
	}

	@Override
	public T getMax() {
		
		if(isEmpty()) {
			return null;
		}
		
		T root=PQ[1];
		
		//first element becomes last element
		PQ[1]=PQ[size];
		
		size--;
		
		//we sink PQ[1] to the bottom, stops when tree becomes a heap
		sink(1);
		
		//returns the root which is the item with the max priority
		return root;
	}
	
	
	@SuppressWarnings("unchecked")
	private void swim(int i) {
	       
		
	    // find parent
		int parent = i / 2;

		
		// compare parent with child i
		//if i=1 we are at the root
		while (i != 1 && ((Comparable<T>) PQ[i]).compareTo(PQ[parent])> 0) {
			swap(i, parent);
	        i = parent;
	        parent = i / 2;
	    }

	       
	}
	 
	
	@SuppressWarnings("unchecked")
	private void sink(int i) {
	        
		
		// determine left, right child
		int left = 2 * i;
	    int right = left + 1;

	        

	    // while we  haven't reached the leafs
	    // if 2*i > size, node i is a leaf return
	    while (left <= size) {
	    
	    	// Determine the largest child of node i
	        int max = left;
	        if (right <= size) {
	        	if(((Comparable<T>) PQ[left]).compareTo(PQ[right])<0)
	        		max = right;
	        }

	        // If the heap condition holds, stop. Else swap and go on.
	        // child smaller than parent
	        if(((Comparable<T>) PQ[i]).compareTo(PQ[max])>=0)
	        	return;
	        
	        else {
	        	swap(i, max);
	            i = max;
	            left = i * 2;
	            right = left + 1;
	        }
	     }
	}
	 
	
	@Override
	public void refresh() {
		  sink(1);
	  }
	
	 //swaps elements in indexes i and j
	  private void swap(int i, int j) {
	        T temp = PQ[i];
	        PQ[i] = PQ[j];
	        PQ[j] = temp;
	    }
	
        
}
	

