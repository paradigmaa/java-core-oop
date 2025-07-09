package school.sorokin.javacore.oop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library {
    private final List<Publication> publications;
    public Library(List<Publication> publications) {
        this.publications = publications;
    }

    public void addPublication(Publication pub) {
        publications.add(pub);
        Publication.incrementCount();
    }

    public void listPublications() {
        if (publications.isEmpty()) {
            System.out.println("Список пуст");
        }
        for (Publication p : publications) {
            p.printDetails();
        }
    }

    public void searchByAuthor(String author) {
        publications.stream().filter(n -> n.getAuthor().equals(author))
                .map(Publication::getTitle).forEach(System.out::println);
    }

    public void deleteByTittle(String title) {
        Iterator<Publication> iterator = publications.iterator();
        while (iterator.hasNext()) {
            Publication pub = iterator.next();
            if (pub.getTitle().equals(title)) {
                iterator.remove();
                Publication.decrementCount();
            }

        }
    }


    @Override
    public String toString() {
        return "Library{" +
                "publications=" + publications +
                '}';
    }
}
