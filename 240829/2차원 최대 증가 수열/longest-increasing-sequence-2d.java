import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX_N = 50;
    public static final int MAX_M = 50;
    public static final int MAX_VALUE = 10000;

    public static int n, m, ans;
    public static int[][] grid = new int[MAX_N][MAX_M];
    public static int[][] dp = new int[MAX_N][MAX_M];

    public static void main(String[] args) throws IOException {
        init();

        dp[0][0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                for (int x = 0; x < i; x++) {
                    for (int y = 0; y < j; y++) {
                        if (dp[x][y] == 0) continue;
                        if (grid[i][j] > grid[x][y]) {
                            dp[i][j] = Math.max(dp[i][j], dp[x][y] + 1);
                        }
                    }
                }

                ans = Math.max(ans, dp[i][j]);
            }
        }

        System.out.println(ans);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
    }
}