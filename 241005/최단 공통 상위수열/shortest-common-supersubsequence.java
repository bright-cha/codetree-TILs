import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LEN = 1000;
    public static int lenA, lenB;
    public static String a = null;
    public static String b = null;

    public static int[] dp = new int[MAX_LEN + 1];

    public static void main(String[] args) throws IOException {
        init();

        // i번 문자와 j번 문자가 같으면 그대로 다르면 +1;
        for (int i = 1; i <= lenA; i++) {
            boolean find = false;

            for (int j = 1; j <= lenB; j++) {

                if (a.charAt(i) == b.charAt(j)) {
                    find = true;
                    break;
                }
            }

            if (find) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        
        System.out.println(dp[lenA] + lenB);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        a = br.readLine();
        b = br.readLine();
        lenA = a.length();
        lenB = b.length();
        a = " " + a;
        b = " " + b;
    }
}