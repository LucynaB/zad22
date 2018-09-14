package library;

public class LibrarySave {
    public static void main(String[] args) {
        Book book = new Book("W pustyni i w puszczy","Henryk Sienkiewicz", 1990,"1234567890");
        BookDao dao = new BookDao();
        dao.save(book);
        dao.close();

    }
}
