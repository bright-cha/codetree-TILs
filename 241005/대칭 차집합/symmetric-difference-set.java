import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX_N = 200000;
    public static final int MAX_VALUE = 1000000000;

    public static int n, m;
    public static HashSet<Integer> hs1 = new HashSet<>();
    public static HashSet<Integer> hs2 = new HashSet<>();

    public static void main(String[] args) throws IOException {
        init(); 

        Iterator iter = hs1.iterator();

        int cnt = 0;
        while(iter.hasNext()) {
            if (hs2.contains(iter.next())) {
                cnt++;
            }
        }

        System.out.println(hs1.size() + hs2.size() - cnt * 2);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            hs1.add(num);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            hs2.add(num);
        }


    }
}