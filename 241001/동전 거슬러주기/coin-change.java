import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_N = 100;
    public static final int MAX_M = 10000;
    public static final int MAX_COST = 10000;

    public static int n, m;
    public static int[] kind = new int[MAX_N];
    public static int[] dp = new int[MAX_N];

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            int money = m;

            for (int j = i; j >= 0; j--) {
                cnt += money / kind[j];
                // System.out.printf("num = %d, cnt = %d, money = %d, kind = %d\n", i, cnt, money, kind[j]);
                money -= (money / kind[j]) * kind[j] ;
            }

            if (money == 0) {
                dp[i] = cnt;
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[i]);
            // System.out.println(dp[i]);
        }

        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }

        System.out.println(ans);

    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());        

        for (int i = 0; i < n; i++) {
            kind[i] = Integer.parseInt(st.nextToken());
            dp[i] = Integer.MAX_VALUE;
        }
    }
}