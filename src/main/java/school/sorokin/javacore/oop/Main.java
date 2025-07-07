package school.sorokin.javacore.oop;

import java.util.Scanner;

public class Main {
    private Library library = new Library();
    public void main() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            print();
            String enter = scanner.nextLine();
            switch (enter) {
                case "1": {
                    System.out.println("Выберите тип публикации: 1 - Book, 2 - Magazine, 3 - Newspaper");
                    String type = scanner.nextLine();
                    System.out.println("Введите название:");
                    String tittle = scanner.nextLine();
                    System.out.println("Введите автора:");
                    String author = scanner.nextLine();
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
                    break;
                }
                case "2":
                    library.listPublications();
                    break;
                case "3": {
                    System.out.println("Введите фамилию автора");
                    String author = scanner.nextLine();
                    library.searchByAuthor(author);
                    break;
                }
                case "4": {
                    System.out.println(Publication.getPublicationCount());
                    break;
                }
                case "5":{
                    System.out.println("Введите название книги, которую хотите удалить:");
                    String removeTitle = scanner.nextLine();
                    library.deleteByTittle(removeTitle);
                }
                case "6":{
                    flag = false;
                }
            }
        }
    }

    public void print(){
        System.out.println("Выберите операцию:");
        System.out.println("1 - Добавить новую публикацию");
        System.out.println("2 - Вывести список всех публикаций");
        System.out.println("3 - Поиск публикации по автору");
        System.out.println("4 - Вывести общее количество публикаций");
        System.out.println("5 - Удалить книгу");
        System.out.println("6 - Выход");
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.main();

    }
}
