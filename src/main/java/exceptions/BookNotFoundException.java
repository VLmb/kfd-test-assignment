package exceptions;

public class BookNotFoundException extends LibraryExceptions {
    public BookNotFoundException() {
        super("[ERROR] Such book doesn't exist.");
    }
    public BookNotFoundException(String message) {
        super(message);
    }
}
