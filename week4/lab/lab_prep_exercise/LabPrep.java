import java.util.ArrayList;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;

public class LabPrep{

    public static void main(String[] args) {
        String r = transliterate(487692);
        ArrayList<String> result = loadData();
        writeToFile(result);
    }

    public static String transliterate(int number){
        String symbols      = "*BEA@FK%RM"; // define symbol table
        String string_input = "" + number;  // convert input to a string
        String encoded      = "";           // VARIABLE to hold converted output
        
        // iterate through my input 487692
        for(int index = 0; index < string_input.length(); ++index){
            char digit  = string_input.charAt( index );  // get the current digit as a character
            int num     = Character.getNumericValue(digit); // get the numeric value
            char symbol = symbols.charAt(num);          // get the substitution character
            encoded     += String.valueOf(symbol);      // convert to a string and concatenate
        }

        return encoded;
    }

    public static ArrayList<String> loadData(){
        ArrayList<String> data = new ArrayList<String>();

        try{
            File input_file = new File("numbers.txt");
            Scanner file_scanner = new Scanner(input_file);
            while( file_scanner.hasNext() ){
                int n = file_scanner.nextInt(); // read and convert
                String n_String = transliterate(n);
                data.add(n_String);
            }
            file_scanner.close();
        }catch(IOException ioe){
            System.out.println("PROBLEM");
        }

        return data;
    }

    public static void writeToFile(ArrayList<String> data){
        try{
            File output_file = new File("output.txt");
            PrintWriter writer = new PrintWriter(output_file);

            for( String s : data){
                writer.println(s);
            }

            writer.close();
        }catch(IOException ioe){
            System.out.println("Problem");
        }
    }
}