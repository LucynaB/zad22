package library;

public class LibraryRead {
    public static void main(String[] args) {
        BookDao dao = new BookDao();
        Book book = dao.read("1234567890");
        System.out.println(book);
        dao.close();
    }
}
