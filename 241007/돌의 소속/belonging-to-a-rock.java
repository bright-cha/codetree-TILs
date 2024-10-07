import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX_N = 100000;
    public static final int MAX_Q = 100000;
    public static int n, q;
    public static int[] nums = new int[MAX_N + 1];
    public static int[] firsts = new int[MAX_N + 1];
    public static int[] seconds = new int[MAX_N + 1];
    public static int[] thirties = new int[MAX_N + 1];

    public static void main(String[] args) throws IOException {
        init();
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            firsts[i] = firsts[i - 1];
            seconds[i] = seconds[i - 1];
            thirties[i] = thirties[i - 1];

            switch (nums[i]) {
                case 1:
                    firsts[i]++;
                    break;
                case 2:
                    seconds[i]++;
                    break;
                case 3:
                    thirties[i]++;
                    break;
            }
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            System.out.println((firsts[end] - firsts[start - 1]) + " " + (seconds[end] - seconds[start - 1]) + " " + (thirties[end] - thirties[start - 1]));
        }
    }
}