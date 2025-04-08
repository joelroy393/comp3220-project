/*
 * User Management Class
 * Last Updated: 2024-10-31
 * Purpose: Connects to google drive through an auth key
 * 			Allows the login of users through the login and signup methods.
 * 			Accounts are saved back on to google drive.
 * Notes: Credentials should be formatted as: 	username,password
 * 												username2,password2	
 * */

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class UserManagement {
	private String userFileName = ""; //Name of file that stores credentials
	
	/*
	 * UserManagement Method
	 * Last Updated: 2024-10-31
	 * Purpose: Sets the GoogleAPIKey to a given authentication key
	 * Input: String of full file path: Ex. C:\\Users\\amy\\OneDrive\\Desktop\\Database\\credentials.txt
	 * */
	public UserManagement(String newFileName) {
		this.userFileName = newFileName;
	}
	
	/*
	 * login Method
	 * Last Updated: 2024-10-31
	 * Purpose: when given a username and password, searches through the google drive file
	 * 			and searches for a match
	 * Input: String username, String password
	 * Output: Boolean depicting whether search was successful or not
	 * */
	public boolean login(String username, String password){
		//TODO: Will need to download the files from the google API
		boolean output = false;
		File userCredentials = grabUserFile(userFileName);
		try {
			List<String> lines = Files.readAllLines(userCredentials.toPath());

			for (String credentials : lines) {
				String[] parts = credentials.split(",\\s*");
				
				//Error Checking to see if parts contains both username and password
				if (parts.length == 2) {
					String user = parts[0].trim();
					String pass = parts[1].trim();
					
					if (user.equals(username) && pass.equals(password)) {
						return true;
					}
				}
			}
			return false; //no match found
		} catch(IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/*
	 * Signup Method
	 * Last Updated: 2024-10-31
	 * Purpose: When given a username and password, write them to a file
	 * Input: String username, String password
	 * Output: Boolean depicting whether the method was successful
	 * */
	public boolean signup(String username, String password) {
		//TODO: Will need to download the files from the google API
		boolean output = false;
		File userCredentials = grabUserFile(userFileName);
        String credential = username + "," + password + System.lineSeparator(); // Formatting
        
        try {
            // Add new credentials to file
            Files.write(userCredentials.toPath(), credential.getBytes(), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
            output = true;
            return output;
        } catch (IOException e) {
            e.printStackTrace();
        }
		return output;
	}
	
	/*
	 * DeleteAccount Method
	 * Last Updated: 2024-11-01
	 * Purpose: When given a username and password, reads through the file and deletes any instance of those
	 * Input: String username, String passwrd
	 * Output: Boolean depicting whether the method was successful
	 * */
	public boolean deleteAccount(String username, String password){
		boolean output = false;
		File userCredentials = grabUserFile(userFileName);
		
		try {
			List<String> lines = Files.readAllLines(userCredentials.toPath());
			List<String> tempUserCredentials = new ArrayList<>();
			boolean foundCredentials = false;

			for (String credentials : lines) {
				String[] parts = credentials.split(",\\s*");
				
				//Error Checking to see if parts contains both username and password
				if (parts.length == 2) {
					String user = parts[0].trim();
					String pass = parts[1].trim();
					
					if (!(user.equals(username) && pass.equals(password))) {
						tempUserCredentials.add(credentials);
					}
					else {
						foundCredentials = true;
					}
				}
			}
			
			Files.write(userCredentials.toPath(), tempUserCredentials, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
			if (!foundCredentials) {
				output = true;	
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return output;
	}
	
	
	/*
	 * grabUserFile Method
	 * Last Updated: 2024-10-01
	 * Purpose: When given a file name, searches for that file on google drive and returns it as a File.
	 * */
	public File grabUserFile(String fileName) {
		File output = null;
		
		output = new File(fileName);
		return output;
	}
	
	
}
