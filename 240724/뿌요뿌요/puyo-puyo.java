import java.util.*;

public class Main {

    static int N;
    static int[][] matrix;
    static boolean[][] visited;
    static int maxSize = 0;
    static int ansCnt = 0;
    static int[] delta = {1, 0, -1};
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        matrix = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) continue;
                cnt = 0;
                DFS(i, j, matrix[i][j]);
                if (cnt >= 4) {
                    ansCnt++;
                }
                if (cnt > maxSize) {
                    maxSize = cnt;
                }
            }
        }

        System.out.println(ansCnt + " " + maxSize);
    }

    static void DFS(int sx, int sy, int num) {
        if (visited[sx][sy]) return;
        visited[sx][sy] = true;
        cnt++;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (Math.abs(delta[i]) == Math.abs(delta[j])) continue;
                int nx = sx + delta[i];
                int ny = sy + delta[j];

                if (0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny]) {
                    if (matrix[nx][ny] == num) {
                        DFS(nx, ny, num);
                    }
                }
            }
        }
    }
}