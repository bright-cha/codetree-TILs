import java.util.*;
import java.io.*;

// 두 자연수의 합이 가장 큰 경우의 최솟값

public class Main {

    public static final int MAX_M = 1000000000;
    public static final int MAX_N = 100000;
    public static final int MAX_VALUE = 1000000000;
    public static final int MAX_INTEGER = Integer.MAX_VALUE;

    public static int n, m;
    public static int minSum = MAX_INTEGER;

    public static PriorityQueue<Integer> ascPq = new PriorityQueue<>();
    public static PriorityQueue<Integer> descPq = new PriorityQueue<>(Comparator.reverseOrder());

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < m / 2; i++) {
            int cur = ascPq.poll() + descPq.poll();

            minSum = Math.min(cur, minSum);
        }

        System.out.println(minSum);

    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int cnt = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            m += cnt;

            while (cnt-- > 0) {
                ascPq.add(num);
                descPq.add(num);
            }
        }
    }
}