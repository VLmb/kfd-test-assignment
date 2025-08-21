package exceptions;

public class BookAlreadyExistsException extends LibraryExceptions {
    public BookAlreadyExistsException(String isbn) {
        super("[ERROR] A book with an ISBN " + isbn + " already exists.");
    }
}
