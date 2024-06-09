public class Initials {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Please provide a name as a command line argument.");
            return;
        }

        // Get the name from the command line argument
        String name = args[0];

        // Extract the first character of the first name
        char firstNameInitial = name.charAt(0);

        // Extract the first character of the last name
        int spaceIndex = name.indexOf(' ');
        char lastNameInitial = name.charAt(spaceIndex + 1);

        // Print the characters individually, followed by periods
        System.out.println("Initials: " + firstNameInitial + ". " + lastNameInitial + ".");

        // Print the numeric values of the characters (Unicode value)
        System.out.println("Unicode values: " + (int) firstNameInitial + " " + (int) lastNameInitial);

        // Print the sum of the numeric values
        System.out.println("Sum of Unicode values: " + ((int) firstNameInitial + (int) lastNameInitial));

        // Print the characters concatenated together as a String
        System.out.println("Concatenated: " + firstNameInitial + lastNameInitial);
    }
}