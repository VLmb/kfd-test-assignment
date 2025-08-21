package user;

import book.BookItem;
import exceptions.BookNotFoundException;
import exceptions.UserCantBorrowMore;

import java.util.*;

public abstract class User {

    private static int userCounter = 1;
    private final int userId;
    private final String firstName;
    private final String lastName;
    private String email;
    private Map<String, BookItem> borrowedBooks;

    public User(String firstName, String lastName, String email) {
        this.userId = userCounter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.borrowedBooks = new HashMap<>();
    }

    public abstract int getMaxBooks();

    public abstract int getMaxDays();

    public abstract double getDailyFine();

    public boolean borrowBook(BookItem bookItem) throws UserCantBorrowMore {
        if (borrowedBooks.size() >= getMaxBooks()) throw new UserCantBorrowMore();
        borrowedBooks.put(bookItem.getIsbn(), bookItem);
        return true;
    }

    public BookItem returnBook(BookItem bookItem) {
        return borrowedBooks.remove(bookItem.getIsbn());
    }

    public int getBorrowedCount() {
        return borrowedBooks.size();
    }

    public boolean canBorrowMore() {
        return borrowedBooks.size() < getMaxBooks();
    }

    public List<BookItem> getBorrowedBooks() {
        return new ArrayList<BookItem>(borrowedBooks.values());
    }

    public BookItem findBorrowedBook(String isbn) throws BookNotFoundException {
        if (borrowedBooks.containsKey(isbn)) {
            return borrowedBooks.get(isbn);
        }
        throw new BookNotFoundException();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(userId);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "User: " +
                " userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'';
    }
}
