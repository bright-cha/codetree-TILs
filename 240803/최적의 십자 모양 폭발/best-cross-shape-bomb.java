import java.util.*;

public class Main {
    static int n;
    static int[][] grid;
    static int[][] after;
    static int ans = 0;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};

    public static void main(String[] args) {
        init();
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                clearAfter();
                solve(i, j);
                gravity();
                check();
            }
        }

        System.out.println(ans);
    }

    private static void check() {
        int cnt = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(after[i][j] == 0) continue;
                for(int k = 0; k < 2; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if(inRange(nx, ny)) {
                        if(after[nx][ny] == after[i][j]) cnt++;
                    }
                }
            }
        }

        ans = Math.max(ans, cnt);
    }

    private static void gravity() {
        for(int i = 0; i < n; i++) {
            int[] zero = {-1, -1};

            for(int j = n - 1; j >= 0; j--) {
                if(after[j][i] == 0) {
                    if(zero[0] != -1) continue;
                    zero[0] = j;
                    zero[1] = i;

                } else if(zero[0] != -1) {
                    after[zero[0]][zero[1]] = after[j][i];
                    after[j][i] = 0;
                    zero[0]--;
                }
            }
        }
    }

    private static void solve(int row, int col) {
        int frequency = grid[row][col];
        after[row][col] = 0;

        while(frequency-- > 0) {
            for(int i = 0; i < 4; i++) {
                int nx = row + (dx[i] * frequency);
                int ny = col + (dy[i] * frequency);

                if(inRange(nx, ny)) {
                    after[nx][ny] = 0;
                }
            }
        }
    }

    private static boolean inRange(int row, int col) {
        if(0 <= row && row < n && 0 <= col && col < n) return true;
        return false;
    }

    private static void clearAfter() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                after[i][j] = grid[i][j];
            }
        }
    }

    private static void init() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        grid = new int[n][n];
        after = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
    }
}