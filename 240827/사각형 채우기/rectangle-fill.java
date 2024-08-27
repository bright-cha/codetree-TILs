import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_N = 1000;
    public static final int MOD = 10007;

    public static int n;
    public static int[] dp = new int[MAX_N + 1];

    public static void main(String[] args) throws IOException {
        init();

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.println(dp[n]);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
    }
}