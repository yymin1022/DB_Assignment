import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        System.out.printf("%d", initLogin());
    }

    static int initLogin(){
        String inputID, inputPW;
        Scanner loginScanner = new Scanner(System.in);
        inputID = loginScanner.nextLine();
        inputPW = loginScanner.nextLine();

        ArrayList<String> listUser = new ArrayList<>(Arrays.asList("yong", "sans"));
        ArrayList<String> listPW = new ArrayList<>(Arrays.asList("1022", "1234"));
        if(listUser.contains(inputID)){
            int userIdx = listUser.indexOf(inputID);

            if(inputPW.equals(listPW.get(userIdx))){
                //Login Success
                return 0;
            }

            // Wrong Password
            return -2;
        }

        // No Such User
        return -1;
    }
}