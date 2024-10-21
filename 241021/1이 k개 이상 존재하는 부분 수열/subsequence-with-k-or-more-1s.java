import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_N = 1000000;
    public static int cntOne;
    public static int n, k;
    public static int ans = Integer.MAX_VALUE;
    public static List<Integer> loc = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        init();

        if (cntOne < k) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < loc.size() - 1; i++) {
            ans = Math.min(ans, loc.get(i + 1) - loc.get(i) + 1);
        }

        System.out.println(ans);
    }

    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num == 1) {
                cntOne++;
                loc.add(i);
            }
        }
    }
}