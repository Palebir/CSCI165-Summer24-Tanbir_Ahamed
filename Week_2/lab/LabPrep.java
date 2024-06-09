/*
	Author:		Ken Whitener
	Date:		1/29/2024
	Subject:	Command line arguments, String methods, Integer class
*/
public class LabPrep{

	public static void main(String[] args) {
		
		/* 
			Run this program with 2 command line arguments:
				1) An integer
				2) A phone number in the format ###-#### 
				
			process first command line argument and convert to int
			let's assume the arg IS a number
			don't worry about testing the arg to see if it is numeric
		*/

		// Use the static parseInt method from the Integer class
		// The Integer class does not require an import statement
		int arg = Integer.parseInt(args[0]);

		// printf requires an explicit line break: \n
		System.out.printf("\nFirst argument: %d\n", arg);

		/*
			second arg is a phone number. Let's break it down
			using String methods. Research the API. Just for fun
			assume you do not know where the '-' is
		*/
		
		String	phone	= args[1];					// create a String object from arg
		int		dash	= phone.indexOf("-");		// find the dash
		String	prefix	= phone.substring(0, dash);	// slice off the prefix
		String	line	= phone.substring(dash + 1, phone.length()); // slice off line number 

		// print the results
		System.out.println("\nSecond argument: " + phone);	// use println and concatenation. line break automatic
		System.out.printf("Prefix: %s\n", prefix);			// use printf and explicit line break
		System.out.printf("Line Number: %s\n", line);		// use printf and explicit line break

		// sum the individual digits just for kicks
		int sum = 0;
		// use substring, which returns a String
		for (int i = 0; i < line.length(); i++) {
			// use Integer.parseInt() for the conversion
			sum += Integer.parseInt(line.substring(i, i + 1));
		}
		// use characters
		for(int i = 0; i < prefix.length(); i++) {
			// use Character.getNumericValue() for the conversion
			sum += Character.getNumericValue(prefix.charAt(i));
		}
		System.out.printf("Sum of digits: %d\n", sum);
	}
}