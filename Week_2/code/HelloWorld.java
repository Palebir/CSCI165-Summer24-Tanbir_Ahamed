/*
	multi-line comment
	99% of your Java files will be a class
	Classes are blueprints for objects
	if the class is declared "public", then the file name MUST MATCH
	This file is named HeloWorld.java

	To run this file, you must compile it first
	To compile, open a terminal and navigate to the directory containing this file
		type: javac HelloWorld.java
	This will create a file named HelloWorld.class
	To run the compiled file 
		type: java HelloWorld
 */
public class HelloWorld{	// blocks of code are enclosed in curly braces

	// Java apps require a starting point, that specifies where the program begins
	// That starting point is the "main method"
	// The signature MUST MATCH this exactly
	// or the runtime environment will not be able to find it
	// our first few exercises will require you to place all code in the main method
	public static void main(String[] args) {
		// Java is a "strict, statically typed" language
		// you must declare and associate a data type with variables and expressions
		// once a variable is declared, it's type cannot be changed

		// PRIMITIVE TYPES. These ARE NOT objects
		byte	a = 0;		// 8 bit signed integer
		short	b = 0;		// 16 bit signed integer
		int		c = 0;		// 32 bit signed integer
		long	d = 0;		// 64 bit signed integer

		float	e = 0;		// 32 bit signed floating point
		double	f = 0;		// 64 bit signed floating point

		char	g = 'A';	// 16 bit unsigned integer. Single unicode character

		boolean h = true;	// 8 bit boolean value

		// OBJECTS
		String	i = "Text";			// variable length string OBJECT
		int		l = i.length();		// get the length of the string
									// objects use "dot notation" to reference properties
									// consult the API docs to discover the details of Java objects
		char first = i.charAt(0);	// grab the first character of a string using the charAt method
									// this will return a char primitive
									// be sure to use the correct data type

		// loop through the string and print each character
		for (int j = 0; j < i.length(); j++) {	// for loop header: j is the counter, i.length() is the limit, j++ is the increment
			System.out.println(i.charAt(j));	// print each character
		}										// end for loop body with a curly brace

		// this is the console output routine
		// System is a class that encapsulates system meta data
		// it contains an Output Stream object named "out"
		// this object has a method called "println" . . . print line, with line break
		System.out.println("The first character is: " + first);
	} // end main
} // end class