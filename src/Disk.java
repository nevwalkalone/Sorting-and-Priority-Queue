/**
 * Class that implements the Disk Interface's methods. Comparable is implemented
 * in order to be able to compare the capacities of 2 different disks Comments
 * for methods that are overriden can be found in the Disk Interface.
 */

public class Disk implements DiskInterface, Comparable<Disk> {

	// id of the specific disk
	private int id;

	// List to keep the folders in a specific disk
	private List<Integer> folders = new List<>();

	// size of the specific disk
	private int disk_Size;

	// Constructor
	public Disk(int id) {
		this.id = id;

		disk_Size = 1000000;
	}

	// GETTERS

	@Override
	public List<Integer> get_Files() {
		return folders;
	}

	@Override
	public int getFreeSpace() {
		return disk_Size;

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

	@Override
	public void reduce_size(int file_size) {
		disk_Size = disk_Size - file_size;
	}

	/**
	 * Compares the sizes of 2 different disks.
	 * 
	 * @param B other Disk that will be compared
	 */

	@Override
	public int compareTo(Disk B) {

		if (this.getFreeSpace() == B.getFreeSpace()) {
			return 0;
		}

		else if (this.getFreeSpace() > B.getFreeSpace()) {
			return 1;
		}

		else {
			return -1;
		}
	}

}
