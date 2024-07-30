import java.util.*;

public class Main {
    static int n;
    static int ans = 0;
    static int[][] matrix;
    static int startRow, startCol;
    static int[] dx = {-1, -1, 1, 1};
    static int[] dy = {1, -1, -1, 1};

    public static void main(String[] args) {
        init();

        for(int i = 2; i < n; i++) {
            for(int j = 1; j < n - 1; j++) {
                startRow = i;
                startCol = j;
                solve(i, j, 0, 0);
            }
        }

        System.out.println(ans);
    }

    public static void init() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        matrix = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
    }

    public static void solve(int row, int col, int dir, int value) {
        if(row == startRow && col == startCol && dir == 3) {
            ans = Math.max(ans, value);
            return;
        }

        if(dir == 3 && (row > startRow || col > startCol)) return;

        int nx = row + dx[dir];
        int ny = col + dy[dir];

        if(inRange(nx, ny)) {
            solve(nx, ny, dir, value + matrix[nx][ny]);
        }

        if(dir == 3 || row == startRow && col == startCol) return;

        nx = row + dx[dir + 1];
        ny = col + dy[dir + 1];

        if(inRange(nx, ny)) {
            solve(nx, ny, dir + 1, value + matrix[nx][ny]);
        }
    }

    public static boolean inRange(int row, int col) {
        if(0 <= row && row < n && 0 <= col && col < n) {
            if((row == 0 || row == n || row == -n) && (col == 0 || col == n || col == -n)) return false;
            return true;
        }
        return false;
    }
}