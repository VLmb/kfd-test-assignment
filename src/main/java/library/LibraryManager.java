package library;

import book.Book;
import book.BookItem;
import exceptions.*;
import user.User;

import java.util.*;

/**
 * Выполняет основные операции по добавлению, удалению и поиску книг и пользователей в библиотеке.
 */

public class LibraryManager implements LibraryManagerOperations {

    private Map<String, List<BookItem>> bookItems;
    private Map<String, Book> books;
    private Map<Integer, User> users;

    public LibraryManager() {
        this.books = new HashMap<>();
        this.users = new HashMap<>();
        this.bookItems = new HashMap<>();
    }

    @Override
    public void addBook(Book newBook) {
        books.putIfAbsent(newBook.getIsbn(), newBook);
        bookItems.putIfAbsent(newBook.getIsbn(), new ArrayList<>());
        bookItems.get(newBook.getIsbn()).add(new BookItem(newBook));
    }

    @Override
    public boolean removeBookItem(String isbn) throws BookNotFoundException {
        if (!bookItems.containsKey(isbn)) {
            throw new BookNotFoundException();
        }
        bookItems.get(isbn).remove(0);

        if (bookItems.get(isbn).isEmpty()) {
            bookItems.remove(isbn);
            books.remove(isbn);
        }

        return true;
    }

    @Override
    public Book findBookByIsbn(String isbn) throws BookNotFoundException {
        if (books.get(isbn) != null) {
            return books.get(isbn);
        }
        else {
            throw new BookNotFoundException();
        }
    }

    @Override
    public List<BookItem> findBookItemsByIsbn(String isbn) throws BookNotFoundException {
        if (bookItems.get(isbn) != null) {
            return bookItems.get(isbn);
        }
        else {
            throw new BookNotFoundException();
        }
    }

    @Override
    public Book findBookByName(String name) throws BookNotFoundException {
        for (Book book : books.values()) {
            if (book.getName().equals(name)) {
                return book;
            }
        }
        throw new BookNotFoundException();
    }

    @Override
    public List<Book> findBooksByAuthor(String author) throws BookNotFoundException {
        List<Book> booksByAuthor = books.values().stream().filter(book -> book.getAuthor().equals(author)).toList();
        if (booksByAuthor.isEmpty()) {
            throw new BookNotFoundException();
        }
        return booksByAuthor;
    }

    @Override
    public List<Book> findBooksByGenre(String genre) throws BookNotFoundException {
        List<Book> booksByGenre = books.values().stream().filter(book -> book.getGenre().equals(genre)).toList();
        if (booksByGenre.isEmpty()) {
            throw new BookNotFoundException();
        }
        return booksByGenre;
    }

    @Override
    public void registerUser(User user) throws UserNameAlreadyExistsException, UserEmailAlreadyExistsException {
        String name = user.getFirstName() + " " + user.getLastName();
        String email = user.getEmail();
        for (User u: users.values()) {
            if ((u.getFirstName() + " " + u.getLastName()).equals(name)) {
                throw new UserNameAlreadyExistsException(name);
            }
            if (u.getEmail().equals(email)) {
                throw new UserEmailAlreadyExistsException(email);
            }
        }
        users.put(user.getUserId(), user);
    }

    @Override
    public boolean removeUser(int userId) throws UserNotFoundException {
        if (users.containsKey(userId)) {
            users.remove(userId);
            return true;
        }
        else {
            throw new UserNotFoundException();
        }
    }

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    @Override
    public User findUserById(int userId) throws UserNotFoundException {
        if (users.containsKey(userId)) {
            return users.get(userId);
        }
        throw new UserNotFoundException();
    }

    @Override
    public User findUserByName(String firstName, String lastName) throws UserNotFoundException {
        for (User user: new ArrayList<>(users.values())) {
            if (user.getFirstName().equals(firstName) && user.getLastName().equals(lastName)) {
                return user;
            }
        }

        throw new UserNotFoundException();
    }
}
