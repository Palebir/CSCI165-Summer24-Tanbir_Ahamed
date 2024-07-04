import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/* 
	import java.io.*; 
	You can import all IO classes in one statement
	But this decreases readability
*/

public class CombineTwoFiles{
	/*
		This program will combine the contents of the files

		1) ips.txt
		2) macs.txt

		into a new file whose name will be passed in as a command
		line argument
	*/
	public static void main(String[] args) {
		// FAIL FIRST, FAIL FAST
		if(args.length != 3) return;

		// get the command line args
		String inputFile1 = args[0];	// name of the first file to combine
		String inputFile2 = args[1];	// name of the second file to combine
		String outputFile = args[2];	// name of the new file to hold the combination

		/*
		 * Because main is "static" (does NOT require an instance to invoke) and the method
		 * "combineTwoFiles" is "not static" (DOES require an instance) we must create an instance
		 * of the "LoadTwoFiles" class before we can call the method from main 
		 * 
		 * Start to Memorize
		 * 	1) Static Things: 		Are "owned" by the class and do NOT need an instance
		 * 							can be called via the class name
		 * 	2) Non-Static Things:	Are "owned" by instances of classes and DO require an instance to be called
		*/
		CombineTwoFiles c2f = new CombineTwoFiles();	// create an instance of the class
		c2f.combine(inputFile1, inputFile2, outputFile);// call the method
	}

	public void combine(String fileOne, String fileTwo, String outputFile){
		/*
		 * Having Java connect to a file requires try/catch exception handling
		 * because there is a possibility that a FileNotFound exception can be "thrown"
		 */
		try{
			// define File objects for each stream connection
			File ip_input	= new File(fileOne);
			File mac_input	= new File(fileTwo);
			File output		= new File(outputFile);

			// define Scanner objects for the input streams
			Scanner ip_scanner	= new Scanner(ip_input);
			Scanner mac_scanner	= new Scanner(mac_input);

			// create parallel arrays to associate the IP with the Mac Address
			String[] ips	= new String[100];
			String[] macs	= new String[100];

			// while loop based on contents of both files. Loop will exit
			// upon exhaustion of the shortest file
			int index = 0;
			while(ip_scanner.hasNext() && mac_scanner.hasNext()){
				ips[index]	= ip_scanner.next(); // read single String token and advance the cursor
				macs[index]	= mac_scanner.next();// read single String token and advance the cursor
				++index;
			} // end while loop

			// CLOSE INPUT STREAMS
			ip_scanner.close();
			mac_scanner.close();

			// combine and write data to new file
			// define a FileWriter object for the output stream
			FileWriter combined_output = new FileWriter(output);
			for (index = 0; index < macs.length && index < ips.length; ++index)
				combined_output.write(ips[index] + "\t==>\t" + macs[index] + "\n"); // write to output stream
			
			combined_output.close(); // close output stream

		// You can independently catch multiple types of exceptions from a 
		// single try block
		// Identify if a file could not be opened
		}catch(FileNotFoundException fnfe){
			System.out.println("One of the files could not be opened");
			System.out.println(fnfe.getMessage());
		}
		// be careful with I/O operations
		catch (IOException ioe){
			System.out.println("There was a problem with an I/O operation");
			System.out.println(ioe.getMessage());
		}
	}
}