//for more details check pdf-report
public class Sort {


	public static int[] MergeSort(int[] array) {
		if (array.length<=1) {
			return array;
		}
		
		//fixing a midpoint
		int midpoint=array.length/2;
		
		//we cut in half the initial array
		
		int []left=new int[midpoint];
		int[] right;
		
		if(array.length%2==0) {
			right=new int[midpoint];
		}
		else {
			right=new int[midpoint+1];
			
		}
		
		//left array gets the values of the table from start until midpoint
		for(int i=0; i<left.length; i++) {
			left[i]=array[i];
		}
		
		//right array gets the values of the table from midpoint+1 until end of the table
		for(int j=0;j<right.length;j++) {
			right[j]=array[midpoint+j];
		}
		
		//recursion calls to sort left and right sub-table
		right=MergeSort(right);
		left=MergeSort(left);
		
		//Merging the two sorted subtables
		array=Merge(right,left);
		
		//returning the Sorted Array
		return array;
	}
	private static int[] Merge(int[] right, int[] left) {
		
		//initializations 
		int[] result=new int[right.length+left.length];
		int right_pointer=0;
		int left_pointer=0;
		int result_pointer=0;
		
		//in case the table has odd length right sub-table has 1 more value
		while(right_pointer<right.length || left_pointer<left.length) {
			
			//if both tables have elements we compare the current elements
			if(right_pointer<right.length && left_pointer<left.length) {
				
				//if current value of the left table is smaller store it in the current
				//position of the merged array, and increment by one the left_pointer
				if(right[right_pointer]<left[left_pointer]) {
					result[result_pointer]=left[left_pointer];
					left_pointer++;
				}
				//else do the same for the right subtable
				else {
					result[result_pointer]=right[right_pointer];
					right_pointer++;
				}
				
				
			}
			//else if only the right subtable has elements
			//store its current element  in merged sort 
			else if(right_pointer<right.length) {
				result[result_pointer]=right[right_pointer];
				right_pointer++;
			}
			//else store the value of the left subtable in
			//merged sort
			else {
				result[result_pointer]=left[left_pointer];
				left_pointer++;
			}
			//increment by one the merged_sort pointer
			result_pointer++;
		}
		//return the merged table
		return result;
	}
}
