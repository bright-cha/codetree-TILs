import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX_N = 200000;
    public static final int MAX_VALUE = 1000000000;
    public static int n, m;
    public static long[] arr = new long[MAX_N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            long num = Long.parseLong(br.readLine());
            arr[i] = num;
        }
        Arrays.sort(arr, 0, n);

        long left = arr[0];
        long right = arr[n - 1] - arr[0];
        long ans = 0;

        while (left <= right) {
            long mid = (left + right) / 2;

            // mid를 유지하면서 놓을 수 있는 물건의 갯수.
            int cnt = 1;
            long dist = 0;
            for (int i = 1; i < n; i++) {
                dist += arr[i] - arr[i - 1];
                if (dist < mid) continue;
                cnt++;
                dist = 0;
            }

            // 물건의 갯수를 m과 비교 
            if (cnt < m) {
                right = mid - 1;
            } else {
                left = mid + 1;
                ans = Math.max(ans, mid);
            }
        }

        System.out.println(ans);
    }
}