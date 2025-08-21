package exceptions;

public class BookNotFoundException extends LibraryExceptions {
    public BookNotFoundException() {
        super("Such book doesn't exist.");
    }
    public BookNotFoundException(String message) {
        super(message);
    }
}
