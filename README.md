# **Library Management System**
This project is a console-based library management system developed as a test assignment for the Kotlin FullStack Developer Course. It demonstrates Object-Oriented Programming (OOP) principles, appropriate data structure usage, and error handling to manage books, users, and borrowing operations.

## **Project Structure**
- ```book/```: Classes for book metadata (```Book```) and physical copies (```BookItem```).
- ```user/```: Abstract ```User``` class and implementations (```Student```, ```Faculty```, ```Guest```).
- ```library/```: Core logic for library management (```Library```, ```LibraryManager```, ```LoanService```).
- ```ui/```: Console-based user interface (```ConsoleUI```).
- ```exceptions/```: Custom exceptions for error handling.
- ```initializer/```: Initialization logic for sample data (```LibraryInitializer```).
- Sample data is loaded from ```resources/book.txt``` and ```resources/users.txt``` during initialization via ```LibraryInitializer```.

## **Setup Instructions**
### Requirements
- Java Development Kit (JDK): Version 8 or higher.
- Java IDE: IntelliJ IDEA or a command-line environment with javac and java.
- Git: For cloning the repository (optional).
### Steps to Run
- Clone the Repository
- Compile the Code: Ensure all .java files are in their respective package directories (book, user, library, ui, exceptions, initializer) and resource files (book.txt, users.txt) are in the resources directory. Compile the main class:
  ```bash
  javac Main.java
  ```
- Run the Application: Execute the main class:
    ```bash
  java Main
    ```