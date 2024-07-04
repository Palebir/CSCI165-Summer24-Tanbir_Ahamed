import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FractionTests {
	// these tests are not exhaustive, but they should be a good start
	// for testing the Fraction class
	Fraction a;		// Fraction object (null pointer until initialized with "new")
	Fraction b;		// Fraction object (null pointer until initialized with "new")

	
	@Test // test the setNumerator method
	void SetNumerator() {
		a = new Fraction( 8 );					// initialize the test Fraction object
		a.setNumerator( 25 );					// set the numerator to 25
		assertEquals( 25, a.getNumerator() );	// check that the numerator is 25 using assertion
	}

	@Test // test the setDenominator method
	void SetDenominator() {
		a = new Fraction( 1 );					// initialize the test Fraction object
		a.setDenominator( 378 );				// set the denominator to 378
		assertEquals( 378, a.getDenominator() );// check that the denominator is 378 using assertion

		a.setDenominator( 0 );					// set the denominator to 0. This should not be allowed
		assertEquals( 1, a.getDenominator() );	// check that the denominator is 1

	}

	@Test	// test the getNumerator method
	void GetNumerator() {
		a = new Fraction( 2 );					// initialize the test Fraction object
		assertEquals( 2, a.getNumerator() );	// check that the numerator is 2
	}

	@Test // test the getDenominator method
	void GetDenominator() {
		a = new Fraction( 1, 5 );			// initialize the test Fraction object
		assertEquals( 5, a.getDenominator() );	// check that the denominator is 5
	}

	@Test // test the toString method
	void ToString() {
		// Fraction should be reduced
		a = new Fraction( 2, 4 );			// initialize the test Fraction object
		assertEquals( "1/2", a.toString() );	// check that the string representation is "1/2"

		a.setNumerator(-4);					// set the fraction to -4/8
		a.setDenominator(8);
		assertEquals( "-1/2", a.toString() );	// check that the string representation is "-1/2"
	}

	@Test	// test the equals method
	void Equals() {
		// Fractions should be reduced
		a = new Fraction( 2, 4 );			// initialize first test Fraction object
		b = new Fraction( 16, 32 );			// initialize second test Fraction object

		assertTrue( a.equals( b ) );			// check that the two fractions are equal
		assertTrue( b.equals( a ) );			// check that the two fractions are equal

		b.setNumerator(1);					// set the second fraction to 1/3
		b.setDenominator(3);
		assertTrue( !a.equals( b ) );			// check that the two fractions are not equal
	}

	@Test	// test the compareTo method
	void CompareTo() {
		// Fractions should be reduced
		a = new Fraction( 1, 2 );			// initialize first test Fraction object
		b = new Fraction( 3, 4 );			// initialize second test Fraction object

		int result = a.compareTo( b );			// compare the two fractions
		assertEquals( -1, result );				// check that the result is -1 (a < b)

		result = b.compareTo( a );				// compare the two fractions
		assertEquals( 1, result );				// check that the result is 1 (b > a)

		b.setNumerator(1);					// set the second fraction to 1/2
		b.setDenominator(2);

		result = a.compareTo( b );				// compare the two fractions	
		assertEquals( 0, result );				// check that the result is 0 (a == b)
		assertTrue( a.equals( b ) );			// check that the two fractions are equal
	}

	@Test	// test the reduce method
	void Reduction() {
		a = new Fraction( 16, 32 );			// initialize the test Fraction object
		a.reduce();								// reduce the fraction
		assertEquals(1, a.getNumerator() );		// check that the numerator is 1
		assertEquals(2, a.getDenominator() );	// check that the denominator is 2

		a.setNumerator( 11 );					// set the fraction to 28/42
		a.setDenominator( 17 );
		a.reduce();								// reduce the fraction
		assertEquals( 11, a.getNumerator() );	// check that the numerator is 2
		assertEquals( 17, a.getDenominator() );	// check that the denominator is 3

		a.setNumerator(6);					// set the fraction to 6/18
		a.setDenominator(18);
		a.reduce();								// reduce the fraction
		assertEquals( 1, a.getNumerator() );	// check that the numerator is 1
		assertEquals( 3, a.getDenominator() );	// check that the denominator is 3
	}

	@Test
	void Addition() {
		// Fractions should be reduced
		a = new Fraction( 3, 7 );			// initialize first test Fraction object
		b = new Fraction( 5, 16 );			// initialize second test Fraction object
		
		// 3/7 + 5/16 = 83/112
		b.add( a );								// add the two fractions
		assertEquals( 83, b.getNumerator() );	// check that the numerator is 83
		assertEquals( 112, b.getDenominator() );// check that the denominator is 112

		a = new Fraction( 1, 4 );			// initialize first test Fraction object
		b = new Fraction( 1, 8 );			// initialize second test Fraction object
		
		// 1/8 + 1/4 = 3/8
		b.add( a );								// add the two fractions
		assertEquals( 3, b.getNumerator() );	// check that the numerator is 3
		assertEquals( 8, b.getDenominator() );	// check that the denominator is 8
	}

	@Test
	void SignedAddition() {
		// Fractions should be reduced
		a = new Fraction( -4, 16 );			// initialize first test Fraction object
		b = new Fraction( 1, 2 );			// initialize second test Fraction object

		// 1/2 + (-4/16) = 1/4
		b.add( a );								// add the two fractions
		assertEquals( 1, b.getNumerator() );	// check that the numerator is 1
		assertEquals( 4, b.getDenominator() );	// check that the denominator is 4

		a = new Fraction( -3, 7 );			// initialize first test Fraction object
		b = new Fraction( 5, 6 );			// initialize second test Fraction object

		// 5/6 + (-3/7) = 17/42
		b.add( a );								// add the two fractions
		assertEquals(17,  b.getNumerator() );	// check that the numerator is 17
		assertEquals( 42, b.getDenominator() );	// check that the denominator is 42
	}

	@Test
	void Subtraction() {
		// Fractions should be reduced
		a = new Fraction( 8, 4 );				// initialize first test Fraction object
		b = new Fraction( 16, 2 );				// initialize second test Fraction object

		// 16/2 - 8/4 = 6
		b.subtract( a );						// subtract the two fractions
		assertEquals( 6, b.getNumerator() );	// check that the numerator is 6
		assertEquals( 1, b.getDenominator() );	// check that the denominator is 1

		a = new Fraction( 1, 4 );				// initialize first test Fraction object
		b = new Fraction( 1, 8 );				// initialize second test Fraction object

		// 1/8 - 1/4 = -1/8
		b.subtract( a );						// subtract the two fractions
		assertEquals( -1, b.getNumerator() );	// check that the numerator is -1
		assertEquals( 8, b.getDenominator() );	// check that the denominator is 8
	}

	@Test
	void SignedSubtraction() {
		a = new Fraction( -1, 4 );
		b = new Fraction( 1, 8 );

		// 1/8 - (-1/4) = 3/8
		b.subtract( a );

		assertEquals( 3, b.getNumerator() );
		assertEquals( 8, b.getDenominator() );
	}

	@Test
	void Multiplication() {
		a = new Fraction( 2, 3 );			// initialize first test Fraction object
		b = new Fraction( 9, 1 );			// initialize second test Fraction object

		// 9 * 2/3 = 6
		b.multiply( a );						// multiply the two fractions

		assertEquals( 6, b.getNumerator() );	// check that the numerator is 6
		assertEquals( 1, b.getDenominator() );	// check that the denominator is 1

		a = new Fraction( 5, 7 );			// initialize first test Fraction object
		b = new Fraction( 3, 8 );			// initialize second test Fraction object

		// 3/8 * 5/7 = 15/56
		b.multiply( a );						// multiply the two fractions

		assertEquals( 15, b.getNumerator() );	// check that the numerator is 15
		assertEquals( 56, b.getDenominator() );	// check that the denominator is 56
	}

	@Test
	void Division() {
		a = new Fraction( 1, 2 );			// initialize first test Fraction object
		b = new Fraction( 1, 2 );			// initialize second test Fraction object

		// 1/2 / 1/2 = 1
		b.divide( a );							// divide the two fractions

		assertEquals( 1, b.getNumerator() );	// check that the numerator is 1
		assertEquals( 1, b.getDenominator() );	// check that the denominator is 1

		a = new Fraction( 5, 7 );			// initialize first test Fraction object
		b = new Fraction( 3, 8 );			// initialize second test Fraction object

		// 3/8 / 5/7 = 21/40
		b.divide( a );							// divide the two fractions

		assertEquals( 21, b.getNumerator() );	// check that the numerator is 21
		assertEquals( 40, b.getDenominator() );	// check that the denominator is 40
	}
}
