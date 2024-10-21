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
        int j = 0;
        int v = 0;
        for (int i = 0; i < n; i++) {
            while (j < n && v < s) {
                v += arr[j];
                j++;
            }

            if (v >= s) {
                ans = Math.min(ans, j - i);
            }
            v -= arr[i];
        }

        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }

        System.out.println(ans);

    }
}