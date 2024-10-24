import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX_N = 100000;
    public static final int MAX_M = 100000;
    public static final int MAX_TIME = 1440;
    public static int n, m, left;
    public static int[] times = new int[MAX_N];

    public static void main(String[] args) throws IOException {
        init();

        int right = n * MAX_TIME;
        int ans = Integer.MAX_VALUE;

        while (left <= right) {
            // 한 레인 당 최대 이용시간
            int mid = (left + right) / 2;

            int time = 0;
            int line = 1;
            for (int i = 0; i < n; i++) {
                if (time + times[i] > mid) {
                    line++;
                    time = 0;
                }
                time += times[i];
            }

            // System.out.println(left + " " + right + " " + mid + " " + line);

            if (line <= m) {
                right = mid - 1;
                ans = Math.min(ans, mid);
            } else {
                left = mid + 1;
            }
        }

        System.out.println(ans);

    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            times[i] = num;
            left = Math.max(left, num);
        }
    }
}