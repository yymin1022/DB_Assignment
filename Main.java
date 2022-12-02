import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class Main{
    static Connection connection;
    static Statement statement;

    public static void main(String[] args) throws SQLException, FileNotFoundException {
        Scanner sqlConnDataScanner = new Scanner(new File("SQL_CONN.txt"));
        String[] sqlConnData = new String[3];
        for(int i = 0; sqlConnDataScanner.hasNextLine(); i++){
            sqlConnData[i] = sqlConnDataScanner.nextLine();
        }

        connection = DriverManager.getConnection(sqlConnData[0], sqlConnData[1], sqlConnData[2]);
        statement = connection.createStatement();

        System.out.println("Database Design Report 4 : Dept. Software 20194094 유용민");
        while(true){
            System.out.println("********************");
            System.out.println("Please Select Menu.");
            System.out.println("1. Search Products");
            System.out.println("2. Search Transaction History");
            System.out.println("3. Exit Program");

            Scanner menuScanner = new Scanner(System.in);
            System.out.print("Please Select Menu : ");
            String userInput = menuScanner.nextLine();
            switch(userInput){
                case "1":
                    System.out.println("********************");
                    searchProductMenu();
                    break;
                case "2":
                    System.out.println("********************");
                    searchTransactionMenu();
                    break;
                case "3":
                    System.out.println("********************");
                    System.out.println("Exit. Thank you for Using.");
                    return;
                default:
                    System.out.println("********************");
                    System.out.println("Wrong Input. Please Try Again.");
                    break;
            }
        }
    }

    static void searchProductMenu() throws SQLException {
        while(true){
            System.out.println("Please Select Product Search Menu.");
            System.out.println("1. List All Products");
            System.out.println("2. List All Available Products");
            System.out.println("3. Search by Product Name");
            System.out.println("4. Search by Product Type");
            System.out.println("5. Return to Main");

            Scanner menuScanner = new Scanner(System.in);
            System.out.print("Please Select Menu : ");
            String userInput = menuScanner.nextLine();
            switch(userInput){
                case "1":
                    printProduct("SELECT * FROM PRODUCT");
                    break;
                case "2":
                    printProduct("SELECT * FROM PRODUCT AS PR WHERE (SELECT COUNT FROM STOCK AS STK WHERE STK.PROD_ID=PR.ID) > 0;");
                    break;
                case "3":
                    Scanner prodNameScanner = new Scanner(System.in);
                    System.out.println("Please Insert Product Name for Search");
                    String prodNameInput = prodNameScanner.nextLine();
                    printProduct(String.format("SELECT * FROM PRODUCT WHERE NAME=\"%s\"", prodNameInput));
                    break;
                case "4":
                    Scanner prodTypeScanner = new Scanner(System.in);
                    System.out.println("Please Insert Product Type for Search");
                    String prodTypeInput = prodTypeScanner.nextLine();
                    System.out.printf("Product Search Result for %s\n", prodTypeInput);
                    printProduct(String.format("SELECT * FROM PRODUCT WHERE TYPE=\"%s\"", prodTypeInput));
                    break;
                case "5":
                    return;
                default:
                    System.out.println("Wrong Input. Please Try Again.");
            }
        }
    }

    static void searchTransactionMenu(){
        while(true){
            System.out.println("Please Select Transaction Search Menu.");
            System.out.println("1. List All Transactions");
            System.out.println("2. Search by User Name");
            System.out.println("3. Search by Product Name");
            System.out.println("4. Return to Main");

            Scanner menuScanner = new Scanner(System.in);
            System.out.print("Please Select Menu : ");
            String userInput = menuScanner.nextLine();
            switch(userInput){
                case "1":
                    System.out.println("List All Transactions");
                    break;
                case "2":
                    System.out.println("Search by User Name");
                    Scanner userNameScanner = new Scanner(System.in);
                    System.out.println("Please Insert User Name for Search");
                    String userNameInput = userNameScanner.nextLine();
                    System.out.printf("User Search Result for %s\n", userNameInput);
                    break;
                case "3":
                    Scanner prodNameScanner = new Scanner(System.in);
                    System.out.println("Please Insert Product Name for Search");
                    String prodNameInput = prodNameScanner.nextLine();
                    System.out.printf("Product Search Result for %s\n", prodNameInput);
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Wrong Input. Please Try Again.");
            }
        }
    }

    static void printProduct(String sqlsQuery) throws SQLException {
        ResultSet resultSet = statement.executeQuery(sqlsQuery);

        while(resultSet.next()){
            String strProductID = resultSet.getString("ID");
            System.out.printf("Product ID : %s : ", strProductID);
            String strProductName = resultSet.getString("NAME");
            System.out.printf("Product Name : %s / ", strProductName);
            String strProductManuCompany = resultSet.getString("MAN_COMPANY");
            System.out.printf("Product Manufacture Company : %s / ", strProductManuCompany);
            String strProductManuCountry = resultSet.getString("MAN_COUNTRY");
            System.out.printf("Product Manufacture Country : %s / ", strProductManuCountry);
            String strProductPrice = resultSet.getString("PRICE");
            System.out.printf("Product Price : %s / ", strProductPrice);
            String strProductType = resultSet.getString("TYPE");
            System.out.printf("Product Type : %s\n", strProductType);
        }

        resultSet.close();
    }

    static void printTransaction(String sqlsQuery) throws SQLException {
        ResultSet resultSet = statement.executeQuery(sqlsQuery);

        while(resultSet.next()){
            String strTransactionID = resultSet.getString("ID");
            System.out.printf("Transaction ID : %s : ", strTransactionID);
            String strProductID = resultSet.getString("ID");
            System.out.printf("Product ID : %s : ", strProductID);
            String strUserID = resultSet.getString("ID");
            System.out.printf("User ID : %s : ", strUserID);
            String strDatetime = resultSet.getString("ID");
            System.out.printf("Datetime : %s\n", strDatetime);
        }

        resultSet.close();
    }
}