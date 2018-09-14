import java.sql.*;
import java.util.Scanner;

public class UpdateData {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf8&serverTimezone=UTC";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url, username, password);


        Scanner scan = new Scanner(System.in);
       // System.out.println("Podaj miasto: ");
        String userCity = scan.nextLine();
      //  System.out.println("Podaj nową liczbę ludności: ");
        int userPopulation = scan.nextInt();

        String query = "update city set population=? where name=?";
        PreparedStatement prepStmt = connection.prepareStatement(query);
        prepStmt.setInt(1, userPopulation);
        prepStmt.setString(2, userCity);

        System.out.println("Zaktualizowane rekordy: " + prepStmt.executeUpdate());//wykonanie updatu i wypisanie liczby zmienonych rekordów

        String query2 = "select * from city where name='" + userCity + "'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query2);
        resultSet.next();


        int id = resultSet.getInt("ID");
        String name = resultSet.getString("Name");
        int population = resultSet.getInt("Population");
        System.out.println(id + " " + name + " " + population);

        connection.close();

    }
}
