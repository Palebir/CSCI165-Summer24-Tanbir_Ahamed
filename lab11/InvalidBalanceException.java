package lab;

public class InvalidBalanceException extends Exception {
    public InvalidBalanceException(String message) {
        super(message);
    }

    public InvalidBalanceException(String message, Throwable cause) {
        super(message, cause);
    }
}


