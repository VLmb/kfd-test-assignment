package initializer;

import book.Book;
import exceptions.UserEmailAlreadyExistsException;
import exceptions.UserNameAlreadyExistsException;
import library.Library;
import user.Faculty;
import user.Guest;
import user.Student;
import user.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LibraryInitializer {

    private final Library library;
    private String pathForBooks = "src/main/resources/books.txt";
    private String pathForUsers = "src/main/resources/users.txt";

    public LibraryInitializer(Library library) {
        this.library = library;
    }

    public void toInitialize() throws IOException, UserEmailAlreadyExistsException, UserNameAlreadyExistsException {
        loadBooks();
        loadUsers();
    }

    private void loadBooks() throws IOException {
        List<Book> books = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(pathForBooks))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split(",");
                books.add(new Book(parts[0], parts[1], parts[2], parts[3], parts[4]));
            }
        }
        for (Book book : books) {
            library.addBook(book);
        }
    }

    private void loadUsers() throws IOException, UserEmailAlreadyExistsException, UserNameAlreadyExistsException {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(pathForUsers))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(",");

                if (Objects.equals(parts[0], "STUDENT")) {
                    users.add(new Student(parts[1], parts[2], parts[3], parts[4]));
                }
                else if (Objects.equals(parts[0], "GUEST")) {
                    users.add(new Guest(parts[1], parts[2], parts[3]));
                }
                else {
                    users.add(new Faculty(parts[1], parts[2], parts[3], parts[4]));
                }
            }
        }
        for (User user : users) {
            library.registerUser(user);
        }
    }
}
