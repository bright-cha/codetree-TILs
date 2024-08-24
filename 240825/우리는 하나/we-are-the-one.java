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
    public static final int DIR_NUM = 4;
    public static final int MAX_N = 8;

    public static int n, k, u, d;
    public static int ans = 0;

    public static int[][] grid = new int[MAX_N][MAX_N];

    public static Queue<Pair> q = new ArrayDeque<>();
    public static List<Pair> selectList = new LinkedList<>();
    public static int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static boolean[][] visited = new boolean[MAX_N][MAX_N];


    public static void main(String[] args) throws IOException {
        init();
        backTracking(0, 0);
        System.out.println(ans);
    }

    public static void backTracking(int idx, int cnt) {
        if (idx == n || cnt == k) {
            if (cnt == k) bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            backTracking(idx + 1, cnt);

            selectList.add(new Pair(idx, i));
            backTracking(idx + 1, cnt + 1);
        }
    }

    public static void bfs() {
        int cnt = 0;

        initialize();
        preprocesse();

        while (!q.isEmpty()) {
            Pair pair = q.poll();

            cnt++;

            int x = pair.x;
            int y = pair.y;

            for (int i = 0; i < DIR_NUM; i++) {
                int nx = x + delta[i][0];
                int ny = y + delta[i][1];

                if (inRange(nx, ny) && canGo(x, y, nx, ny) && !visited[nx][ny]) {
                    q.offer(new Pair(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }

        ans = Math.max(ans, cnt);
    }

    public static void initialize() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
            }
        }
    }

    public static boolean canGo(int x, int y, int nx, int ny) {
        int difference = Math.abs(grid[x][y] - grid[nx][ny]);
        
        return u <= difference && difference <= d;
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static void preprocesse() {
        Iterator<Pair> iterator = selectList.iterator();
        while (iterator.hasNext()) {
            Pair city = iterator.next();
            visited[city.x][city.y] = true;
            q.offer(city);
            iterator.remove();
        }
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}