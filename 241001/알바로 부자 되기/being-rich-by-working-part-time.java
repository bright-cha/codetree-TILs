import java.io.*;
import java.util.*;

class Arbeit implements Comparable<Arbeit> {
    int s;
    int e;
    int p;

    public Arbeit(int s, int e, int p) {
        this.s = s;
        this.e = e;
        this.p = p;
    }

    @Override
    public int compareTo(Arbeit a) {
        return this.s - a.s;
    }
    
}

public class Main {
    public static final int MAX_N = 1000;
    public static int n;
    public static Arbeit[] arbeit = new Arbeit[MAX_N];
    public static int[] dp = new int[MAX_N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            arbeit[i] = new Arbeit(s, e, p);
        }

        for (int i = 0; i < n; i++) {
            dp[i] = arbeit[i].p;
            
            for (int j = 0; j < i; j++) {
                int start = arbeit[i].s;
                int end = arbeit[j].e;

                if (end < start) {
                    dp[i] = Math.max(dp[i], dp[j] + arbeit[i].p);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}