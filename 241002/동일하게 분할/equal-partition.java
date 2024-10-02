import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_N = 100;
    public static final int MAX_VALUE = 1000;

    public static int n, m;
    public static int[] numArr = new int[MAX_N + 1];
    public static boolean[] dp = new boolean[(MAX_N * MAX_VALUE) / 2 + 1];

    public static void main(String[] args) throws IOException {
        init();

        if (m % 2 != 0) {
            System.out.println("No");
            return;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = m / 2; j >= 1; j--) {
                if (j < numArr[i]) continue;
                if (dp[j - numArr[i]]) {
                    dp[j] = true;
                }
            }
        }

        if (dp[m / 2]) {
            System.out.println("Yes");
        }
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            numArr[i] = num;
            m += num;
        }

        dp[0] = true;
    }
}