import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_N = 100;
    public static final int MAX_M = 10000;
    public static final int MAX_COST = 10000;

    public static int n, m;
    public static int[] coin = new int[MAX_N + 1];
    public static int[] dp = new int[MAX_M + 1];

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i >= coin[j]) {
                    if (dp[i - coin[j]] == Integer.MAX_VALUE) {
                        continue;
                    }
                    dp[i] = Math.min(dp[i], dp[i - coin[j]] + 1);
                }
            }
        }
        System.out.println(dp[m] == Integer.MAX_VALUE ? -1 : dp[m]);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());        

        for (int i = 1; i <= n; i++) {
            coin[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= m; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
    }
}