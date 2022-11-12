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

        printAllColumns(statement, "PRODUCT_LIST");

        statement.close();
        connection.close();
    }

    static void printAllColumns(Statement dbStatement, String table) throws SQLException {
        ResultSet resultSet = dbStatement.executeQuery(String.format("select * from %s", table));

        while(resultSet.next()){
            String strProductID = resultSet.getString("ID");
            System.out.printf("Product ID : %s\n", strProductID);
            String strProductName = resultSet.getString("NAME");
            System.out.printf("Product Name : %s\n", strProductName);
            String strProductManuCompany = resultSet.getString("MANU_COMPANY");
            System.out.printf("Product Manufacture Company : %s\n", strProductManuCompany);
            String strProductManuCountry = resultSet.getString("MANU_COUNTRY");
            System.out.printf("Product Manufacture Country : %s\n", strProductManuCountry);
            String strProductPrice = resultSet.getString("PRICE");
            System.out.printf("Product Price : %s\n", strProductPrice);
            String strProductType = resultSet.getString("TYPE");
            System.out.printf("Product Type : %s\n", strProductType);
        }

        resultSet.close();
    }
}