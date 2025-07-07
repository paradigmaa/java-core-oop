package school.sorokin.javacore.oop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Library {
    private List<Publication> publications = new ArrayList<>();

    public void addPublication(Publication pub) {
        publications.add(pub);
    }

    public void listPublications() {
        if(publications.isEmpty()) {
            System.out.println("Список пуст");
        }
        for (Publication p : publications) {
            if (p instanceof Book) {
                Book book = (Book) p;
                System.out.println(book);
            } else if (p instanceof Magazine) {
                Magazine magazine = (Magazine) p;
                System.out.println(magazine);
            } else if (p instanceof Newspaper) {
                Newspaper newspaper = (Newspaper) p;
                System.out.println(newspaper);
            }
        }
    }

    public void searchByAuthor(String author) {
        publications.stream().filter(n -> n.getAuthor().equals(author))
                .map(Publication::getTitle).forEach(System.out::println);
    }

    public void deleteByTittle(String tittle) {
        Iterator<Publication> iterator = publications.iterator();
        while (iterator.hasNext()) {
            Publication pub = iterator.next();
            if (pub.getTitle().equals(tittle)) {
                iterator.remove();
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
