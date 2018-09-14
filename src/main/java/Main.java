import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/world?characterEncoding=utf8&serverTimezone=UTC";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url, username, password);
//...
       Scanner scanner = new Scanner(System.in);
//        System.out.println("Podaj kod kraju: ");
//        String userCountryCode = scanner.nextLine();
        Statement statement = connection.createStatement();

 //     String query1 = "select * from city where CountryCode='" + userCountryCode + "'";
//       ResultSet resultSet = statement.executeQuery(query1);
//        while (resultSet.next()) {
//            int id = resultSet.getInt("ID"); //id
//            String name = resultSet.getString("Name");
//            String countryCode = resultSet.getString("CountryCode"); //code
//            String district = resultSet.getString("District");
//            int population = resultSet.getInt("Population");
//            System.out.println(id + " " + name + " " + countryCode + " " + district + " " + population);
//        }


     //   System.out.println("Podaj język: ");
        String userLanguage = scanner.nextLine();
        String query2 = "select * from countrylanguage cl join country c on cl.countryCode=c.code where language='"+userLanguage+"'";
        ResultSet resultSet = statement.executeQuery(query2);
        while(resultSet.next()){
            String country = resultSet.getString("Name");
            String isOfficial = resultSet.getString(3);
            double percentage = resultSet.getDouble(4);

            System.out.println(country+" "+isOfficial+" "+percentage);

        }

        connection.close();
        }

    }

