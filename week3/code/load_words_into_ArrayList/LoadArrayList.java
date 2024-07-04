import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class LoadArrayList{
	/*
	 * Class demonstrates loading the contents of a text file into an ArrayList of Strings
	 * Text file is one complete word per line
	 * 
	 * Also demonstrates the classic "most used letter" algorithm two ways
	 * 
	 * 	1) Histogram using an array of counts
	 * 	2) HashMap of Character -> Integer key, value pairs
	 * 
	 * Note: HashMap (or Map) is the actual type that is used to implement Python Dictionaries
	 * 
	 * Also demonstrates static method declarations that can be called from main without an instance
	 * Notice that you have to explicitly state the parameter and return types
	 */

	public static void main(String[] args) {
		if(args.length != 1) return; // FAIL FIRST, FAIL FAST (comment this out when using the debugger)

		//ArrayList<String> dictionary = loadWords( "EnglishWords.txt" ); // uncomment this to use the debugger
		ArrayList<String> dictionary = loadWords( args[0] ); // can directly call static methods from main

		int length = dictionary.size();
		System.out.printf("There are %d words in the file\n", length);

		char should_be_e = mostUsedLetterUsingHistogram(dictionary); // can directly call static methods from main
		System.out.printf("Most used character in the file is '%c'\n", should_be_e);

		should_be_e = mostUsedLetterUsingMap(dictionary); // can directly call static methods from main
		System.out.printf("Most used character in the file is '%c'\n", should_be_e);
	}

	/**
	 * Loads the contents of specified file into an ArrayList
	 * 
	 * @param fileName The file to open
	 * @return an ArrayList of the words in fileName
	 */
	public static ArrayList<String> loadWords(String fileName){
		
		ArrayList<String> words = new ArrayList<String>(); // create an instance of the ArrayList class
		try{
			File file 			= new File(fileName);		// create a File object
			Scanner fileScanner = new Scanner(file);		// Create a scanner for the file object
			String word 		= "";						// string variable to hold a word

			while( fileScanner.hasNext() ){					// while the file has more tokens
				word = fileScanner.next();					// grab the next token
				words.add(word);							// add it to the ArrayList
			}
			fileScanner.close();							// close the scanner object
			
		}catch(FileNotFoundException fnfe){
			System.out.println("Problem opening the file: " + fnfe.getMessage());
		}
		return words;	
	}

	/**
	 * Determines the most used letter in a list of N words using a histogram
	 * Algorithm assumes only lower case letters
	 * 
	 * @param words The list of words to process
	 * @return The most used character
	 */
	public static char mostUsedLetterUsingHistogram(ArrayList<String> words){
		int[] counts	= new int[26];						// histogram
		final int BIAS	= (int)'a';							// normalize 'a' -> 0

		for(String s : words)								// for each word in list
			for(int index = 0; index < s.length(); ++index)	// for each char in word
				++counts[ s.charAt( index ) - BIAS ];		// count it
		
		int maxCount = counts[0];							// track the max count
		int maxIndex = 0;									// also need the index as it is the code point
		for(int index = 1; index < counts.length; ++index)	// loop through the array
			if(counts[ index ] > maxCount){					// is current count lrager than current max?
				maxCount = counts[ index ];					// then replace it
				maxIndex = index;							// remember the position
			}
		return (char)(maxIndex + BIAS);						// return char
	}

	/**
	 * Determines the most used letter in a list of N words using a hash map
	 * 
	 * @param words The list of words to process
	 * @return The most used character
	 */
	public static char mostUsedLetterUsingMap(ArrayList<String> words){
		// create an instance of the HashMap class. Cannot use primitives
		// for K and V, so use wrapper classes instead
		// This is analogous to Python's Dictionary: Character (key) -> Integer (value)
		HashMap<Character, Integer> counts = new HashMap<Character, Integer>();

		for(String s : words)								// for each word in list
			for(int index = 0; index < s.length(); ++index){// for each char in word
				char current = s.charAt( index ) ;			// get current character
				if(counts.containsKey( current ) ){			// character already in map?
					Integer count = counts.get(current);	// get current count for character
					counts.replace(current, count + 1);		// replace with new count
				}
				else counts.put(current, 1);				// character not in map, put it there
			}
		
		char most	= 0;									// store most used char
		int max		= 0;									// tracks the counts for max algorithm
		for(Character c : counts.keySet() ){				// for each key in the map
			int current = counts.get( c );					// get the value for the current key
			if( current > max ){							// is it bigger than the current max?
				max = current;								// replace the count
				most = c;									// replace the char
			}
		}
		return most;
	}
}
