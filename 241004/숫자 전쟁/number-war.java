import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_N = 1000;
    public static final int MAX_NUM = 2000;

    public static int n;
    public static int[] first = new int[MAX_N + 1];
    public static int[] second = new int[MAX_N + 1];
    public static int[][] dp = new int[MAX_N + 1][MAX_N + 1];

    public static void main(String[] args) throws IOException {
        init();

        // 카드의 개수
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // 상우가 이기는 경우
                if (first[j] > second[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + second[i]);
                }

                // 상우가 지는 경우
                if (first[j] < second[i]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                }

                // 버리는 경우
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1]);
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }

        System.out.println(ans);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            first[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            second[i] = Integer.parseInt(st.nextToken());
        }
    }
}