package user;

import book.BookItem;
import exceptions.UserCantBorrowMore;

import java.util.*;

public abstract class User {

    private static int userCounter = 1;
    private final int userId;
    private final String firstName;
    private final String lastName;
    private String email;
    private Set<BookItem> borrowedBooks;

    public User(String firstName, String lastName, String email) {
        this.userId = userCounter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.borrowedBooks = new HashSet<>();
    }

    public abstract int getMaxBooks();

    public abstract int getMaxDays();

    public abstract double getDailyFine();

    public boolean borrowBook(BookItem bookItem) throws UserCantBorrowMore {
        if (borrowedBooks.size() >= getMaxBooks()) throw new UserCantBorrowMore();
        borrowedBooks.add(bookItem);
        return true;
    }

    public boolean returnBook(BookItem bookItem) {
        return borrowedBooks.remove(bookItem);
    }

    public int getBorrowedCount() {
        return borrowedBooks.size();
    }

    public boolean canBorrowMore() {
        return borrowedBooks.size() < getMaxBooks();
    }

    public List<BookItem> getBorrowedBooks() {
        return new ArrayList<BookItem>(borrowedBooks);
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
}
