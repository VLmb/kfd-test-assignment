package book;

import user.User;

import java.time.LocalDate;

public class BookLoan {

    private final Book book;
    private final User user;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private boolean returned = false;

    public BookLoan(Book book, User user, LocalDate borrowDate, LocalDate dueDate) {
        this.book = book;
        this.user = user;
        this.borrowDate = LocalDate.now();
        this.dueDate = dueDate;
    }

    public Book getBook() {
        return book;
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

    public boolean isReturned() {
        return returned;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }
}
