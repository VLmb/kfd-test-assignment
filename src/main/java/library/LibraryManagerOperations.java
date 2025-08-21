package library;

import book.Book;
import book.BookItem;
import exceptions.*;
import user.User;

import java.util.List;

public interface LibraryManagerOperations {

    void addBook(Book newBook);

    boolean removeBookItem(String isbn) throws BookNotFoundException;

    Book findBookByIsbn(String isbn) throws BookNotFoundException;

    List<BookItem> findBookItemsByIsbn(String isbn) throws BookNotFoundException;

    Book findBookByName(String name) throws BookNotFoundException;

    List<Book> findBooksByAuthor(String author) throws BookNotFoundException;

    List<Book> findBooksByGenre(String genre) throws BookNotFoundException;

    void registerUser(User user) throws UserNameAlreadyExistsException, UserEmailAlreadyExistsException;

    boolean removeUser(int userId) throws UserNotFoundException;

    List<Book> getAllBooks();

    List<User> getAllUsers();

    User findUserById(int userId) throws UserNotFoundException;

    User findUserByName(String firstName, String lastName) throws UserNotFoundException;

}
