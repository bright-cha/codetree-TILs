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
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int num = (mid / 3) + (mid / 5) - (mid / 15) + 1;

            if (n < num) {
                right = mid - 1;
            } else if (num < n) {
                left = mid + 1;
            } else {
                ans = mid;
                break;
            }

        }

        System.out.println(ans);
    }
}