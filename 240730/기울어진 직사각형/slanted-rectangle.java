import java.util.*;

public class Main {
    static int n;
    static int ans = 0;
    static int[][] matrix;

    public static void main(String[] args) {
        init();

        for(int i = 1; i < n - 1; i++) {
            for(int j = 1; j < n - 1; j++) {
                solve(i + 1, j);
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

    public static void solve(int row, int col) {
        int sumValue = 0;
        int tempRow = row;
        int tempCol = col;

        int[] dx = {-1, -1, 1, 1};
        int[] dy = {1, -1, -1, 1};

        for(int dir = 0; dir < 4; dir++) {
            while(true) {
                int nx = tempRow + dx[dir];
                int ny = tempCol + dy[dir];

                if(!inRange(nx, ny)) break;
                sumValue += matrix[tempRow][tempCol];
                tempRow = nx;
                tempCol = ny;

            }
        }

        if(sumValue > matrix[row][col] && tempRow == row && tempCol == col) {
            ans = Math.max(ans, sumValue);
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