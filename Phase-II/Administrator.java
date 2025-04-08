
public class Administrator extends User {
	//might need some fields
	private List<FilePoint> approvedFiles; //to track approved data set

	public Administrator(String username, String email, String password) {
		super(username, email, password);
		this.approvedFiles = new ArrayList<>(); 
	}
	//Approval of datasets
	public void approvedDataset(FilePoint dataset) {
		dataset.setStatus("Approved");
		//  Additional logic for database or API implementation here
	}
	
	//method for users management
	public void deleteuser(User user) {
		// logic
	}
	public void updataDataSet(FilePoint dataset) {
		
	}
	@Override
	public void userDashboard() {
		//
	}
}
