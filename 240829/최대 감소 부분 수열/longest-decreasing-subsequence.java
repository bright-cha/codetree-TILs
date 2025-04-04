import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_N = 1000;
    public static final int MAX_VALUE = 10000;

    public static int n;
    public static int[] dp = new int[MAX_N + 1];
    public static int[] arr = new int[MAX_N + 1];

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[i] < arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt() + 1);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}