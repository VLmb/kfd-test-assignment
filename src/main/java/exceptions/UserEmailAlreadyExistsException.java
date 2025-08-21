package exceptions;

public class UserEmailAlreadyExistsException extends Exception {
    public UserEmailAlreadyExistsException(String email) {
        super("[ERROR] User with email '" + email + "' already exists.");
    }
}
