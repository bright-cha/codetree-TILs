import java.util.*;

public class Main {
    static int n;
    static int[][] matrix;
    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        matrix = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                ask(i, j);
            }
        }

        System.out.print(ans);
    }

    private static void ask(int x, int y) {
        int cnt = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[x + i][y + j] == 1)
                    cnt++;
            }
        }

        ans = Math.max(cnt, ans);
    }
}