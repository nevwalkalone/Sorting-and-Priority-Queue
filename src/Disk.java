//check interface  for more details
public class Disk implements DiskInterface,Comparable<Disk>{
	
	//id of the specific disk
	private int id;
	
	//List to keep the folders in a specific disk
	private List<Integer> folders=new List<>();
	
	//size of the specific disk
	private int Disk_size;
	
	
	public Disk(int id) {
		this.id=id;
		
		Disk_size=1000000;
	}
	
	@Override
	public List<Integer> get_Files() {
		return folders;
	}
	
	@Override
	public int getFreeSpace() {
		return Disk_size;
		
	}
	
	@Override
	public int getId() {
		return id;
	}
	
	@Override
	public void addFileToTheList(int file) {
		folders.insert(file);
		reduce_size(file);
	}
	
	/**
	 * Reduces the size of the Disk if a file is inserted
	 *@param file_size
	 */
	
	private void reduce_size(int file_size) {
		Disk_size=Disk_size-file_size;
	}
	
	@Override
	public int compareTo(Disk B) {
		
		if(this.getFreeSpace()==B.getFreeSpace()) {
			return 0;
		}
	    
		else if(this.getFreeSpace()>B.getFreeSpace()) {
			return 1;
		}
		else {
			return -1;
		}
	}

}
