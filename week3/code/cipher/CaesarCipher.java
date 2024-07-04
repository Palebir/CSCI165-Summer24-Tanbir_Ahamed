/*
 * In cryptography, a Caesar cipher, also known as Caesar's cipher, the shift cipher, Caesar's code, or Caesar shift, 
 * is one of the simplest and most widely known encryption techniques. It is a type of substitution cipher in which 
 * each letter in the plaintext is replaced by a letter some fixed number of positions down the alphabet. 
 * 
 * For example, with a left shift of 3, D would be replaced by A, E would become B, and so on. 
 * The method is named after Julius Caesar, who used it in his private correspondence.
 * 
 * The encryption step performed by a Caesar cipher is often incorporated as part of more complex schemes, 
 * such as the Vigenère cipher, and still has modern application in the ROT13 system. 
 * As with all single-alphabet substitution ciphers, the Caesar cipher is easily broken and in modern practice
 * offers essentially no communications security.
 * 
 * (But is pretty cool for learning about encryption and decryption) <-- my comment
 * (And it's a good example of a simple class) <-- my comment
 * (And it's a good example of string manipulation) <-- my comment
 * 
 * https://en.wikipedia.org/wiki/Caesar_cipher
 */

public class CaesarCipher{
	/**
	 * Creates a character array of all lowercase letters a - z
	 * This forms the valid password character set
	 * 
	 * @return The array of lowercase alphabet as String
	 */
	private String character_set(){
		// define our password character set
		String char_set  = "abcdefghijklmnopqrstuvwxyz";	// lowrcase alphabet
		char_set 		+= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";	// uppercase alphabet
		char_set 		+= "0123456789";					// numbers
		char_set 		+= "_!@$";							// special characters
		return 			char_set;
	}
	
	/**
	 * Performs caeser cipher encryption on a word
	 * 
	 * @param word	the word to encipher
	 * @return		the enciphered word
	 */
	public String encipher(String word){
		char[] wordArray= word.toCharArray();						// convert String to character array
		String char_set	= character_set();							// get the alphabet from our helper method
		int ROTATION 	= char_set.length() / 2;					// define the rotation
		for(int index = 0; index < wordArray.length; ++index){		// loop "length of word" times
			int current = char_set.indexOf( wordArray[index] );		// calculate the index of the character to encrypt
			int next	= (current + ROTATION) % char_set.length();	// calculate the index of the substitution character. Wrap around if neccessary
			wordArray[ index ] = char_set.charAt(next);				// Replace the character in the array
		}
		return String.valueOf(wordArray);							// convert the array to a String object and return
	}
}