package library;

public class Book {
    private long id;
    private String title;
    private String author;
    private int year;
    private String isbn;

    public Book() {
    }

    public Book(String title, String author, int year, String isbn) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return author + " " + title + " " + year + " " + isbn;
    }

    public void updateBook(String title, String author, String  year, String isbn) {
        if (!title.equals("")) {
            this.setTitle(title);
        }
        if (!author.equals("")) {
            this.setAuthor(author);
        }
        if (!year.equals("")) {
            this.setYear(Integer.valueOf(year));

        }
        if (!isbn.equals("")) {
            this.setIsbn(isbn);
        }
    }
}
