import java.util.*;

public class Main {
    static int n, m;
    static int ans = 0;
    static int[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }        

        bfs(0, 0);

        System.out.println(ans);
    }

    public static void bfs(int x, int y) {
        int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visited = new boolean[n][m];

        Queue<int[]> q = new ArrayDeque<>();
        
        q.offer(new int[] {x, y});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] node = q.poll();
            x = node[0];
            y = node[1];

            if (x == n - 1 && y == m - 1) {
                ans = 1;
                return;
            }

            for(int i = 0; i < 4; i++) {
                int nx = x + delta[i][0];
                int ny = y + delta[i][1];

                if (inRange(nx, ny) && !visited[nx][ny]) {
                    if (grid[nx][ny] == 0) continue;
                    visited[nx][ny] = true;
                    q.offer(new int[] {nx, ny});
                }
            }
        }
    }

    public static boolean inRange(int x, int y) {
        if (0 <= x && x < n && 0 <= y && y < m) return true;
        return false;
    }
}