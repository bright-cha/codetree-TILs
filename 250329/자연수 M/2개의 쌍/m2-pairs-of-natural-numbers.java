import java.util.*;
import java.io.*;

// 두 자연수의 합이 가장 큰 경우의 최솟값

class Pair implements Comparable<Pair> {
    int cnt;
    int num;

    public Pair(int c, int n) {
        this.cnt = c;
        this.num = n;
    }

    @Override
    public int compareTo(Pair p) {
        return this.num - p.num;
    }
}

public class Main {

    public static final int MAX_M = 1000000000;
    public static final int MAX_N = 100000;
    public static final int MAX_VALUE = 1000000000;
    public static final int MAX_INTEGER = Integer.MAX_VALUE;

    public static int n, m, maxSum;
    public static Deque<Pair> dq;

    public static void main(String[] args) throws IOException {
        init();

        m = m / 2;
        while (m-- > 0) {
            Pair first = dq.pollFirst();

            Pair last;
            if (!dq.isEmpty()) {
                last = dq.pollLast();
            } else {
                last = first;
            }

            maxSum = Math.max(first.num + last.num, maxSum);

            if (--first.cnt > 0) {
                dq.addFirst(first);
            }
            if (--last.cnt > 0) {
                dq.addLast(last);
            }
        }

        System.out.println(maxSum);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int cnt = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            m += cnt;

            list.add(new Pair(cnt, num));
        }

        list.sort(Comparator.naturalOrder());

        dq = new ArrayDeque<>(list);
    }
}