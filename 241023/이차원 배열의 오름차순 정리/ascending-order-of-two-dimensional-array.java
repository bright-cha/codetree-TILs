import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX_N = 100000;

    public static int n, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        int left = 1;
        int right = n * n;
        
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                cnt += Math.min(n, mid / i);
            }

            if (cnt < k) {
                left = mid + 1;
            } else if (cnt > k) {
                right = mid - 1;
            } else {
                ans = mid;
                break;
            }
        }

        System.out.println(ans);
    }
}