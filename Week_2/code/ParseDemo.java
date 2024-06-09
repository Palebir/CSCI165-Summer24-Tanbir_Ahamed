/*
 * Some Java packages have to be imported. Some do not
 * The "java.lang" package is automatically imported
 * Classes within this package can be used immediately
 * Check the API for details: https://docs.oracle.com/en/java/javase/21/docs//api/index.html
 * 
 */

public class ParseDemo {
	public static void main(String[] args) {

		// this program requires two arguments on the command line
		// it will convert the Strings to ints or floats
		// and demonstrate some math operations
		if (args.length != 2) {
			System.out.println("This program requires two command-line arguments.");
			return;
		}

		// convert strings to numbers
		//float a = Float.parseFloat(args[0]);	// if the method is static
		//float b = Float.parseFloat(args[1]);	// just reference through the class name
												// no reference variable or object needed

		int a = Integer.parseInt(args[0]);
		int b = Integer.parseInt(args[1]);
		
		// do some arithmetic
		// the type of the result is the same as the type of the operands
		// if operands are mixed types, the smaller type is promoted to the larger type
		// if using floats, you have to change the format specifier to %f instead of %d
		System.out.printf("a = %d, b = %d\n", a, b);
		System.out.printf("%d + %d = %d\n", a, b, a + b);
		System.out.printf("%d - %d = %d\n", a, b, a - b);
		System.out.printf("%d * %d = %d\n", a, b, a * b);
		System.out.printf("%d / %d = %d\n", a, b, a / b);
		System.out.printf("%d %% %d = %d\n", a, b, a % b);
	}
}
