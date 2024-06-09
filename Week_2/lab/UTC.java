import java.util.Calendar;

public class UTC {

    // constants for raw time conversion
    // these must be static because they will be called from a "static context" => main
    static final int MILLISECONDS = 1;
    static final int MIL_PER_SEC = MILLISECONDS * 1000;
    static final int MIL_PER_MIN = MIL_PER_SEC * 60;
    static final int MIL_PER_HOUR = MIL_PER_MIN * 60;
    static final int MIL_PER_DAY = MIL_PER_HOUR * 24;

    public static void main(String[] args) {

        // get the command line argument, convert to an integer
        int offset = Integer.parseInt(args[0]);

        // calculate the current time in milliseconds since the Unix epoch
        long millis = System.currentTimeMillis();

        // add the time zone offset to the current time
        millis += offset * MIL_PER_HOUR;

        // calculate the number of days since the Unix epoch
        long days = millis / MIL_PER_DAY;

        // calculate the remaining milliseconds after accounting for the number of days
        millis %= MIL_PER_DAY;

        // calculate the number of hours, minutes, and seconds
        int hours = (int) (millis / MIL_PER_HOUR);
        millis %= MIL_PER_HOUR;
        int minutes = (int) (millis / MIL_PER_MIN);
        millis %= MIL_PER_MIN;
        int seconds = (int) (millis / MIL_PER_SEC);

        // print the time in HH:MM:SS format
        System.out.printf("%02d:%02d:%02d%n", hours, minutes, seconds);
    }
}