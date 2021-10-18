
public interface DiskInterface {
	 
	
	/**
	 * 
	 * @return the List with the files in the specific Disk.
	 */
	List<Integer> get_Files();
	
	/**
	 * 
	 * @return the Free Space of the specific Disk.
	 */
	int getFreeSpace();
	
	/**
	 * @return the id of the specific Disk.
	 */
	int getId();
	
	/**
	 * Inserts a file to the specific Disk.
	 * @param file
	 */
	
	void addFileToTheList(int file);
	
	
	
	
}
