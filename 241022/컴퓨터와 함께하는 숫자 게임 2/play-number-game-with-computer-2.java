import java.util.*;
import java.io.*;

public class Main {
    public static final long MAX_M = 1000000000000000000L;
    public static long m, a, b, s, e;
    public static int cnt;
    public static int minAns = Integer.MAX_VALUE;
    public static int maxAns = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        init();

        for (long i = s; i <= e; i++) {
            cnt = 0;
            binarySearch(1, m, i);
        }

        System.out.println(minAns + " " + maxAns);
    }

    public static void binarySearch(long start, long end, long goal) {
        if (start > end) return;

        long middle = (start + end) / 2;
        cnt++;
        
        if (middle == goal) {
            minAns = Math.min(minAns, cnt);
            maxAns = Math.max(maxAns, cnt);
            return;
        } else if (goal < middle) {
            binarySearch(start, middle - 1, goal);
        } else if (middle < goal) {
            binarySearch(middle + 1, end, goal);
        }
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
    }
}