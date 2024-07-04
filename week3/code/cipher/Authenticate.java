/*
 * This program authenticates a user using a username and password
 * The username and password are stored in a file called credentials.txt
 * All passwords have been enciphered using the CaesarCipher class
 * So the passwords are stored in the file in an encrypted state
 * 
 * Authentication Logic
 * ====================
 *	1. The user enters a username and password (obscure the password when typed)
 *	2. The program reads the credentials from the file
 *	3. The program enciphers the user's entered password
 *	4. The program checks if the credentials contain the username and enciphered password
 */

import java.io.File;					// import the File class to work with files
import java.io.FileNotFoundException;	// import the FileNotFoundException class to handle file not found errors
import java.util.Scanner;				// import the Scanner class to scan input streams
import java.util.ArrayList;				// import the ArrayList class to hold file data
import java.io.Console;					// import the Console class to read passwords from the console

public class Authenticate {
	public static void main(String[] args){
		Authenticate authenticate = new Authenticate();					// create an instance of this class

		Console console = System.console();								// create a Console object for reading passwords
		Scanner keyboard = new Scanner(System.in);						// create a Scanner object for keyboard input

		System.out.print("Enter your username: ");						// prompt the user for a username
		String username = keyboard.nextLine();							// read the username from the user
		System.out.print("Enter your password: ");						// prompt the user for a password
		char[] password = console.readPassword();						// read the password from the user
		keyboard.close();												// close the Scanner object

		if(authenticate.authenticate(username, password))				// if the user is authenticated
			System.out.printf("Welcome %s. You are authenticated!\n", username);// print a message
		else															// if the user is not authenticated
			System.out.println("Login Failed. Check your credentials");			// print a message

	}

	/**
	 * Authenticates a user
	 * @param username
	 * @param password	unencrypted password
	 * @return true if the user is authenticated, false otherwise
	 */
	public boolean authenticate(String username, char[] password){
		ArrayList<String> credentials = loadCredentials();				// call the loadCredentials method
		CaesarCipher cipher = new CaesarCipher();						// create an instance of the CaesarCipher class
		String enciphered 	= cipher.encipher(String.valueOf(password));// encipher the password
		String user_data 	= username + "\t" + enciphered;				// create a string with the username and enciphered password
		
		if(credentials.contains(user_data))								// if the credentials contain the user_data
			return true;												// return true

		return false;													// return false
	}

	/**
	 * Reads the credentials from a file called credentials.txt
	 * @return An ArrayList of credentials "username\tpassword"
	 */
	public ArrayList<String> loadCredentials(){
		ArrayList<String> credentials = new ArrayList<String>();	// create an ArrayList to hold the credentials

		try {														// try to read the file
			File file = new File("enciphered_credentials.txt");		// create a File object
			Scanner scanner = new Scanner(file);					// create a Scanner object to scan the file

			while (scanner.hasNextLine()) {							// loop while there is another line in the file
				String credential = scanner.nextLine();				// read the next line from the file
				credentials.add(credential);						// add the credential to the ArrayList
			}
			scanner.close();										// close the Scanner object
		} catch (FileNotFoundException e) {							// catch the exception if the file is not found
			System.out.println("File not found: " + e.getMessage());// print an error message
		}

		return credentials;											// return the ArrayList of credentials
	}

} // end class
