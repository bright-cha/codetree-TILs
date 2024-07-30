import java.util.*;

public class Main {
    static int n, m;
    static int ans = 0;
    static int maxProfit = 0;
    static int[][] matrix;

    public static void main(String[] args) {
        init();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                solve(i, j);
            }
        }

        System.out.print(ans);
    }

    private static void init() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        matrix = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
    }

    private static boolean inScope(int row, int col) {
        if (0 <= row && row < n && 0 <= col && col < n)
            return true;
        return false;
    }

    private static int findOutCost(int ground) {
        return ground * ground + (ground + 1) * (ground + 1);
    }

    private static void solve(int row, int col) {
        for(int k = 0; k <= 2 * (n - 1); k++) {
            int gold = 0;

            for(int i = -k; i <= k; i++) {
                for(int j = -k; j <= k; j++) {
                    if (Math.abs(i) + Math.abs(j) > k) continue;
                    int nx = row + i;
                    int ny = col + j;

                    if (inScope(nx, ny)) {
                        if (matrix[nx][ny] == 1) gold++;
                    }
                }
            }

            if(gold * m - findOutCost(k) >= 0) {
                ans = Math.max(ans, gold);
            }
        }
        

    }
}