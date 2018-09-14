package library;

import java.sql.*;

public class BookDao {
    private static final String URL = "jdbc:mysql://localhost:3306/library?characterEncoding=utf8&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "root";
    private Connection connection;

    public BookDao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASS);
            Statement statement = connection.createStatement();
            String query = "CREATE TABLE if not exists books(id INT NOT NULL AUTO_INCREMENT,title VARCHAR(45) NOT NULL,author VARCHAR(45) NOT NULL,year INT NOT NULL,isbn VARCHAR(45) NOT NULL,PRIMARY KEY (id))";
            statement.execute(query);
        } catch (ClassNotFoundException e) {
            System.out.println("No driver found");
        } catch (SQLException e) {
            System.out.println("Could not establish connection");
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void save(Book book) {
        final String sql = "insert into books(title, author, year, isbn) values(?, ?, ?, ?)";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(1, book.getTitle());
            prepStmt.setString(2, book.getAuthor());
            prepStmt.setInt(3, book.getYear());
            prepStmt.setString(4, book.getIsbn());
            prepStmt.executeUpdate();
            System.out.println("book saved");
        } catch (SQLException e) {
            System.out.println("Could not save record");
            e.printStackTrace();
        }
    }

    public Book read(String isbn) {
        final String sql = "select id, title, author, year,isbn from books where isbn = ?";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(1, isbn);
            ResultSet result = prepStmt.executeQuery();
            if (result.next()) {
                Book book = new Book();
                book.setId(result.getLong("id"));
                book.setTitle(result.getString("title"));
                book.setAuthor(result.getString("author"));
                book.setYear(result.getInt("year"));
                book.setIsbn(result.getString("isbn"));
                return book;
            }
        } catch (SQLException e) {
            System.out.println("Could not get book");
        }
        return null;
// lub ElementNotFoundException
    }

    public void update(Book book) {
        final String sql = "update books set title=?, author=?, year=?, isbn=? where id = ?";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(1, book.getTitle());
            prepStmt.setString(2, book.getAuthor());
            prepStmt.setInt(3, book.getYear());
            prepStmt.setString(4, book.getIsbn());
            prepStmt.setLong(5, book.getId());
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Could not update record");
            e.printStackTrace();
        }
    }


    public void delete(String isbn) {
        final String sql = "delete from books where isbn = ?";
        try {
            PreparedStatement prepStmt = connection.prepareStatement(sql);
            prepStmt.setString(1, isbn);
            prepStmt.executeUpdate();
            System.out.println("book deleted");
        } catch (SQLException e) {
            System.out.println("Could not delete row");
        }
    }

}