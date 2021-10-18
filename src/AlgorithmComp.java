import java.io.IOException;

//check pdf-report for more details
public class AlgorithmComp   {
	public static void main(String[] args) throws IOException  {
		
		//total of Disks that Greedy Decreasing
		//used for all text files
		int Total_Disks_Decreasing=0;
		
		//total of Disks that Greedy Decreasing
		//used for all text files
		int Total_Disks_Greedy=0;
		
		//Disks used for each algorithm
		//in a specific text file
		int Disks_Decreasing=0;
		int Disks_Greedy=0;
		
		//starting from text file 1
		int text_file_number=1;
		
		int comp;
		
		//iterating through each text file(20 in total)
		for(int i=1; i<=20; i++,text_file_number++) {
			
			//checking the text file
			int[] table=Greedy.TextFileCheck("TEXTFILE("+text_file_number+").txt");
			System.out.println("\n\nChecking the two Algorithms in TEXTFILE("+text_file_number+")\n");
			System.out.println("Greedy Algorithm Stats:");
			
			//Greedy Algorithm also returns the disks used in the specific text file
			Disks_Greedy=Greedy.GreedyAlgorithm(table);
			Total_Disks_Greedy+=Disks_Greedy;
			
			//sorting the files and running Greedy(Greedy Decreasing)
			table=Sort.MergeSort(table);
			System.out.println("\nGreedy-Decreasing Algorithm Stats:");
			
			Disks_Decreasing=Greedy.GreedyAlgorithm(table);
			Total_Disks_Decreasing+=Disks_Decreasing;
		
			//comparing number of disks used in this specific text file
			//in greedy and in greedy decreasing
			comp=compare(Disks_Greedy,Disks_Decreasing);
			
			if(comp<0) {
				System.out.println("\nComparison:Greedy Algorithm is more efficient than Greedy-Decreasing Algorithm in TEXTFILE("+text_file_number+")");
			}
			else if(comp>0){
				System.out.println("\nComparison:Greedy-Decreasing Algorithm is more efficient than Greedy Algorithm in TEXTFILE("+text_file_number+")");
			}
			else {
				System.out.println("\nComparison:Both algorithms are equally efficient in TEXTFILE("+text_file_number+")");
			}
		}
		
		//printing the average of disks for both algorithms for a specific value of N
		System.out.println("\nAverage of disk files used in all text files by Greedy Algorithm: "+((double)Total_Disks_Greedy/20));
		System.out.println("Average of disk files used in all text files by Greedy-Decreasing Algorithm: "+((double)Total_Disks_Decreasing/20));
		
		comp=compare(Total_Disks_Greedy,Total_Disks_Decreasing);
		
		//Making final comparison between the two algorithms, for all text files
		if(comp<0) {
			System.out.println("Final Comparison: Greedy is more efficient");
		}
		else if(comp>0) {
			System.out.println("Final Comparison: Greedy-Decreasing Algorithm is more efficient");
		}
		else {
			System.out.println("Final Comparison: Both algorithms are equally efficient");
		}
	}

	/**
	 * @param a
	 * @param b
     * @return a-b
     */
	public static int  compare(int a, int b) {
		return a-b;
	
	}

}
