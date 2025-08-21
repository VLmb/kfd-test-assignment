package exceptions;

public class UserNameAlreadyExistsException extends Exception {
    public UserNameAlreadyExistsException(String name) {
        super("[ERROR] User with name '" + name + "' already exists.");
    }
}
