import java.util.*;

public class Main {
    static int n, m;
    static int ans = -1;
    static int[][] grid;

    public static void main(String[] args) {
        init();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                solve(i, j);
            }
        }

        System.out.println(ans);
    }

    public static void solve(int row, int col) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                checkSize(row, col, i, j);
            }
        }
    }

    public static void checkSize(int x1, int y1, int x2, int y2) {
        int size = 0;

        for(int i = x1; i <= x2; i++) {
            for(int j = y1; j <= y2; j++) {
                if(grid[i][j] <= 0) return;
                size++;
            }
        }

        if(size > 0) {
            ans = Math.max(ans, size);
        }
    }

    public static void init() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
    }
}