import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ROT {
    public static void main(String[] args) {
        if (args.length!= 3) {
            System.out.println("Invalid number of arguments. Please provide a file name, an operation (e or d), and a number (13 or 47).");
            return;
        }

        String fileName = args[0];
        String operation = args[1];
        int rotNumber = Integer.parseInt(args[2]);

        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("The file " + fileName + " does not exist.");
            return;
        }

        if (!operation.equals("e") &&!operation.equals("d")) {
            System.out.println("Invalid argument. Please use e for encoding or d for decoding.");
            return;
        }

        if (rotNumber!= 13 && rotNumber!= 47) {
            System.out.println("Invalid number. Please use 13 or 47.");
            rotNumber = 13; // Default to ROT13
        }

        try {
            List<String> lines = Files.readAllLines(file.toPath());
            StringBuilder content = new StringBuilder();

            for (String line : lines) {
                content.append(line);
            }

            String encodedContent = applyROT(content.toString(), rotNumber);

            if (operation.equals("e")) {
                String encryptedFileName = fileName.replace(".txt", "_encrypted.txt");
                Files.write(Paths.get(encryptedFileName), encodedContent.getBytes());
            } else {
                String decryptedFileName = fileName.replace("_encrypted.txt", ".txt");
                Files.write(Paths.get(decryptedFileName), encodedContent.getBytes());
            }

        } catch (IOException e) {
            System.out.println("Error reading or writing to file: " + e.getMessage());
        }
    }

    public static String rotCharacterSet(int n) {
        StringBuilder rotChars = new StringBuilder();
        int startAscii;
        int endAscii;

        if (n == 47) {
            startAscii = 33;
            endAscii = 126;
        } else if (n == 13) {
            startAscii = 65;
            endAscii = 90;
        } else {
            return "Invalid input. Please use 13 or 47.";
        }

        for (int i = startAscii; i <= endAscii; i++) {
            rotChars.append((char) i);
        }

        return rotChars.toString();
    }

    public static String applyROT(String str, int n) {
        StringBuilder encodedStr = new StringBuilder();
        String rotAlphabet = rotCharacterSet(n);

        for (char c : str.toCharArray()) {
            if (rotAlphabet.indexOf(c)!= -1) {
                int newIndex = (rotAlphabet.indexOf(c) + n) % rotAlphabet.length();
                encodedStr.append(rotAlphabet.charAt(newIndex));
            } else {
                encodedStr.append(c);
            }
        }

        return encodedStr.toString();
    }
}