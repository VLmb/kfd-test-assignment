package exceptions;

public class UserNameAlreadyExistsException extends Exception {
    public UserNameAlreadyExistsException(String name) {
        super("User with name '" + name + "' already exists.");
    }
}
