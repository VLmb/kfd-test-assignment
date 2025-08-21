import exceptions.UserEmailAlreadyExistsException;
import exceptions.UserNameAlreadyExistsException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws UserEmailAlreadyExistsException, UserNameAlreadyExistsException, IOException {
        ui.ConsoleUI console = new ui.ConsoleUI();
        console.start();
    }
}
