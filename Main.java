import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        System.out.println("Database Design Report 4 : Dept. Software 20194094 유용민");
        while(true){
            System.out.println("********************");
            System.out.println("Please Select Menu.");
            System.out.println("1. Search Products");
            System.out.println("2. Search Transaction History");
            System.out.println("3. Search User Info");
            System.out.println("4. Exit Program");

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
                    searchUserMenu();
                    break;
                case "4":
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

    static void searchProductMenu(){
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
                    System.out.println("List All Products");
                    break;
                case "2":
                    System.out.println("List All Available Products");
                    break;
                case "3":
                    Scanner prodNameScanner = new Scanner(System.in);
                    System.out.println("Please Insert Product Name for Search");
                    String prodNameInput = prodNameScanner.nextLine();
                    System.out.printf("Product Search Result for %s\n", prodNameInput);
                    break;
                case "4":
                    Scanner prodTypeScanner = new Scanner(System.in);
                    System.out.println("Please Insert Product Type for Search");
                    String prodTypeInput = prodTypeScanner.nextLine();
                    System.out.printf("Product Search Result for %s\n", prodTypeInput);
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

    static void searchUserMenu(){
        while(true){
            System.out.println("Please Select User Search Menu.");
            System.out.println("1. List All Users");
            System.out.println("2. Search by User Name");
            System.out.println("3. Return to Main");

            Scanner menuScanner = new Scanner(System.in);
            System.out.print("Please Select Menu : ");
            String userInput = menuScanner.nextLine();
            switch(userInput){
                case "1":
                    System.out.println("List All Users");
                    break;
                case "2":
                    System.out.println("Search by User Name");
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Wrong Input. Please Try Again.");
            }
        }
    }
}