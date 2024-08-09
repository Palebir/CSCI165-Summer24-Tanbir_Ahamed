package lab;

public class InvalidAccountNumberException extends Exception {
    public InvalidAccountNumberException(String message) {
        super(message);
    }

    public InvalidAccountNumberException(String message, Throwable cause) {
        super(message, cause);
    }
}


