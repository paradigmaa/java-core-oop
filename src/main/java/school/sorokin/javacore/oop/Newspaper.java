package school.sorokin.javacore.oop;

import java.util.Objects;

public class Newspaper extends Publication {
    private final String publicationDay;

    public Newspaper(String title, String author, int year, String publicationDay) {
        super(title, author, year);
        this.publicationDay = publicationDay;
    }



    @Override
    public String getType() {
        return "Newspaper";
    }


    public String getPublicationDay() {
        return publicationDay;
    }



    @Override
    public String toString() {
        return "Newspaper{" +
                "title='" + getTitle() + '\'' +
                "author='" + getAuthor() + '\'' +
                "year='" + getYear() + '\'' +
                "publicationDay='" + getPublicationDay() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Newspaper newspaper = (Newspaper) o;
        return Objects.equals(publicationDay, newspaper.publicationDay);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(publicationDay);
    }
}
