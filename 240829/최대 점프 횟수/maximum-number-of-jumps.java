import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_N = 1000;
    public static final int MAX_VALUE = 1000;

    public static int n;
    public static int[] arr = new int[MAX_N];
    public static int[] dp = new int[MAX_N];

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] == 0) continue;

                if(j + arr[j] >= i)
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }

            if (dp[i] == 0) break;
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}