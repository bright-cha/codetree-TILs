import java.util.*;
import java.io.*;

class Segment implements Comparable<Segment> {
    int x1;
    int x2;

    public Segment(int x1, int x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    @Override
    public int compareTo(Segment s) {
        return this.x1 - s.x1;
    }
}

public class Main {
    public static final int MAX_N = 1000;
    public static int n;
    public static Segment[] segments = new Segment[MAX_N];
    public static int[] dp = new int[MAX_N];

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                int s = segments[i].x1;
                int e = segments[j].x2;

                if (e < s) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);

    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            segments[i] = new Segment(s, e);
        }

        Arrays.sort(segments, 0, n);
    }
}