import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		String word = "";										// declare a String to hold the word to encipher
		if( args.length != 0)									// if the user entered a word as a command line argument
			word = args[0];										// get the word from the command line
		else{													// the user did not enter a word as a command line argument
			System.out.println("Enter a word to encipher: ");	// prompt the user for a word
			Scanner keyboard = new Scanner(System.in);			// create a Scanner object
			word = keyboard.nextLine();							// read the word from the user
			keyboard.close();									// close the Scanner object
		}

		CaesarCipher cipher	= new CaesarCipher();				// create an instance of the class
		String ciphered = cipher.encipher(word);				// call the encipher method to encrypt the word
		
		System.out.printf("%s enciphered is %s\n", word, ciphered);	// print the encrypted word
		word = cipher.encipher(ciphered);							// call the encipher method to decrypt the word
		System.out.printf("%s enciphered is %s\n", ciphered, word);	// print the decrypted word
	}	
}
