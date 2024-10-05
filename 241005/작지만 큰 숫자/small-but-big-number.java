import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX_N = 100000;
    public static final int MAX_M = 100000;
    public static final int MAX_VALUE = 1000000000;

    public static int n, m;
    public static TreeSet<Integer> ts = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        init();
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            ts.add(num);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());

            System.out.println(ts.floor(num));
            if (ts.contains(ts.floor(num)) != null) {
                ts.remove(ts.floor(num));
            } else {
                System.out.println(-1);
            }
        }


    }
}