import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        int userType = -1;
        while(true){
            userType = initLogin();
            if(userType >= 0){
                break;
            }
        }

        initMainMenu(userType);
    }

    static int initLogin(){
        String inputID, inputPW;
        Scanner loginScanner = new Scanner(System.in);
        System.out.print("ID : ");
        inputID = loginScanner.nextLine();
        System.out.print("PW : ");
        inputPW = loginScanner.nextLine();

        ArrayList<String> listUser = new ArrayList<>(Arrays.asList("yong", "sans"));
        ArrayList<String> listPW = new ArrayList<>(Arrays.asList("1022", "1234"));
        if(listUser.contains(inputID)){
            int userIdx = listUser.indexOf(inputID);

            if(inputPW.equals(listPW.get(userIdx))){
                //Login Success

                if(inputID.equals("sans")){
                    return 0;
                }else if(inputID.equals("yong")){
                    return 1;
                }
            }

            // Wrong Password
            return -2;
        }

        // No Such User
        return -1;
    }

    static void initMainMenu(int userType){
        System.out.println("1. 사용자 정보 조회");
        System.out.println("2. 판매 상품 검색");
        System.out.printf("3. %s거래내역 조회\n", userType == 0 ? "전체 " : "");
        
        if(userType == 0){
            System.out.println("4. 상품 재고 관리");
        }
    }
}