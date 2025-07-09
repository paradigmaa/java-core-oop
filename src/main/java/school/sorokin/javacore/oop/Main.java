import school.sorokin.javacore.oop.*;
import java.util.ArrayList;
import java.util.Scanner;

public static void print() {
    System.out.println("Выберите операцию:");
    System.out.println("1 - Добавить новую публикацию");
    System.out.println("2 - Вывести список всех публикаций");
    System.out.println("3 - Поиск публикации по автору");
    System.out.println("4 - Вывести общее количество публикаций");
    System.out.println("5 - Удалить публикацию");
    System.out.println("6 - Выход");
}

public static void main(String[] args) {
    final Library library = new Library(new ArrayList<>());
    Scanner scanner = new Scanner(System.in);
    boolean flag = true;
    while (flag) {
        print();
        String enter = scanner.nextLine();
        switch (enter) {
            case "1" -> {
                System.out.println("Выберите тип публикации: 1 - Book, 2 - Magazine, 3 - Newspaper");
                String type = scanner.nextLine();
                if (type.trim().isEmpty()) {
                    System.out.println("Вы ввели пустую строку");
                    break;
                }
                System.out.println("Введите название:");
                String tittle = scanner.nextLine();
                if (tittle.trim().isEmpty()) {
                    System.out.println("Вы ввели пустое имя публикации");
                    break;
                }
                System.out.println("Введите автора:");
                String author = scanner.nextLine();
                if (author.trim().isEmpty()) {
                    System.out.println("Вы ввели пустое значение в имени Автора");
                    break;
                }
                System.out.println("Введите год:");
                int year = scanner.nextInt();
                scanner.nextLine();
                switch (type) {
                    case "1" -> {
                        System.out.println("Введите ISBN:");
                        String ISBN = scanner.nextLine();
                        Publication publication = new Book(tittle, author, year, ISBN);
                        library.addPublication(publication);
                    }
                    case "2" -> {
                        System.out.println("Введите issueNumber:");
                        int issueNumber = scanner.nextInt();
                        scanner.nextLine();
                        Publication publication = new Magazine(tittle, author, year, issueNumber);
                        library.addPublication(publication);
                    }
                    case "3" -> {
                        System.out.println("Введите Newspaper:");
                        String publicationDay = scanner.nextLine();
                        Publication publication = new Newspaper(tittle, author, year, publicationDay);
                        library.addPublication(publication);
                    }
                    default -> System.out.println("Введите верное значение");
                }
            }
            case "2" -> {
                library.listPublications();
            }
            case "3" -> {
                System.out.println("Введите фамилию автора");
                String author = scanner.nextLine();
                library.searchByAuthor(author);
            }
            case "4" -> {
                System.out.println(Publication.getPublicationCount());
            }
            case "5" -> {
                System.out.println("Введите название книги, которую хотите удалить:");
                String removeTitle = scanner.nextLine();
                library.deleteByTittle(removeTitle);
            }
            case "6" -> {
                flag = false;
            }
        }
    }
}
