class Contributor extends User{
	private List<FilePoint> uploadedFiles;
	
	public Contributor(String username, String email, String password) {
		super(username, email, password);
		//this.uploadedFiles = new ArrayList<>();
	}
	public void uploadDataset(FilePoint dataset) {
		dataset.setStatus("pending");
		uploadedFiles.add(dataset);
		//
	}
	public List<FilePoint> viewUploadedFiles(){
		return uploadedFiles;
	}
	
	//contributor method to remove a dataset 
	public void removeDataset(FilePoint dataset) {
		uploadedFiles.remove(dataset);
	}
	
	@Override
	public void userDashboard() {
		//logic for pending dtasets
		//Approved datssets
		//upload new dataset option
		//logout option
		//return to main page
		System.out.println("Welcome to your Dashboard, " + getUsername() + "!");
		System.out.println("1. Upload a new Dataset"); 
		System.out.println("2. View My Pending Datasets"); 
		System.out.println("3. View My Contributions");
		System.out.println("4. Log Out"); 
		System.out.println("5. Back to Main Page");
	}
}