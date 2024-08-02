import java.util.*;

public class Main {
    static int ans = Integer.MAX_VALUE;
    static String str;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        int strLeng = str.length();

        for(int i = strLeng; i > 0; i--) {
            String tempStr1 = str.substring(i) + str.substring(0, i);
            String tempStr2 = String.valueOf(tempStr1.charAt(0)) + "1";
            for(int j = 1; j < strLeng; j++) {
                if(tempStr1.charAt(j - 1) == tempStr1.charAt(j)) {
                    tempStr2 = tempStr2.substring(0, tempStr2.length() - 1) + String.valueOf(Integer.valueOf(tempStr2.substring(tempStr2.length() - 1)) + 1);
                    continue;
                }
                tempStr2 = tempStr2 + String.valueOf(tempStr1.charAt(j)) + "1";
            }
            ans = Math.min(ans, tempStr2.length());
        }

        System.out.println(ans);
    

    }
}