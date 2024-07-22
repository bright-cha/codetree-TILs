import java.util.*;
public class Main {
    static int N;
    static int M;
    static boolean[] visited;
    static int[][] matrix;
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        visited = new boolean[N];

        matrix = new int[N][N];

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;

            matrix[x][y] = 1;
            matrix[y][x] = 1;
        }

        visited[0] = true;
        DFS(0);
        System.out.print(cnt);
    }

    static void DFS(int vertex) {
        for (int i = 1; i < N; i++) {
            if (matrix[vertex][i] == 1 && !visited[i]) {
                visited[i] = true;
                cnt++;
                DFS(i);
            }
        }
    }
}