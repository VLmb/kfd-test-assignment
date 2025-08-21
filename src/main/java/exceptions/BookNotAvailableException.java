package exceptions;

public class BookNotAvailableException extends LibraryExceptions {
    public BookNotAvailableException() {
        super("This book is not available for issue.");
    }
}
