package exceptions;

public class UserEmailAlreadyExistsException extends Exception {
    public UserEmailAlreadyExistsException(String email) {
        super("User with email '" + email + "' already exists.");
    }
}
