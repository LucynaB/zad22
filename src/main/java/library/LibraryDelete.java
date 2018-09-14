package library;

public class LibraryDelete {
    public static void main(String[] args) {
        BookDao dao = new BookDao();
        dao.delete("1234567890");
        dao.close();
    }
}
