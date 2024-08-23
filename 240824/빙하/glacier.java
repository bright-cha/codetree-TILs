import java.io.*;
import java.util.*;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n, m;
    static int[][] grid;
    static int[] ans = new int[2];
    static boolean isIce = true;
    static Queue<Pair> q = new ArrayDeque<>();
    static int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static LinkedList<int[]> iceList = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        init();

        while (isIce) {
            bfs();
            melt();
            ans[0]++;
        }

        System.out.println(ans[0] + " " + ans[1]);
    }

    public static void melt() {
        if (ans[1] != iceList.size()) {
            ans[1] -= iceList.size();
        } else {
            isIce = false;
        }
        
        while (!iceList.isEmpty()) {
            int[] ice = iceList.poll();

            grid[ice[0]][ice[1]] = 0;
        }
    }

    public static void bfs() {
        q.offer(new Pair(0, 0));
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int x = pair.x;
            int y = pair.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + delta[i][0];
                int ny = y + delta[i][1];

                if (inRange(nx, ny) && !visited[nx][ny]) {
                    if (grid[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        q.offer(new Pair(nx, ny));
                    }

                    if (grid[nx][ny] == 1) {
                        iceList.add(new int[] {nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                int temp = Integer.parseInt(st.nextToken());
                grid[i][j] = temp;

                if (temp == 1) ans[1]++;
            }
        }
    }
}