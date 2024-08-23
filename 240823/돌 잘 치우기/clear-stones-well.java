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
    static int n, m, k;
    static int ans = 0;
    static int[][] grid;
    static Queue<Pair> q = new ArrayDeque<>();
    static List<int[]> stoneList = new ArrayList<>();
    static int[][] startArr;

    public static void main(String[] args) throws IOException {
        init();
        backTracking(0, 0);
        System.out.println(ans);
    }

    public static void backTracking(int cnt, int idx) {
        if (cnt == stoneList.size()) return;

        if (idx == m) {
            int value = bfs();
            ans = Math.max(ans, value);
            return;
        }

        int stoneX = stoneList.get(cnt)[0];
        int stoneY = stoneList.get(cnt)[1];

        grid[stoneX][stoneY] = 0;
        backTracking(cnt + 1, idx + 1);
        grid[stoneX][stoneY] = 1;

        backTracking(cnt + 1, idx);
    }

    public static int bfs() {
        boolean[][] visited = preprocessing();
        int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int cnt = 0;

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            cnt++;

            int x = pair.x;
            int y = pair.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + delta[i][0];
                int ny = y + delta[i][1];

                if (canGo(nx, ny) && !visited[nx][ny]) {
                    q.offer(new Pair(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }

        return cnt;
    }

    public static boolean[][] preprocessing() {
        boolean[][] visited = new boolean[n][n];

        for (int[] start : startArr) {
            q.offer(new Pair(start[0], start[1]));
            visited[start[0]][start[1]] = true;
        }

        return visited;
    }

    public static boolean canGo(int x, int y) {
        return inRange(x, y) && grid[x][y] == 0;
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][n];
        startArr = new int[k][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                int temp = Integer.parseInt(st.nextToken());
                grid[i][j] = temp;

                if (temp == 1) {
                    stoneList.add(new int[] {i, j});
                }
            }
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int tempx = Integer.parseInt(st.nextToken());
            int tempy = Integer.parseInt(st.nextToken());

            startArr[i][0] = tempx - 1;
            startArr[i][1] = tempy - 1;
        }
    }
}