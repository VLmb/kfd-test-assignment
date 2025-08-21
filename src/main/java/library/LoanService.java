package library;

import book.Book;
import book.BookItem;
import exceptions.BookNotAvailableException;
import exceptions.BookNotFoundException;
import exceptions.UserCantBorrowMore;
import exceptions.UserNotFoundException;
import user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoanService implements LoanServiceOperations {

    private final LibraryManager manager;
    private Map<String, List<BookItem>> currentLoans;

    public LoanService(LibraryManager manager) {
        this.manager = manager;
        this.currentLoans = new HashMap<>();
    }

    @Override
    public boolean borrowBook(int userId, String isbn) throws UserCantBorrowMore, BookNotFoundException, UserNotFoundException, BookNotAvailableException {
        User user = manager.findUserById(userId);
        manager.findBookByIsbn(isbn);
        if (!user.canBorrowMore()) throw new UserCantBorrowMore();
        for (BookItem bookItem : manager.findBookItemsByIsbn(isbn)) {
            if (bookItem.isAvailable()) {
                bookItem.loanTo(user);
                user.borrowBook(bookItem);
                currentLoans.putIfAbsent(bookItem.getIsbn(), new ArrayList<>());
                currentLoans.get(bookItem.getIsbn()).add(bookItem);
                return true;
            }
        }
        throw new BookNotAvailableException();
    }

    @Override
    public boolean borrowBookByName(int userId, String nameOfBook) throws UserCantBorrowMore, BookNotFoundException, UserNotFoundException, BookNotAvailableException {
        Book book = manager.findBookByName(nameOfBook);
        borrowBook(userId, book.getIsbn());

        return true;
    }

    @Override
    public boolean returnBook(int userId, BookItem bookItem)  throws BookNotFoundException, UserNotFoundException{
        User user = manager.findUserById(userId);
        if (!currentLoans.get(bookItem.getIsbn()).contains(bookItem)) throw new BookNotFoundException("This book already has been returned.");

        currentLoans.get(bookItem.getIsbn()).removeIf(bookItem::equals);
        user.returnBook(bookItem);
        bookItem.returnToLibrary();

        return true;
    }

    @Override
    public List<BookItem> getOverdueBookItems() {
        List<BookItem> overdueBooks = new ArrayList<>();
        for (BookItem bookItem: currentLoans.values().stream().flatMap(List::stream).toList()){
            if (bookItem.isOverdue()) overdueBooks.add(bookItem);
        }
        return overdueBooks;
    }

    @Override
    public List<BookItem> getOverdueBookItemsByUser(int userId) throws UserNotFoundException {
        User user = manager.findUserById(userId);
        return user.getBorrowedBooks().stream().filter(BookItem::isOverdue).toList();
    }

    @Override
    public List<BookItem> getBorrowedBooksByUser(int userId) throws UserNotFoundException {
        User user = manager.findUserById(userId);
        return user.getBorrowedBooks();
    }

    @Override
    public double getTotalDebt(int userId) throws UserNotFoundException {
        User user = manager.findUserById(userId);
        double totalDebt = 0.0;

        for (BookItem bookItem: user.getBorrowedBooks()) {
            if (bookItem.isOverdue()) {
                totalDebt += bookItem.getOverdueDays() * user.getDailyFine();
            }
        }

        return totalDebt;
    }

    @Override
    public double getDebtForBook(int userId, String isbn)  throws UserNotFoundException, BookNotFoundException {
        User user = manager.findUserById(userId);

        return user.findBorrowedBook(isbn).getOverdueDays() * user.getDailyFine();
    }

}
