package book;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

/**
* Класс содержит метаинформацию о конкретной книге
 */

public class Book {

    private final String isbn;
    private final String name;
    private final String author;
    private final String genre;
    private final String dateOfPublication;


    public Book(String isbn, String name, String author, String dateOfPublication, String genre) {
        this.isbn = isbn;
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.dateOfPublication = dateOfPublication;
    }

    public String getGenre() {
        return genre;
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

    @Override
    public String toString() {
        return "Book :" +
                "isbn='" + isbn + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", dateOfPublication='" + dateOfPublication + '\'';
    }

    public String getDateOfPublication() {
        return dateOfPublication;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(getIsbn(), book.getIsbn());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getIsbn());
    }
}
