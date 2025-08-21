package library;

import book.BookItem;
import exceptions.*;

import java.util.List;

public interface LoanServiceOperations {

    boolean borrowBook(int userId, String isbn) throws UserCantBorrowMore, BookNotFoundException, UserNotFoundException, BookNotAvailableException;

    boolean borrowBookByName(int userId, String nameOfBook) throws UserCantBorrowMore, BookNotFoundException, UserNotFoundException, BookNotAvailableException;

    boolean returnBook(int userId, BookItem bookItem) throws BookNotFoundException, UserNotFoundException;

    List<BookItem> getOverdueBookItems();

    List<BookItem> getBorrowedBooksByUser(int userId) throws UserNotFoundException;

}
