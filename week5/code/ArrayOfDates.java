public class ArrayOfDates {

	public static void main(String[] args) {
		// create an array of Date objects
		Date[] dates = new Date[5];

		// No actal objects were created though!
		// You have Null Pointers
		for (Date date : dates)
			System.out.println(date);

		// calling a method on a NULL pointer goes BOOM
		// System.out.println( dates[0].getDay() );

		// populate the array with valid Date objects
		dates[0] = new Date(1, 2, 2023);
		dates[1] = new Date(1, 3, 2023);
		dates[2] = new Date(1, 4, 2023);
		dates[3] = new Date(1, 5, 2023);
		dates[4] = new Date(1, 6, 2023);

		// now you have actual date objects
		// print them using for-each style iteration
		for (Date date : dates)
			System.out.println(date);

		// let's build January
		// need a regular for loop to get the index for assignment
		Date[] january = new Date[31];
		for (int day = 0; day < january.length; ++day)
			january[day] = new Date(1, day + 1, 2023);

		// Just printing? Use for-each style iteration
		System.out.println("\nJANUARY");
		for (Date day : january)
			System.out.println(day);

		// change the month to March
		// change the object's state by calling a method
		// can use either for-each or indexed for loop
		for (int day = 0; day < january.length; ++day)
			january[day].setMonth(3);

		System.out.println("\nMARCH");
		for (Date day : january)
			System.out.println(day);

		// change the year
		System.out.println("\nMARCH WITH CHANGED YEAR");
		for( Date d : january ){
			d.setYear(2038);
			System.out.println(d);
		}
	}
}
