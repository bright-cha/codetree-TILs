import java.util.*;
import java.io.*;

class Pair {
    int x;
    int y;
    int time;

    public Pair(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class Main {
    public static int MAX_N = 100;
    public static int MAX_K = MAX_N * MAX_N;

    public static int n, k;
    public static int[][] grid = new int[MAX_N][MAX_N];
    public static int[][] ans = new int[MAX_N][MAX_N];

    public static Queue<Pair> q = new ArrayDeque<>();
    public static int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        init();
        bfs();
        postProcess();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void postProcess() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ans[i][j] == Integer.MAX_VALUE) ans[i][j] = -2;
                if (grid[i][j] == 0) {
                    ans[i][j] = -1;
                }
            }
        }
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            Pair pair = q.poll();

            int x = pair.x;
            int y = pair.y;
            int time = pair.time;

            if (ans[x][y] < time)
                continue;

            for (int i = 0; i < 4; i++) {
                int nx = x + delta[i][0];
                int ny = y + delta[i][1];

                if (canGo(nx, ny, time)) {
                    q.offer(new Pair(nx, ny, time + 1));
                    ans[nx][ny] = time + 1;

                }
            }
        }
    }

    public static boolean canGo(int x, int y, int time) {
        return inRange(x, y) && grid[x][y] == 1 && ans[x][y] > time + 1;
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static void init() throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {
                int temp = sc.nextInt();
                grid[i][j] = temp;
                ans[i][j] = Integer.MAX_VALUE;
                
                if (temp == 2) {
                    q.offer(new Pair(i, j, 0));
                    ans[i][j] = 0;
                }
            }
        }
    }
}