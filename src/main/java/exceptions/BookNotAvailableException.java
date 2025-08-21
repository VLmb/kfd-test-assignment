package exceptions;

public class BookNotAvailableException extends LibraryExceptions {
    public BookNotAvailableException() {
        super("[ERROR] This book is not available for issue.");
    }
}
