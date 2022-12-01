import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        System.out.println("Database Design Report 4 : Dept. Software 20194094 유용민");
        while(true){
            System.out.println("1. Search Products");
            System.out.println("2. Search Transaction History");
            System.out.println("3. Search User Info");
            System.out.println("4. Exit Program");

            Scanner menuScanner = new Scanner(System.in);
            System.out.print("Please Select Menu : ");
            String userInput = menuScanner.nextLine();
            switch (userInput) {
                case "1":
                    searchProductMenu();
                    break;
                case "2":
                    searchTransactionMenu();
                    break;
                case "3":
                    searchUserMenu();
                    break;
                case "4":
                    System.out.println("Exit. Thank you for Using.");
                    return;
                default:
                    System.out.println("Wrong Input. Please Try Again.");
                    break;
            }
        }
    }

    static void searchProductMenu(){
        System.out.println("Product Search Menu!");
    }

    static void searchTransactionMenu(){
        System.out.println("Transaction Search Menu!");
    }

    static void searchUserMenu(){
        System.out.println("User Search Menu!");
    }
}