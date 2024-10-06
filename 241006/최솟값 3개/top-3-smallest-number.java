import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX_N = 100000;
    public static final int MAX_VALUE = 100000;

    public static int n;
    public static int[] arr = new int[MAX_N];
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < n; i++) {
            pq.add(arr[i]);

            if (pq.size() < 3) {
                System.out.println(-1);
                continue;
            }

            int num1 = pq.poll();
            int num2 = pq.poll();
            int num3 = pq.poll();

            pq.add(num1);
            pq.add(num2);
            pq.add(num3);

            System.out.println((long) num1 * num2 * num3);
        }
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}