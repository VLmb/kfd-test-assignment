package exceptions;

public class BookAlreadyExistsException extends LibraryExceptions {
    public BookAlreadyExistsException(String isbn) {
        super("A book with an ISBN " + isbn + " already exists.");
    }
}
