import java.util.*;
import java.io.*;

public class Main {
    public static final int INT_MAX = 2000000000;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        long left = 1; 
        long right = INT_MAX;
        long ans = INT_MAX;
        while (left <= right) {
            long mid = (left + right) / 2;
            long num = (mid / 3) + (mid / 5) - (mid / 15);

            if (mid - num < n) {
                left = mid + 1;
            } else if (mid - num > n || mid % 3 == 0 || mid % 5 == 0) {
                right = mid - 1;
            } else {
                ans = mid;
                break;
            }

        }

        System.out.println(ans);
    }
}