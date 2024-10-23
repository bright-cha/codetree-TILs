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
        int right = n;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = mid * 2 - (int) Math.sqrt(mid);

            if (k < cnt) {
                right = mid - 1;
            } else if (cnt < k) {
                left = mid + 1;
            } else {
                ans = mid;
                break;
            }
        }

        System.out.println(ans);
    }
}