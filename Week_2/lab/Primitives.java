public class Primitives {
    public static void main(String[] args) {
        // Define and initialize variables of each of the Java primitive types
        byte byteValue = 127;
        short shortValue = 3276;
        int intValue = 23;
        long longValue = 999999999L;
        float floatValue = 3.40f;
        double doubleValue = 1.798;
        boolean booleanValue = true;
        char charValue = 'A';

        // Print each value with a descriptive method using printf
        System.out.printf("byteValue: %d%n", byteValue);
        System.out.printf("shortValue: %d%n", shortValue);
        System.out.printf("intValue: %d%n", intValue);
        System.out.printf("longValue: %d%n", longValue);
        System.out.printf("floatValue: %f%n", floatValue);
        System.out.printf("doubleValue: %f%n", doubleValue);
        System.out.printf("booleanValue: %b%n", booleanValue);
        System.out.printf("charValue: %c%n", charValue);

        // Demonstrate both character and numeric literals for the char type
        char charValueNumeric = 65;
        System.out.printf("charValueNumeric: %c%n", charValueNumeric);

        // Perform a series of implicit widening casts and explicit narrowing casts
        byte byteValue2 = 127;
        short shortValue2 = byteValue2; // implicit widening cast
        int intValue2 = shortValue2; // implicit widening cast
        long longValue2 = intValue2; // implicit widening cast
        float floatValue2 = longValue2; // implicit widening cast
        double doubleValue2 = floatValue2; // implicit widening cast

        // Print the values
        System.out.println("byteValue2: " + byteValue2);
        System.out.println("shortValue2: " + shortValue2);
        System.out.println("intValue2: " + intValue2);
        System.out.println("longValue2: " + longValue2);
        System.out.println("floatValue2: " + floatValue2);
        System.out.println("doubleValue2: " + doubleValue2);

        // Narrowing casts
        byte byteValueNarrowed = (byte) intValue2; // explicit narrowing cast
        short shortValueNarrowed = (short) intValue2; // explicit narrowing cast
        int intValueNarrowed = (int) longValue2; // explicit narrowing cast
        long longValueNarrowed = (long) floatValue2; // explicit narrowing cast
        float floatValueNarrowed = (float) doubleValue2; // explicit narrowing cast

        // Print the values
        System.out.println("byteValueNarrowed: " + byteValueNarrowed);
        System.out.println("shortValueNarrowed: " + shortValueNarrowed);
        System.out.println("intValueNarrowed: " + intValueNarrowed);
        System.out.println("longValueNarrowed: " + longValueNarrowed);
        System.out.println("floatValueNarrowed: " + floatValueNarrowed);

        // Create two variables of type int
        int intMinValue = Integer.MIN_VALUE;
        int intMaxValue = Integer.MAX_VALUE;

        // Print these values 
        System.out.println("intMinValue: " + intMinValue);
        System.out.println("intMaxValue: " + intMaxValue);

        // Create two variables of type long
        long longMinValue = Long.MIN_VALUE;
        long longMaxValue = Long.MAX_VALUE;

        // Print these values 
        System.out.println("longMinValue: " + longMinValue);
        System.out.println("longMaxValue: " + longMaxValue);

        // Show the difference between Integer.MAX_VALUE and Long.MAX_VALUE
        System.out.println("Integer.MAX_VALUE: " + Integer.MAX_VALUE);
        System.out.println("Long.MAX_VALUE: " + Long.MAX_VALUE);

        // Using a command line argument enter an integer when you run the program
        int inputValue = Integer.parseInt(args[0]);

        // Display the square, cube, and fourth power
        System.out.println("Square: " + Math.pow(inputValue, 2));
        System.out.println("Cube: " + Math.pow(inputValue, 3));
        System.out.println("Fourth Power: " + Math.pow(inputValue, 4));

        // Using command line arguments enter an integer dividend and divisor
        int dividend = Integer.parseInt(args[1]);
        int divisor = Integer.parseInt(args[2]);

        // Compute floor division and floor modulus
        double floorDivision = Math.floorDiv(dividend, divisor);
        int floorModulus = Math.floorMod(dividend, divisor);
    
    }
}