import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX_N = 100;
    public static final int MAX_VALUE = 1000000;

    public static int n;
    public static int[][] grid = new int[MAX_N][MAX_N];
    public static int[][] dp = new int[MAX_N][MAX_N];

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]);
                dp[i][j] = Math.max(dp[i][j], grid[i][j]);
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
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = grid[0][0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(grid[i][0], dp[i - 1][0]);
            dp[0][i] = Math.max(grid[0][i], dp[0][i - 1]);
        }
    }
}