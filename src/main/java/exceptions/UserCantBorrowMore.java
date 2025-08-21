package exceptions;

public class UserCantBorrowMore extends LibraryExceptions{
    public UserCantBorrowMore() {
        super("User can't take more books, they need to return the others first.");
    }
}
