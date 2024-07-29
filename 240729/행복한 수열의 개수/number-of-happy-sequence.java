import java.util.*;

public class Main {
    static int n, m;
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) 
            for (int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();


        for (int i = 0; i < n; i++) {
            int rowNum = matrix[0][i];
            int colNum = matrix[i][0];
            int rowCnt = 1;
            int colCnt = 1;
            boolean rowCheck = false;
            boolean colCheck = false;

            for (int j = 1; j < n; j++) {

                if (matrix[i][j] == colNum) {
                    colCnt++;
                } else {
                    colCnt = 1;
                    colNum = matrix[i][j];
                }
                
                if (matrix[j][i] == rowNum) {
                    rowCnt++;
                } else {
                    rowCnt = 1;
                    rowNum = matrix[j][i];

                }

                if (rowCnt >= m) {
                    rowCheck = true;
                }

                if (colCnt >= m) {
                    colCheck = true;
                }
            }

            if (rowCheck) ans++;
            if (colCheck) ans++;
        }

        System.out.println(ans);
    }
}