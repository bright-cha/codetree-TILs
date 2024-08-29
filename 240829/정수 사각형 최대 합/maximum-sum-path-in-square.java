import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_N = 100;
    public static final int MAX_VALUE = 1000000;

    public static int n;
    public static int[][] grid = new int[MAX_N][MAX_N];
    public static int[][] dp = new int[MAX_N][MAX_N];

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + grid[i][j]);
                }

                if (j - 1 >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + grid[i][j]);
                }
            }
        }

        System.out.println(dp[n - 1][n - 1]);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                int temp = Integer.parseInt(st.nextToken());
                grid[i][j] = temp;
                dp[i][j] = temp;
            }
        }

    }
}