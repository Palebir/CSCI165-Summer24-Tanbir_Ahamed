import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class DateTests {

	Date testDate;

	@BeforeEach
	public void setup(){
		testDate = new Date(2, 27, 2023);
	}

	@Test
	public void testSetMonth(){
		int og_month = testDate.getMonth();	// get original month
		testDate.setMonth("Jimuary");		// try to set invalid month
		int testMonth = testDate.getMonth();// ask for the month again, make sure it didn't change
		assertEquals(testMonth, og_month);	// use assertion for test feedback

		og_month = testDate.getMonth();
		testDate.setMonth(13);
		testMonth = testDate.getMonth();
		assertEquals(testMonth, og_month);

		og_month = testDate.getMonth();
		testDate.setMonth(-1);
		testMonth = testDate.getMonth();
		assertEquals( testMonth, og_month );

		// POSITIVE TESTS
		int newMonth = 3;
		testDate.setMonth( newMonth) ;
		testMonth = testDate.getMonth();
		assertEquals( testMonth, newMonth );

		newMonth = 8;
		testDate.setMonth( "August") ;		// try to set valid month
		testMonth = testDate.getMonth();	// ask for the month again, make sure it didn't change
		assertEquals( testMonth, newMonth );	// use assertion for test feedback
	}

	@Test
	public void testEquals(){
		Date copyDate = new Date(	// clone our test Date
									testDate.getMonth(),
									testDate.getDay(),
									testDate.getYear()
								);
		// TEST EQUALITY						
		assertTrue( testDate.equals( copyDate ) );	// test with two distinct objects
		
		copyDate = testDate;
		assertTrue( testDate.equals( copyDate ) );	// test with identical objects

		// TEST INEQUALITY
		copyDate = new Date(2, 28, 2023);			// test with same date but different day
		assertFalse( testDate.equals( copyDate ) );

		copyDate.setDay( testDate.getDay() );		// test with same date but different month
		copyDate.setMonth(8);
		assertFalse( testDate.equals( copyDate ) );

		copyDate.setMonth( testDate.getMonth() );	// test with same date but different year
		copyDate.setYear(2022);
		assertFalse( testDate.equals( copyDate ) );

		// Test null pointer
		copyDate = null;
		assertFalse( testDate.equals( copyDate ) );
	}

	@Test
	public void testCompareTo(){

		// compareTo based on days
		Date dateToCompare = new Date(2, 26, 2023); // comes before
		assertEquals( testDate.compareTo( dateToCompare ), 1);
		dateToCompare.setDay(28);					// comes after
		assertEquals( testDate.compareTo( dateToCompare ), -1);

		// compareTo based on year
		dateToCompare = new Date(2, 27, 2022);		// comes before
		assertEquals( testDate.compareTo( dateToCompare ), 1);
		dateToCompare.setYear(2024);				// comes after
		assertEquals( testDate.compareTo( dateToCompare ), -1);

		// compareTo based on month
		dateToCompare = new Date(1, 27, 2022);		// comes before
		assertEquals( testDate.compareTo( dateToCompare ), 1);
		dateToCompare.setMonth(3);					// comes after
		assertEquals( testDate.compareTo( dateToCompare ), -1);
	}
	
}
