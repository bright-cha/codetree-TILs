import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LEN = 1000;

    public static int lenA, lenB;
    public static String a = " ";
    public static String b = " ";
    public static int[][] dp = new int[MAX_LEN + 1][MAX_LEN + 1];

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 1; i <= lenA; i++) {
            for (int j = 1; j <= lenB; j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]) + 1;
                }
            }
        }
        

        System.out.println(dp[lenA][lenB]);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        a += br.readLine();
        b += br.readLine();
        lenA = a.length() - 1;
        lenB = b.length() - 1;

        for(int i = 1; i <= lenA; i++)
            dp[i][0] = i;
    
        for(int j = 1; j <= lenB; j++)
            dp[0][j] = j;
    }
}