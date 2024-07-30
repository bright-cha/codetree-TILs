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
            for(int j = 1; j < n; j++) {
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
        if(dir == 2 && row >= startRow) return;
        if(matrix[startRow][startCol] < value) {
            if(startRow == row && startCol == col) {
                ans = Math.max(value, ans);
                return;
            }
            if(startRow <= row && startCol <= col) return;
        }

        value += matrix[row][col];

        // 직진 가능 시 직진
        int nx = row + dx[dir];
        int ny = col + dy[dir];
        if(inRange(nx, ny)) {
            solve(nx, ny, dir, value);
        }

        // 방향전환 가능 시 방향전환
        dir = (dir + 1) % 4;
        nx = row + dx[dir];
        ny = col + dy[dir];
        if(inRange(nx, ny)) {
            solve(nx, ny, dir, value);
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