/*
 * File:        Fraction.java
 * Author:      Ken Whitener
 * Modified By: <Tanbir Ahamed>
 * Date:        February 25, 2024
 * 
 * This file contains the definition of a class that represents a fraction.
 * 
 * TASK:    Complete the implementation of the Fraction class as described in the comments below.
 *          Respond to each TO DO comment by implementing the described functionality.
 * 
 *          Add your name to the "Modified By" line above.
 */

 public class Fraction implements Comparable<Fraction> {

    // +============================+
    // | PRIVATE INSTANCE VARIABLES |
    // +============================+
    private int numerator;    // the numerator of the fraction

    // TO DO: add a private int instance variable for the denominator
    private int denominator;  // the denominator of the fraction

    // +==============+
    // | CONSTRUCTORS |
    // +==============+

    /**
     * Fraction constructor that takes 2 arguments
     * 
     * @param n the numerator of the fraction
     * @param d the denominator of the fraction
     */
    public Fraction(int n, int d) {
        // TO DO: implement this constructor.
        // denominator should not be set to 0. If it is, set it to 1
        // but you may not duplicate validation code in the constructor
        this.numerator = n;
        setDenominator(d); // Validate the denominator using the setter method
        reduce(); // Reduce the fraction to its simplest form
    }

    // TO DO: add a constructor that takes 1 argument (the numerator) and sets the denominator to 1

    /**
     * Constructor to create a Fraction with the given numerator and a denominator of 1.
     * 
     * @param n the numerator of the fraction
     */
    public Fraction(int n) {
        this(n, 1);
    }

    // +=========================+
    // | PUBLIC INSTANCE METHODS |
    // +=========================+

    /**
     * Sets the numerator of the fraction
     * 
     * @param n the new numerator
     */
    public void setNumerator(int n) {
        // TO DO: implement this method
        this.numerator = n;
        reduce();
    }

    /**
     * 
     * @return the numerator of the fraction
     */
    public int getNumerator() {
        // TO DO: implement this method
        return numerator;
    }

    // TO DO: add a method to set the denominator of the fraction
    //        prevent the denominator from being set to 0.
    //        Set it to 1 if so. Call this method from the constructor to validate the denominator.

    /**
     * Sets the denominator of the fraction.
     * Prohibits the denominator from being set to 0. If set to 0, sets it to 1.
     * 
     * @param d the new denominator
     */
    public void setDenominator(int d) {
        if (d == 0) {
            d = 1; // Set to 1 if denominator is 0
        }
        this.denominator = d;
        reduce();
    }

    // TO DO: add a method to get the denominator of the fraction

    /**
     * 
     * @return the denominator of the fraction
     */
    public int getDenominator() {
        return denominator;
    }

    /**
     * Method to add a fraction to this fraction
     * 
     * @param f the fraction to add
     */
    public void add(Fraction f) {
        // TO DO: implement this method
        this.numerator = this.numerator * f.denominator + f.numerator * this.denominator;
        this.denominator = this.denominator * f.denominator;
        reduce();
    }

    // TO DO: add a void method to subtract a fraction from this fraction

    /**
     * Method to subtract a fraction from this fraction
     * 
     * @param f the fraction to subtract
     */
    public void subtract(Fraction f) {
        this.numerator = this.numerator * f.denominator - f.numerator * this.denominator;
        this.denominator = this.denominator * f.denominator;
        reduce();
    }

    // TO DO: add a void method to multiply this fraction by another fraction

    /**
     * Method to multiply this fraction by another fraction
     * 
     * @param f the fraction to multiply by
     */
    public void multiply(Fraction f) {
        this.numerator = this.numerator * f.numerator;
        this.denominator = this.denominator * f.denominator;
        reduce();
    }

    // TO DO: add a void method to divide this fraction by another fraction

    /**
     * Method to divide this fraction by another fraction
     * 
     * @param f the fraction to divide by
     */
    public void divide(Fraction f) {
        if (f.numerator == 0) {
            throw new IllegalArgumentException("Cannot divide by a fraction with numerator zero.");
        }
        this.numerator = this.numerator * f.denominator;
        this.denominator = this.denominator * f.numerator;
        reduce();
    }

    // TO DO: add a void method to reduce the fraction to lowest terms

    /**
     * Reduces the fraction to its simplest form.
     */
    private void reduce() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
        // Ensure the denominator is positive
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    /**
     * 
     * @return the value of the fraction as a double
     */
    public double toDecimal() {
        // TO DO: implement this method
        return (double) numerator / denominator;
    }

    /**
     * 
     * @return the value of the fraction as a string "numerator/denominator"
     */
    public String toString() {
        // TO DO: implement this method
        return numerator + "/" + denominator;
    }

    /**
     * Determines if this fraction is equal to another fraction
     * 
     * @param f the fraction to compare to
     * @return true if the fractions are equal, false otherwise
     */
    public boolean equals(Fraction f) {
        // TO DO: implement this method
        if (f == null) return false;
        return this.numerator == f.numerator && this.denominator == f.denominator;
    }

    /**
     * Compares this fraction to another fraction to determine lexical ordering
     * 
     * @param f the fraction to compare to
     * @return -1 if this fraction is less than f, 0 if they are equal, 1 if this fraction is greater than f
     */
    public int compareTo(Fraction f) {
        // TO DO: implement this method
        int thisNumerator = this.numerator * f.denominator;
        int otherNumerator = f.numerator * this.denominator;
        return Integer.compare(thisNumerator, otherNumerator);
    }

    // +=================+
    // | PRIVATE METHODS |
    // +=================+

    // In practice we do not document private methods using javadoc comments
    // because they are not part of the public interface of the class.

    /**
     * Calculates the greatest common divisor of two integers.
     * 
     * @param a the first integer
     * @param b the second integer
     * @return the greatest common divisor
     */
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }
}
