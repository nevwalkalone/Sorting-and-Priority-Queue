import java.io.*;
import java.util.Scanner;

//check pdf-report for more details
//to run the program in cmd java Greedy path_to_file/filename.txt
public class Greedy {
	
	
	public static void main(String[] args) throws IOException {
		
		//passing the file path as an argument
		String file_path=args[0];
		
		//checking the text file
		int[] table=TextFileCheck(file_path);
		

		
		
		//calling the method for GreedyAlgorithm
		GreedyAlgorithm(table);
	
	}
	
	
	//method for Greedy Algorithm
	public static int GreedyAlgorithm(int[] table) {
		
		//creating a prioriy queue which contains Disk objects
		MaxPQ<Disk> PQ=new MaxPQ<>(table.length+1);
		
		//creating the first disk to be inserted in PQ
		Disk disk0=new Disk(0);
		
		
		//This will be used to count number of
		//disks used in the text file
		int NumberOfDisks=1;
		
		//this will be used to count files size
		int folders_size=table[0];
	
		disk0.addFileToTheList(table[0]);
		
		
		
		//inserting the first disk in the PQ
		PQ.insert(disk0);
		
		
		//iterates through all files in the text file
		for(int i=1;i<table.length;i++) {
			
			
			folders_size+=table[i];
			
			//if the space in the disk with the most free space
			//is greater than the current file
			//insert current file in the specific disk
			if(table[i]<=PQ.peek().getFreeSpace()) {
			
				PQ.peek().addFileToTheList(table[i]);
				
			}
			
			//else create a new disk,insert it in the PQ
			//and insert the current file to the disk
			else {
				NumberOfDisks++;
				Disk disk=new Disk(NumberOfDisks-1);
				PQ.insert(disk);
				disk.addFileToTheList(table[i]);
				
			}
				//refreshes PQ by sinking PQ[1]
				PQ.refresh();
		}
		
		//calls the print method
		Print(PQ,folders_size,table.length,NumberOfDisks);
		
		//returns total number of disks used in the specific text file
		return NumberOfDisks;
	}
	
	
	//Print method
	private static void Print(MaxPQ<Disk> PQ,int folders_size,int NumberOfFolders,int NumberOfDisks) {
		
		System.out.println("\nSum of all folders = "+(double)folders_size/1000000+" TB");
		System.out.println("Total number of disks used = "+NumberOfDisks);
		
		if(NumberOfFolders<=100) {
			for(int j=0; j<NumberOfDisks;j++) {
				//printing each time the item with the max priority
				Disk tempdisk=(Disk) PQ.getMax();
				System.out.println("id "+tempdisk.getId()+" "+tempdisk.getFreeSpace()+": "+tempdisk.get_Files());
			}
		}
	}
		
	
	
	//TextFileCheck Method
	public static int[] TextFileCheck(String file_path) throws IOException {
		
		//try block
		try {
		
		//creating objects for reading the file
		File file=new File(file_path);
		FileReader fr=new FileReader(file);
		BufferedReader br=new BufferedReader(fr);
		Scanner input=new Scanner(file);
		String s=null;
		
		int line_counter=0;
		
		while((s=br.readLine())!=null) {
			
			//if file size isn't between 0 and 1000000
			//print a message and end the program
			if(Integer.parseInt(s)>1000000 || Integer.parseInt(s)<0) {
				
				System.out.println("File size must be between 0 and 1000000 MB");
				System.exit(1);
				
			}
			line_counter++;
			
		}
		
		int files[]=new int[line_counter];
		
		//putting all files in integer table
		for(int i=0; i<files.length; i++) {
			files[i]=Integer.parseInt(input.nextLine());
			
		}
		
		//closing the objects used for checking the file
		br.close();
		input.close();
		
		//return the table which contains all files
		return files;
	}	
		//catching any Exception and printing it
		//and ending the program
		catch (Exception e) {
			System.out.println("\n\n"+e);
			System.exit(1);
			return null;
		}
		
		
	}
}
