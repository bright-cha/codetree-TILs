import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX_A_LEN = 1000;
    public static final int MAX_B_LEN = 1000;

    public static String a = null;
    public static String b = null;
    public static int lenA, lenB;
    public static int[][] dp = new int[MAX_A_LEN + 1][MAX_B_LEN + 1];

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 1; i <= lenA; i++) {
            for (int j = 1; j <= lenB; j++) {
                // i번 문자와 j번 문자가 같은 경우 +1, 아닌 경우 그대로
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // for (int i = 1; i <= lenA; i++) {
        //     for (int j = 1; j <= lenB; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        System.out.println(dp[lenA][lenB]);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        a = br.readLine();
        b = br.readLine();
        lenA = a.length();
        lenB = b.length();
    }
}