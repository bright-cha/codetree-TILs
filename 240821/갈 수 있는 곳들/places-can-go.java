import java.util.*;
import java.io.*;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n, k;
    static int ans = 0;
    static int[][] grid;
    static boolean[][] visited;
    static Queue<Pair> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        init();
        bfs();
        System.out.println(ans);
    }

    public static void bfs() {
        int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int x = pair.x;
            int y = pair.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + delta[i][0];
                int ny = y + delta[i][1];

                if (inRange(nx, ny) && !visited[nx][ny]) {
                    if (grid[nx][ny] == 1) continue;
                    visited[nx][ny] = true;
                    q.offer(new Pair(nx, ny));
                    ans++;
                }
            }
        }
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        grid = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int tempx = Integer.parseInt(st.nextToken()) - 1;
            int tempy = Integer.parseInt(st.nextToken()) - 1;
            q.offer(new Pair(tempx, tempy));
            visited[tempx][tempy] = true;
            ans++;
        }
    }

}