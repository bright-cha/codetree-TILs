import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_N = 1000;
    public static final int MAX_M = 100;
    public static final int MAX_CNT = 1000;

    public static int n, m;
    public static int[][] grid = new int[MAX_N + 1][MAX_M + 1];
    public static int[][] dp = new int[MAX_N + 1][MAX_M + 1];

    public static void main(String[] args) throws IOException {
        init();

        // dp[i][j]: i층의 j번방을 마지막으로 들어간 경우의 보물의 최대값
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= m; k++) {
                    
                    if (j == k) continue;

                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + grid[i][j]);
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= m; i++) {
            ans = Math.max(ans, dp[n][i]);
        }

        System.out.println(ans);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }
}