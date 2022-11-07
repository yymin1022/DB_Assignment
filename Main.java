import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws SQLException, FileNotFoundException {
        Scanner sqlConnDataScanner = new Scanner(new File("SQL_CONN.txt"));
        String[] sqlConnData = new String[3];
        for(int i = 0; sqlConnDataScanner.hasNextLine(); i++){
            sqlConnData[i] = sqlConnDataScanner.nextLine();
        }

        Connection connection = DriverManager.getConnection(sqlConnData[0], sqlConnData[1], sqlConnData[2]);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from USER_LIST");

        resultSet.next();
        String name = resultSet.getString("USER_ID");
        System.out.println(name);

        resultSet.close();
        statement.close();
        connection.close();
    }
}