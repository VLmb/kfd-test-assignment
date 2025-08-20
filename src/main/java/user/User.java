package user;

import book.BookLoan;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class User {

    protected static int userCounter = 1;
    protected final int userId;
    protected final String firstName;
    protected final String lastName;
    protected String email;
    protected Set<BookLoan> borrowedBooks;

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

    public boolean borrowBook(BookLoan bookLoan) {
        if (borrowedBooks.size() >= getMaxBooks()) return false;
        borrowedBooks.add(bookLoan);
        return true;
    }

    public boolean returnBook(BookLoan bookLoan) {
        return borrowedBooks.remove(bookLoan);
    }

    public int getBorrowedCount() {
        return borrowedBooks.size();
    }

    public boolean canBorrowMore() {
        return borrowedBooks.size() < getMaxBooks();
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
}
