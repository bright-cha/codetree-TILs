import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_N = 100000;
    public static final int MAX_Q = 100000;

    public static int n, q;
    public static TreeSet<Integer> ts = new TreeSet<>();
    public static HashMap<Integer, Integer> hm = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            ts.add(Integer.parseInt(st.nextToken()));
        }

        int cnt = 1;
        for (int num : ts) {
            hm.put(num, cnt);
            cnt++;
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            start = hm.get(ts.floor(start)) - 1;
            end = hm.get(ts.floor(end));

            System.out.println(end - start);
        }

    }
}