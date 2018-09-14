package library;

public class LibraryUpdate {
    public static void main(String[] args) {
        BookDao dao = new BookDao();
        Book book = dao.read("1234567890");
        book.setYear(2000);
        dao.update(book);
        System.out.println(book);
        dao.close();

    }
}
