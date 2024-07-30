import java.util.*;

public class Main {
    static int n, m;
    static int ans = 0;
    static int[][] matrix;

    public static void main(String[] args) {
        init();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                check1(i, j);
                check2(i, j);
            }
        }

        System.out.println(ans);
    }

    private static void init() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        matrix = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
    }

    private static void check1(int row, int col) {
        // ㄴ 모양
        if(inScope(row - 1, col) && inScope(row, col + 1)) {
            ans = Math.max(ans, matrix[row][col] + matrix[row - 1][col] + matrix[row][col + 1]);
        }

        // 90도 돌린 모양
        if(inScope(row + 1, col) && inScope(row, col + 1)) {
            ans = Math.max(ans, matrix[row][col] + matrix[row + 1][col] + matrix[row][col + 1]);
        }

        // 180도 돌린 모양
        if(inScope(row + 1, col) && inScope(row, col - 1)) {
            ans = Math.max(ans, matrix[row][col] + matrix[row + 1][col] + matrix[row][col - 1]);
        }

        // 270도 돌린 모양
        if(inScope(row - 1, col) && inScope(row, col - 1)) {
            ans = Math.max(ans, matrix[row][col] + matrix[row - 1][col] + matrix[row][col - 1]);
        }

    }

    private static void check2(int row, int col) {
        // 가로
        if(inScope(row, col + 2)) {
            ans = Math.max(ans, matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]);
        }

        // 세로
        if(inScope(row + 2, col)) {
            ans = Math.max(ans, matrix[row][col] + matrix[row + 1][col] + matrix[row + 2][col]);
        }
    }

    private static boolean inScope(int row, int col) {
        if (0 <= row && row < n && 0 <= col && col < m) 
            return true;
        else
            return false;
    }
}