import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX_N = 100000;
    public static final int MAX_VALUE = 1000000000;
    public static int n;
    public static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        init();

        Collection<Integer> values = map.values();

        long ans = 0L;
        for (int value : values) {
            ans += value;
        }

        System.out.println(ans);

    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (map.containsKey(k)) {
                int prev = map.get(k);
                map.put(k, Math.min(prev, v));
            } else {
                map.put(k, v);
            }
        }
    }
}