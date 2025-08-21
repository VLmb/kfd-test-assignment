package library;

import book.Book;
import book.BookItem;
import exceptions.*;
import user.User;

import java.security.Provider;
import java.util.List;

public class Library {

    private String name;
    private final LibraryManager manager;
    private final LoanService service;

    public Library(String name) {
        this.name = name;
        this.manager = new LibraryManager();
        this.service = new LoanService(manager);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addBook(Book newBook) {
        manager.addBook(newBook);
    }

    public boolean removeBookItem(String isbn) throws BookNotFoundException {
        return manager.removeBookItem(isbn);
    }

    public Book findBookByIsbn(String isbn) throws BookNotFoundException {
        return manager.findBookByIsbn(isbn);
    }

    public Book findBookByName(String name) throws BookNotFoundException {
        return manager.findBookByName(name);
    }

    public List<Book> findBooksByAuthor(String author) throws BookNotFoundException {
        return manager.findBooksByAuthor(author);
    }

    public List<Book> findBooksByGenre(String author) throws BookNotFoundException {
        return manager.findBooksByGenre(author);
    }

    public List<BookItem> findBookItemsByIsbn(String isbn) throws BookNotFoundException {
        return manager.findBookItemsByIsbn(isbn);
    }

    public void registerUser(User user) throws UserNameAlreadyExistsException, UserEmailAlreadyExistsException {
        manager.registerUser(user);
    }

    public boolean removeUser(int userId) throws UserNotFoundException {
        return manager.removeUser(userId);
    }

    public List<Book> getAllBooks() {
        return manager.getAllBooks();
    }

    public List<User> getAllUsers() {
        return manager.getAllUsers();
    }

    public User findUserById(int userId) throws UserNotFoundException {
        return manager.findUserById(userId);
    }

    public User findUserByName(String firstName, String lastName) throws UserNotFoundException {
        return manager.findUserByName(firstName, lastName);
    }

    public void borrowBook(int userId, String isbn) throws UserNotFoundException, BookNotFoundException, UserCantBorrowMore, BookNotAvailableException {
        service.borrowBook(userId, isbn);
    }

    public void borrowBookByName(int userId, String name) throws UserNotFoundException, BookNotFoundException, UserCantBorrowMore, BookNotAvailableException {
        service.borrowBookByName(userId, name);
    }

    public void returnBook(int userId, BookItem bookItem) throws UserNotFoundException, BookNotFoundException {
        service.returnBook(userId, bookItem);
    }

    public List<BookItem> getBorrowedBooksByUser(int userId) throws UserNotFoundException {
        return service.getBorrowedBooksByUser(userId);
    }

    public List<BookItem> getOverdueBookItems() {
        return service.getOverdueBookItems();
    }

    public List<BookItem> getOverdueBookItemsByUser(int userId) throws UserNotFoundException {
        return service.getOverdueBookItemsByUser(userId);
    }

    public double getDebtForBook(int userId, String isbn) throws UserNotFoundException, BookNotFoundException {
        return service.getDebtForBook(userId, isbn);
    }

    public double getTotalDebt(int userId) throws UserNotFoundException {
        return service.getTotalDebt(userId);
    }
}
