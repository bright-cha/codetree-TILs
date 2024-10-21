import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_N = 100000;
    public static int n, s;
    public static int[] arr = new int[MAX_N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int v = 0;
            for (int j = i; j < n; j++) {
                v += arr[i];
                if (v >= s) {
                    ans = Math.min(ans, j - i + 1);
                    continue;
                }
            }
        }

        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }

        System.out.println(ans);

    }
}