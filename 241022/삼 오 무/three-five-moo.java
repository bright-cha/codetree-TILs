import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_N = 1000000000;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int left = 1; 
        int right = MAX_N;
        int ans = MAX_N;
        while (left <= right) {
            int mid = (left + right) / 2;
            int num = (mid / 3) + (mid / 5) - (mid / 15);

            if (mid - num == n) {
                ans = mid;
                break;
            } else if (mid - num > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        System.out.println(ans);
    }
}