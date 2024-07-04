/*
 * This program reads a file of ip addresses and counts the number of addresses from China in October 2019
 * 
 * The file is comma delimited and the last two characters of each line are the country code
 * 
 * 		File Stucture: MM/DD/YYYY,IP_Address,Country_Code
 * 		Example: 10/4/2019,87.143.169.254,CN
 * 		Meaning: An attempt to access our server from this address on October 4th, 2019
 * 		Note: The country code is a two character code
 * 
 * File name is passed as a command line argument. Program will abort if no file is specified
 *
 */

import java.util.Scanner;
import java.io.IOException;
import java.io.FileReader;

public class ScannerFileDemo{

	public static void main(String[] args){

		if(args.length == 0){ // check for command line args
			System.out.println("No file specified . . . aborting");
			//return;
		}
		String fileName	= "ip_logs.txt"; //args[0];	// get the file name from command line args
		String line		= "";		// declare a string to hold each line
		int chinaCount	= 0;		// declare a counter for China

		try {
			FileReader fileReader		= new FileReader(fileName);	// create a file reader object
			java.util.Scanner scanner	= new Scanner(fileReader);	// Scan the file reader
			scanner.useDelimiter(",");								// have scanner use , as a delimiter

			while (scanner.hasNext()) {								// use boolean method hasNext to control while loop     
				line = scanner.nextLine();							// read a line
				String country = line.substring(line.length() - 2);	// extract the country code
				if(country.equals("CN")){							// China? then extract the address
					chinaCount++;
					// extract ip address
					String[] tokens	= line.split(",");				// split on commas
					String[] date	= tokens[0].split("/");		// split on back slashes
					String ip		= tokens[1];					// ip address is 2nd element
					if(date[0].equals("10") && date[2].equals("2019"))	// check for October 2017
						System.out.printf("%-10s: %s %s\n", tokens[0], country, ip);  
				}
			}
			System.out.println("There were " + chinaCount + " ip addresses logged from China");
			scanner.close();										// close the resource
		}catch(IOException ioe){
			System.out.println("There was a problem opening the file");
		}
	} // end main
} // end class

