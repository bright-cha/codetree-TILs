import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX_N = 100000;
    public static int n, k;
    public static int[] nums = new int[MAX_N];
    public static int[] prefixSum = new int[MAX_N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        int ans = prefixSum[k - 1];

        for (int i = k; i < n; i++) {
            ans = Math.max(ans, prefixSum[i] - prefixSum[i - k]);
        }

        System.out.println(ans);
    }
}