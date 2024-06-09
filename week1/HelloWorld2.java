import java.util.Scanner;

public class HelloWorld2{

    /*method to display 
 The java class path (This may show up as a single . )
 The java home
 The java version
 Your operating system architecture
 Your operating system version
 The current working directory
   
 The user home directory
 The user account name 
*/
    public static void properties(){
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(System.getProperty("java.home"));       
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("os.arch"));
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.name"));

    }

    public static void main(String[] args) {
        // create object of scanner class
        Scanner scanner = new Scanner(System.in);
        
        // tells scanner to accept user input and store in name
        String name = scanner.nextLine();
        
        //print message with user input
        System.out.println("Hello " + name + ". Nice work processing the arguments!");
        
        // calls the method that displays properties. No object need because it is static
        properties();
        
        
    }
    
}