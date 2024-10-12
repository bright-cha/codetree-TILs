import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX_N = 50000;
    public static final int MAX_VALUE = 1000000;

    public static int n;
    public static int[] nums = new int[MAX_N + 1];
    public static long[] leftSums = new long[MAX_N + 1];

    public static void main(String[] args) throws IOException {
        init();
        preprocessing();

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if ((leftSums[i] - leftSums[j]) % 7 == 0) {
                    ans = Math.max(ans, i - j);
                }
            }
        }

        System.out.println(ans);
    }

    public static void preprocessing() {
        for (int i = 1; i <= n; i++) {
            leftSums[i] = leftSums[i - 1] + nums[i];
        }
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(br.readLine());
            nums[i] = num;
        }
    }
}