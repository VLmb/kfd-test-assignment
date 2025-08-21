package book;

import user.User;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

/**
 * Класс содержит информацию об конкретном физическом экземпляре
 */

public class BookItem {

    private final int id;
    private static int bookCounter = 1;
    private Book book;
    private boolean isAvailable;
    private User user;
    private LocalDate borrowDate;
    private LocalDate dueDate;

    public BookItem(Book book) {
        this.id = bookCounter++;
        this.book = book;
        this.isAvailable = true;
        this.user = null;
        this.borrowDate = null;
        this.dueDate = null;
    }

    public void loanTo(User borrower) {
        this.user = borrower;
        this.isAvailable = false;
        this.borrowDate = LocalDate.now();
        this.dueDate = this.borrowDate.plusDays(borrower.getMaxDays());
    }

    public void returnToLibrary() {
        this.user = null;
        this.isAvailable = true;
        this.borrowDate = null;
        this.dueDate = null;
    }

    public int getId() {
        return id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isOverdue() {
        return !isAvailable && LocalDate.now().isAfter(dueDate);
    }

    public int getOverdueDays() {
        return (int)ChronoUnit.DAYS.between(dueDate, LocalDate.now());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BookItem bookItem = (BookItem) o;
        return getId() == bookItem.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    public String getIsbn() {
        return book.getIsbn();
    }

    @Override
    public String toString() {
        return "BookItem: " +
                "id=" + id +
                ", name of book: "  + book.getName() +
                ", isAvailable=" + isAvailable +
                ", userId=" + ((user != null) ? user.getUserId() : "none") +
                ", borrowDate=" + ((borrowDate != null) ? borrowDate : "none") +
                ", dueDate=" + ((dueDate != null) ? dueDate : "none");
    }

    public Book getBook() {
        return book;
    }
}
