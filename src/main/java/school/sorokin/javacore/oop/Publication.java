package school.sorokin.javacore.oop;

import java.util.Objects;

public abstract class Publication implements Printable {

    private String title;

    private String author;

    private int year;

    protected Publication(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public void printDetails() {
        System.out.println(this);
    }

    public abstract String getType();

    private static int publicationCount = 0;

    public static int getPublicationCount() {
        return Publication.publicationCount;
    }

    protected static void incrementCount(){
        publicationCount++;
    }

    protected static void decrementCount(){
        publicationCount--;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String tittle) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publication that = (Publication) o;
        return year == that.year && Objects.equals(title, that.title) && Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, year);
    }

    @Override
    public String toString() {
        return "Publication{" +
                "tittle='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }
}
