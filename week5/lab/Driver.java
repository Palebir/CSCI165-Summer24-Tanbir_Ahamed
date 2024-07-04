import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        // Create four Fraction instances. Be sure to demonstrate that your constructors can handle invalid denominators. Prove it.
        Fraction f1 = new Fraction(15, 25);
        Fraction f2 = new Fraction(10, 0); // Should set denominator to 1
        Fraction f3 = new Fraction(3);     // Should create 3/1
        Fraction f4 = new Fraction(5, 7);

        // Display fractions using toString to show reduction and proper handling
        System.out.println("Fraction f1 (should be reduced to 3/5): " + f1);
        System.out.println("Fraction f2 (should be 10/1): " + f2);
        System.out.println("Fraction f3 (should be 3/1): " + f3);
        System.out.println("Fraction f4: " + f4);

        // Call the various instance methods, passing in appropriate data
        f1.add(f4);
        System.out.println("After adding f4 to f1 (3/5 + 5/7): " + f1);

        f1.subtract(new Fraction(1, 2));
        System.out.println("After subtracting 1/2 from f1: " + f1);

        f1.multiply(new Fraction(2, 3));
        System.out.println("After multiplying f1 by 2/3: " + f1);

        f1.divide(new Fraction(4, 5));
        System.out.println("After dividing f1 by 4/5: " + f1);

        // Create a 100 element array of Fractions
        Fraction[] fractions = new Fraction[100];

        // Fill the array with 100 Fraction instances using the data in the file fractions.txt
        try {
            Scanner scanner = new Scanner(new File("fractions.txt"));
            int index = 0;
            while (scanner.hasNextLine() && index < 100) {
                String line = scanner.nextLine();
                String[] parts = line.split("/");
                int numerator = Integer.parseInt(parts[0]);
                int denominator = Integer.parseInt(parts[1]);
                fractions[index] = new Fraction(numerator, denominator);
                index++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("fractions.txt file not found.");
        }

        // Find the largest fraction in the array
        Fraction largest = largestFraction(fractions);
        System.out.println("The largest fraction in the array is: " + largest);
    }

    /**
     * Finds the largest Fraction in the array using compareTo.
     * 
     * @param fractions the array of Fraction objects
     * @return the largest Fraction in the array
     */
    public static Fraction largestFraction(Fraction[] fractions) {
        if (fractions == null || fractions.length == 0) {
            return null;
        }
        Fraction largest = fractions[0];
        for (Fraction fraction : fractions) {
            if (fraction != null && fraction.compareTo(largest) > 0) {
                largest = fraction;
            }
        }
        return largest;
    }
}
