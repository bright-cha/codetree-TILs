import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_N = 1000000;
    public static int n, k;
    public static int ans = Integer.MAX_VALUE;
    public static int[] arr = new int[MAX_N];

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < n; i++) {
            int cnt = 0; 

            for (int j = i; j < n; j++) {
                if (arr[j] == 1) cnt++;
                if (cnt == k) {
                    ans = Math.min(ans, j - i + 1);
                }
            }
        }

        if (ans == Integer.MAX_VALUE) {
            ans = -1;
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
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}