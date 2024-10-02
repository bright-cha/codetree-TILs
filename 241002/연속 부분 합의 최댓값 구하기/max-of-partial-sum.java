import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_N = 100000;
    public static final int MAX_VALUE = 1000;
    public static final int INT_MIN = Integer.MIN_VALUE;

    public static int n;
    public static int[] numArr = new int[MAX_N + 1];
    public static int[] dp = new int[MAX_N + 1];

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(numArr[i], dp[i - 1] + numArr[i]);
        }

        int ans = INT_MIN;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
            dp[i] = INT_MIN;
        }
    }
}