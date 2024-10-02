import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_N = 100;
    public static final int MAX_M = 10000;
    public static final int MAX_VALUE = 10000;
    public static final int INT_MAX = Integer.MAX_VALUE;

    public static int n, m;
    public static int[] numArr = new int[MAX_N + 1];
    public static int[] dp = new int[MAX_M + 1];

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 1; j--) {
                if (j < numArr[i]) continue;
                if (dp[j - numArr[i]] == INT_MAX) continue;

                dp[j] = Math.min(dp[j], dp[j - numArr[i]] + 1);
            }
        }

        // for (int i = 1; i <= m; i++) {
        //     System.out.printf("num = %d cnt = %d\n", i, dp[i]);
        // }

        System.out.println(dp[m] == INT_MAX ? -1 : dp[m]);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= m; i++) {
            dp[i] = INT_MAX;
        }
    }
}