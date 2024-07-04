public class DateDriver{

    public static void main(String[] args){
        
        // create a Date instance using the default constructor
        Date d = new Date();
        Date d2 = new Date();

        // set d to 1/2/2020
        d.setMonth(2);
        d.setDay(27);
        d.setYear(2023);

		System.out.println(d.toString());
		d.setFormat(Date.DateFormat.SHORT_DATE);
		System.out.println(d.toString());

        // set d2 to 1/2/2020
        d2.setMonth(2);
        d2.setDay(27);
        d2.setYear(2023);

        // test using ==
        System.out.print("\nUsing == ");
        if(d == d2) System.out.println(d + " does equal " + d2);
        else System.out.println(d + " does not equal " + d2);

        // test using equals method
         System.out.print("Using .equals ");
        if(d.equals(d2)) System.out.println(d + " does equal " + d2);
        else System.out.println(d + " does not equal " + d2);
    }
}
