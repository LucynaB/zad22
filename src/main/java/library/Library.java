package library;

import java.util.Scanner;

public class Library {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BookDao dao = new BookDao();
        int userChoice;

        do {
            System.out.println("Wybierz opcję: ");
            System.out.println("1 - dodawanie książki");
            System.out.println("2 - wyświetlenie książki");
            System.out.println("3 - aktualizacja książki");
            System.out.println("4 - usuwanie książki");
            System.out.println("5 - koniec");
            userChoice = scan.nextInt();
            scan.nextLine();

            switch (userChoice) {

                case (1): {
                    System.out.println("Podaj tytuł książki:");
                    String title = scan.nextLine();
                    System.out.println("Podaj autora: ");
                    String author = scan.nextLine();
                    System.out.println("Podaj rok wydania: ");
                    int year = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Podaj nr ISBN: ");
                    String isbn = scan.nextLine();
                    Book book = new Book(title, author, year, isbn);
                    dao.save(book);
                    break;
                }
                case (2): {
                    System.out.println("Podaj nr ISBN: ");
                    String isbn = scan.nextLine();
                    Book book = dao.read(isbn);
                    System.out.println(book);
                    break;
                }
                case (3): {
                    System.out.println("Podaj nr ISBN: ");
                    String isbn = scan.nextLine();
                    Book book = dao.read(isbn);
                    System.out.println("Podaj tytuł książki:");
                    String titleNew = scan.nextLine();
                    System.out.println("Podaj autora: ");
                    String authorNew = scan.nextLine();
                    System.out.println("Podaj rok wydania: ");
                    String yearNew = scan.nextLine();
                    System.out.println("Podaj nr ISBN: ");
                    String isbnNew = scan.nextLine();
                    book.updateBook(titleNew, authorNew, yearNew, isbnNew);
                    dao.update(book);
                    System.out.println("Zakualizowano: " + book);
                    break;
                }
                case (4): {
                    System.out.println("Podaj nr ISBN: ");
                    String isbn = scan.nextLine();
                    dao.delete(isbn);
                    break;
                }
            }
        } while (userChoice != 5);

        dao.close();
    }
}
