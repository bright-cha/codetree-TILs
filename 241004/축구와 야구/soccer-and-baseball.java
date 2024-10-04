import java.util.*;
import java.io.*;

class Student {
    // 축구 능력
    int sa;
    // 야구 능력
    int ba;

    public Student(int sa, int ba) {
        this.sa = sa;
        this.ba = ba;
    }
}

public class Main {
    public static final int MAX_N = 1000;
    public static final int SOC_TOTAL = 11;
    public static final int BAS_TOTAL = 9;

    public static int n;
    public static Student[] students = new Student[MAX_N + 1];
    public static int[][][] dp = new int[MAX_N + 1][SOC_TOTAL + 1][BAS_TOTAL + 1];

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= SOC_TOTAL; j++) {
                for (int k = 0; k <= BAS_TOTAL; k++) {

                    if (j + k > i) continue;

                    // 현재 학생이 축구에 선발: 이전 학생의 결과 + 현재 학생의 능력
                    if (j + 1 <= SOC_TOTAL) {
                        dp[i][j + 1][k] = Math.max(dp[i][j + 1][k], dp[i - 1][j][k] + students[i].sa);
                    }

                    // 현재 학생이 야구에 선발
                    if (k + 1 <= BAS_TOTAL) {
                        dp[i][j][k + 1] = Math.max(dp[i][j][k + 1], dp[i - 1][j][k] + students[i].ba);
                    }
                   
                    // 현재 학생이 선발되지 않음
                    dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k]);
                }

            }
        }
        
        // for (int i = 1; i <= n; i++) {
        //     for (int j = 0; j <= SOC_TOTAL; j++) {
        //         for (int k = 0; k <= BAS_TOTAL; k++) {
        //             if (j + k > i) continue;
        //             System.out.printf("%d번 학생까지 %d명의 축구가 선발되고, %d명의 야구가 선발된 경우: %d\n", i, j, k, dp[i][j][k]);
        //         }
        //         System.out.println();
        //     }
        //     System.out.println("============================");
        // }

        int ans = 0;

        for (int a = 20; a <= n; a++) {
            ans = Math.max(dp[a][SOC_TOTAL][BAS_TOTAL], ans);
        }

        System.out.println(ans);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int sa = Integer.parseInt(st.nextToken());
            int ba = Integer.parseInt(st.nextToken());

            students[i] = new Student(sa, ba);
        }
    }
}