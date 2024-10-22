import java.io.*;
import java.util.*;

public class Main {
    public static final long MAX_S = 1000000000000000000L;
    public static long s, ans;   

    public static void main(String[] args) throws IOException {
        init();

        long left = 1;
        long right = s;
        long ans = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            long sumValue = mid * (mid + 1) / 2;
            
            if (s < sumValue) {
                right = mid - 1;
            } else if (sumValue <= s) {
                left = mid + 1;
                ans = Math.max(ans, mid);
            }
        }

        System.out.println(ans);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = Long.parseLong(br.readLine());
    }
}