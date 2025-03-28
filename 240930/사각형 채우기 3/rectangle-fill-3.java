import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_N = 1000;
    public static final int MOD = 1000000007;
    public static int n;
    public static long[] dp = new long[MAX_N + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 7;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] * 2 + dp[i - 2] * 3) % MOD;
            for (int j = i; j >= 3; j--) {
                dp[i] = (dp[i] + dp[i - j] * 2) % MOD;
            }
        }

        System.out.println(dp[n]);

    }
}