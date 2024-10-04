import java.util.*;
import java.io.*;

class Clothes implements Comparable<Clothes> {
    int s;
    int e;
    int p;

    public Clothes(int s, int e, int p) {
        this.s = s;
        this.e = e;
        this.p = p;
    }

    @Override
    public int compareTo(Clothes c) {
        if (this.s != c.s) {
            return this.s - c.s;
        } 
        return this.e - c.e;
    }
}

public class Main {
    public static final int MAX_N = 200;
    public static final int MAX_M = 200;

    public static int n, m;
    public static Clothes[] info = new Clothes[MAX_N + 1];
    public static int[][] dp = new int[MAX_M + 1][MAX_N + 1];

    public static void main(String[] args) throws IOException {
        init();

        // i번 날에, j번 옷을 입은 경우의 최대값 구하기
        // ex) 2번째날에, 2번 옷을 입은 경우, 1번 날에 가능한 옷들과의 차를 구해서 기입한다.
        for (int i = 2; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                Clothes cur = info[j];

                if (cur.e < i || i < cur.s) continue;
    
                for (int k = 1; k <= n; k++) {
                    Clothes prev = info[k];

                    if (prev.e < i - 1 || i - 1 < prev.s) continue;

                    // j번째 옷을 입은 경우 만족도
                    int score = Math.abs(prev.p - cur.p);
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + score);
                }

            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, dp[m][i]);
        }

        System.out.println(ans);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            info[i] = new Clothes(s, e, p);
        }

        Arrays.sort(info, 1, n + 1);

        // for (int i = 1; i <= n; i++) {
        //     System.out.printf("%d번 시작일: %d, 종료일: %d: 점수: %d \n", i, info[i].s, info[i].e, info[i].p);
        // }

    }
}