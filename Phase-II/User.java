import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class User {
	protected String username;
	protected String email;
	protected String password;
	
	// Regular expression for email validation
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
	
	
	public User() {
		this.username = "";
		this.email = "";
		this.password = "";
	}
	
	public User(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		if(isValidEmail(email)) {
			this.email = email;
		}else {
			throw new IllegalArgumentException("Invalid email format");
		}
		
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//helper method to validate email
	static boolean isValidEmail(String email) {
		Pattern pattern = Pattern.compile(EMAIL_REGEX);
		Matcher matcher = pattern.matcher(email); 
		return matcher.matches();
	}
	//method to show users Different dashboard
	abstract void userDashboard();
	
	@Override
	public String toString() {
		return "User [Username= " + this.username + ", email=" + email + "]";
	}
	
}


