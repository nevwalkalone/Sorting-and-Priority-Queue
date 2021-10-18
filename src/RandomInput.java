import java.util.Random;
import java.io.*;

//check pdf-report for more details
//to run the program in cmd java RandomInput numberofN numberoftextfiles
public class RandomInput {
	public static void main(String args[]) throws IOException {
		
		//passing value of N as a first argument
		int N=Integer.parseInt(args[0]);
		
		//passing number of text files as a second argument
		int Text_Files=Integer.parseInt(args[1]);
		
		//creating a Random object
		Random r=new Random();
		int text_file_number=1;
		
		for(int i=1; i<=Text_Files; i++,text_file_number++) {
			
			//creating a new text file
			File file=new File("TEXTFILE("+text_file_number+").txt");
			FileWriter writer=new FileWriter(file);
			for(int j=1; j<N;j++) {
					
					//writing in each line of the text file a random number between 0 and 100000
					if(j==N-1) {
						writer.write(r.nextInt(1000001)+"\n"+r.nextInt(1000001));
						
					}else {
						writer.write(r.nextInt(1000001)+"\n");
						
					}
				
					
			}
		
			writer.close();
			
			}
	}
	
}
