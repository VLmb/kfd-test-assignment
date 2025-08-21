package ui;

import book.Book;
import book.BookItem;
import exceptions.UserEmailAlreadyExistsException;
import exceptions.UserNameAlreadyExistsException;
import initializer.LibraryInitializer;
import library.Library;
import user.Faculty;
import user.Guest;
import user.Student;
import user.User;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    private final Library library = new Library("Library");
    private final Scanner scanner = new Scanner(System.in);
    private final LibraryInitializer initializer = new LibraryInitializer(library);

    public void start() throws UserEmailAlreadyExistsException, UserNameAlreadyExistsException, IOException {
        initializer.toInitialize();
        mainMenu();
        scanner.close();
    }

    private void mainMenu() {
        while (true) {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Book Operations");
            System.out.println("2. User Operations");
            System.out.println("3. Loan Operations");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        bookMenu();
                        break;
                    case 2:
                        userMenu();
                        break;
                    case 3:
                        loanMenu();
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("[ERROR] Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("[ERROR] Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
    }

    private void bookMenu() {
        System.out.println("\n=== Book Operations ===");
        System.out.println("1. Add a new book");
        System.out.println("2. Find a book by ISBN");
        System.out.println("3. Remove a book by ISBN");
        System.out.println("4. Show all books in the library");
        System.out.println("5. Show copies of the book by ISBN");
        System.out.println("6. Show all books by name");
        System.out.println("7. Show all books by author");
        System.out.println("8. Show all books by genre");
        System.out.print("Enter your choice: ");

        try {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    findBookByIsbn();
                    break;
                case 3:
                    removeBookByIsbn();
                case 4:
                    listAllBooks();
                    break;
                case 5:
                    findBookItemsByIsbn();
                    break;
                case 6:
                    findBookByName();
                    break;
                case 7:
                    findBooksByAuthor();
                    break;
                case 8:
                    findBooksByGenre();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } catch (InputMismatchException e) {
            System.out.println("[ERROR] Invalid input. Please enter a number.");
            scanner.nextLine();
        }
    }

    private void userMenu() {
        System.out.println("\n=== User Operations ===");
        System.out.println("1. Register a new user");
        System.out.println("2. Find a user by ID");
        System.out.println("3. Find a user by name");
        System.out.println("4. List all users");
        System.out.println("5. Remove user by ID");
        System.out.println("6. Show borrowed books");
        System.out.print("Enter your choice: ");

        try {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    findUserById();
                    break;
                case 3:
                    findUserByName();
                    break;
                case 4:
                    listAllUsers();
                    break;
                case 5:
                    removeUserById();
                    break;
                case 6:
                    showBorrowedBooks();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
        }
    }

    private void loanMenu() {
        System.out.println("\n=== Loan Operations ===");
        System.out.println("1. Borrow a book by ISBN");
        System.out.println("2. Borrow a book by name");
        System.out.println("3. Return a book");
        System.out.println("4. List overdue books");
        System.out.println("5. List overdue books of the user by ID");
        System.out.println("6. Show user debt by book");
        System.out.println("7. Show total user debt");
        System.out.print("Enter your choice: ");

        try {
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    borrowBookByIsbn();
                    break;
                case 2:
                    borrowBookByName();
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    listOverdueBooks();
                    break;
                case 5:
                    listOverdueBooksByUser();
                    break;
                case 6:
                    showUserDebtByBook();
                    break;
                case 7:
                    showUserTotalDebt();
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
        }
    }

    private void addBook() {
        try {
            System.out.print("Enter ISBN: ");
            String isbn = scanner.nextLine();
            System.out.print("Enter Title: ");
            String title = scanner.nextLine();
            System.out.print("Enter Author: ");
            String author = scanner.nextLine();

            library.addBook(new Book(isbn, title, author, "2000", "Fiction"));
            System.out.println("Book added successfully!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void findBookByIsbn() {
        try {
            System.out.print("Enter ISBN to search: ");
            String isbn = scanner.nextLine();
            Book book = library.findBookByIsbn(isbn);
            System.out.println("Found Book: " + book.getName() + " by " + book.getAuthor());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void findBookByName() {
        try {
            System.out.print("Enter name of book to search: ");
            String name = scanner.nextLine();
            Book book = library.findBookByName(name);
            System.out.println(book);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void findBooksByAuthor() {
        try {
            System.out.print("Enter author to search: ");
            String author = scanner.nextLine();
            List<Book> books = library.findBooksByAuthor(author);
            for (Book book: books) {
                System.out.println(book);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void findBooksByGenre() {
        try {
            System.out.print("Enter genre to search: ");
            String genre = scanner.nextLine();
            List<Book> books = library.findBooksByGenre(genre);
            for (Book book: books) {
                System.out.println(book);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void removeBookByIsbn() {
        try {
            System.out.print("Enter ISBN to remove: ");
            String isbn = scanner.nextLine();
            library.removeBookItem(isbn);
            System.out.print("The copy of the book is deleted");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void findBookItemsByIsbn() {
        try {
            System.out.print("Enter ISBN to search: ");
            String isbn = scanner.nextLine();
            List<BookItem> bookItems = library.findBookItemsByIsbn(isbn);
            for (BookItem bookItem: bookItems) {
                System.out.println(bookItem);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void listAllBooks() {
        System.out.println("\n=== All Books in Library ===");
        List<Book> books = library.getAllBooks();
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    private void registerUser() {
        try {
            System.out.print("Enter user type (1-Student, 2-Faculty, 3-Guest): ");
            int type = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter First Name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter Last Name: ");
            String lastName = scanner.nextLine();
            System.out.print("Enter Email: ");
            String email = scanner.nextLine();

            User user = null;
            switch(type) {
                case 1:
                    System.out.print("Enter university: ");
                    String university = scanner.nextLine();
                    user = new Student(firstName, lastName, email, university);
                    break;
                case 2:
                    System.out.print("Enter university: ");
                    String universit = scanner.nextLine();
                    user = new Faculty(firstName, lastName, email, universit);
                    break;
                case 3: user = new Guest(firstName, lastName, email); break;
                default: System.out.println("Invalid user type."); return;
            }

            library.registerUser(user);
            System.out.println("User registered successfully with ID: " + user.getUserId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void findUserById() {
        try {
            System.out.print("Enter User ID to search: ");
            int userId = scanner.nextInt();
            scanner.nextLine();
            User user = library.findUserById(userId);
            System.out.println("Found User: " + user.getFirstName() + " " + user.getLastName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void findUserByName() {
        try {
            System.out.print("Enter User first name and last name: ");
            String[] name = scanner.nextLine().split(" ");
            User user = library.findUserByName(name[0], name[1]);
            System.out.println(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void removeUserById() {
        try {
            System.out.print("Enter User ID to remove: ");
            int userId = scanner.nextInt();
            scanner.nextLine();
            library.removeUser(userId);
            System.out.println("The user has been delete");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void showBorrowedBooks() {
        try {
            System.out.print("Enter User ID: ");
            int userId = scanner.nextInt();
            scanner.nextLine();
            List<BookItem> borrowedBooks = library.getBorrowedBooksByUser(userId);
            if (borrowedBooks.isEmpty()) {
                System.out.println("No books");
            }
            for (BookItem bookItem: borrowedBooks) {
                System.out.println(bookItem);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void listAllUsers() {
        System.out.println("\n=== All Registered Users ===");
        List<User> users = library.getAllUsers();
        if (users.isEmpty()) {
            System.out.println("No users registered.");
        } else {
            for (User user : users) {
//                System.out.println("ID: " + user.getUserId() + ", Name: " + user.getFirstName() + " " + user.getLastName() + ", Email: " + user.getEmail());
                  System.out.println(user);
            }
        }
    }

    private void borrowBookByIsbn() {
        try {
            System.out.print("Enter User ID: ");
            int userId = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Book ISBN: ");
            String isbn = scanner.nextLine();

            library.borrowBook(userId, isbn);
            System.out.println("Book borrowed successfully!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void borrowBookByName() {
        try {
            System.out.print("Enter User ID: ");
            int userId = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Book name: ");
            String name = scanner.nextLine();

            library.borrowBookByName(userId, name);
            System.out.println("Book borrowed successfully!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void returnBook() {
        try {
            System.out.print("Enter User ID: ");
            int userId = scanner.nextInt();
            scanner.nextLine();

            User user = library.findUserById(userId);
            List<BookItem> borrowed = user.getBorrowedBooks();
            if (borrowed.isEmpty()) {
                System.out.println("This user has no borrowed books.");
                return;
            }

            System.out.println("Select a book to return:");
            for (int i = 0; i < borrowed.size(); i++) {
                System.out.println((i + 1) + ". " + borrowed.get(i).getBook().getName() + " (Item ID: " + borrowed.get(i).getId() + ")");
            }

            System.out.print("Enter choice number: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            BookItem itemToReturn = borrowed.get(choice - 1);
            library.returnBook(userId, itemToReturn);
            System.out.println("Book returned successfully!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void listOverdueBooks() {
        System.out.println("\n=== Overdue Books ===");
        List<BookItem> overdueBooks = library.getOverdueBookItems();
        if (overdueBooks.isEmpty()) {
            System.out.println("No overdue books.");
        } else {
            for (BookItem bookItem : overdueBooks) {
                System.out.println(bookItem);
            }
        }
    }

    private void listOverdueBooksByUser() {
        try {
            System.out.println("\n=== Overdue Books ===");
            System.out.print("Enter User ID: ");
            int userId = scanner.nextInt();
            scanner.nextLine();
            List<BookItem> overdueBooks = library.getOverdueBookItemsByUser(userId);
            if (overdueBooks.isEmpty()) {
                System.out.println("No overdue books.");
            } else {
                for (BookItem bookItem : overdueBooks) {
                    System.out.println(bookItem);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void showUserDebtByBook() {
        try {
            System.out.println("\n=== User Debt ===");
            System.out.print("Enter User ID: ");
            int userId = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter book ISBN: ");
            String isbn = scanner.nextLine();
            System.out.println("User debt by book: " + isbn + " : $" + library.getDebtForBook(userId, isbn));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void showUserTotalDebt() {
        try {
            System.out.println("\n=== User Debt ===");
            System.out.print("Enter User ID: ");
            int userId = scanner.nextInt();
            scanner.nextLine();
            System.out.println("User total debt: $" + library.getTotalDebt(userId));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}