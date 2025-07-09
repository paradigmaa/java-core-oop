package school.sorokin.javacore.oop;

import java.util.Objects;

public class Book extends Publication {
    private final String isbn;


    public Book(String title, String author, int year, String isbn) {
        super(title, author, year);
        this.isbn = isbn;
    }

    @Override
    public String getType() {
        return "Book";
    }


    @Override
    public String toString() {
        return "Book{" +
                "title='" + getTitle() + '\'' +
                "author='" + getAuthor() + '\'' +
                "year='" + getYear() + '\'' +
                "ISBN='" + isbn + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isbn);
    }
}
