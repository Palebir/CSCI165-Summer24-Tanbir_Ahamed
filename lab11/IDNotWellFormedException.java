package lab;

public class IDNotWellFormedException extends Exception {
    public IDNotWellFormedException(String message) {
        super(message);
    }

    public IDNotWellFormedException(String message, Throwable cause) {
        super(message, cause);
    }
}

