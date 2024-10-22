import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX_N = 10000;
    public static final int MAX_M = 100000;
    public static final int MAX_VALUE = 100000;

    public static int n, m;
    public static int[] arr = new int[MAX_N];

    public static void main(String[] args) throws IOException {
        init();

        int left = 1;
        int right = Arrays.stream(arr).max().getAsInt();
        int ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;

            for (int i = 0; i < n; i++) {
                cnt += arr[i] / mid;
            }

            if (cnt < m) {
                right = mid - 1;
            } else {
                left = mid + 1;
                ans = Math.max(ans, mid);
            }
        }

        System.out.println(ans);
    }
    
    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
    }
}