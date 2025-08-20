package book;

import java.time.LocalDate;
import java.util.Objects;

public class Book {

//    private static int bookCounter = 1;
//    private final int id;
    private final String isbn;
    private final String name;
    private final String author;
    private final String dateOfPublication;

    public Book(String isbn, String name, String author, String dateOfPublication) {
//        this.id = bookCounter++;
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.dateOfPublication = dateOfPublication;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public String getDateOfPublication() {
        return dateOfPublication;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author);
    }
}
