import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class KeywordCipher {

    private static String cipherAlutter;

    public static void main(String[] args) {
        if (args.length!= 3) {
            System.out.println("Invalid number of arguments. Please provide a file name, a keyword, and an operation (e or d).");
            return;
        }

        String fileName = args[0];
        String keyword = args[1];
        String operation = args[2];

        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("The file " + fileName + " does not exist.");
            return;
        }

        try {
            List<String> lines = Files.readAllLines(file.toPath());
            StringBuilder content = new StringBuilder();

            for (String line : lines) {
                content.append(line);
            }

            String cipherAlphabet = generateCipherAlphabet(prepareKeyWord(keyword));
            String encodedContent = encipher(cipherAlutter, content.toString());

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

    public static String prepareKeyWord(String keyword) {
        StringBuilder uniqueKeyword = new StringBuilder();
        for (char c : keyword.toCharArray()) {
            if (uniqueKeyword.indexOf(String.valueOf(c)) == -1) {
                uniqueKeyword.append(c);
            }
        }
        return uniqueKeyword.toString();
    }

    public static String generateCipherAlphabet(String keyword) {
        StringBuilder cipherAlphabet = new StringBuilder();
        String uniqueKeyword = prepareKeyWord(keyword);
        for (char c : uniqueKeyword.toCharArray()) {
            cipherAlphabet.append(c);
        }
        for (char c = 'A'; c <= 'Z'; c++) {
            if (cipherAlphabet.indexOf(String.valueOf(c)) == -1) {
                cipherAlphabet.append(c);
            }
        }
        return cipherAlphabet.toString();
    }

    public static String encipher(String cipherAlphabet, String message) {
        StringBuilder encipheredMessage = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (cipherAlphabet.indexOf(String.valueOf(c))!= -1) {
                int newIndex = (cipherAlphabet.indexOf(String.valueOf(c)) + 13) % cipherAlphabet.length();
                encipheredMessage.append(cipherAlphabet.charAt(newIndex));
            } else {
                encipheredMessage.append(c);
            }
        }
        return encipheredMessage.toString();
    }
}