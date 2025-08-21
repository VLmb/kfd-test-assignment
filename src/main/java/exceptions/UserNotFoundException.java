package exceptions;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super("[ERROR] User was not found.");
    }
}