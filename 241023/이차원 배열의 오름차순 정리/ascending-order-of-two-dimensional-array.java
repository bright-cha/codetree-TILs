import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX_N = 100000;

    public static long n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        long left = 1;
        long right = n * n;
        long ans = n * n;

        while (left <= right) {
            long mid = (left + right) / 2;
            
            long cnt = 0;
            for (int i = 1; i <= n; i++) {
                cnt += Math.min(n, mid / i);
            }

            if (cnt < k) {
                left = mid + 1;
            } else if (cnt >= k) {
                right = mid - 1;
                ans = Math.min(ans, mid);
            }
        }

        System.out.println(ans);
    }
}