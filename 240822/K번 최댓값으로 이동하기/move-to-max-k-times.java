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
    static int[] ans = new int[2];
    static int[][] grid;
    static int[][] delta = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        init();

        while (k-- > 0) {
            bfs();
        }

        System.out.printf("%d %d", ans[0] + 1, ans[1] + 1);
    }

    public static void bfs() {
        Queue<Pair> q = new ArrayDeque<>();
        Pair maxNode = new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);
        boolean[][] visitedBfs = new boolean[n][n];

        q.offer(new Pair(ans[0], ans[1]));
        visitedBfs[ans[0]][ans[1]] = true;
        int maxValue = Integer.MIN_VALUE;

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            int x = pair.x;
            int y = pair.y;

            if (maxValue < grid[x][y] && grid[ans[0]][ans[1]] > grid[x][y]) {
                maxValue = grid[x][y];
                maxNode.x = x;
                maxNode.y = y;
            } else if (maxValue == grid[x][y]) {
                if (maxNode.x > x) {
                    maxNode.x = x;
                    maxNode.y = y;
                } else if (maxNode.x == x && maxNode.y > y) {
                    maxNode.x = x;
                    maxNode.y = y;
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + delta[i][0];
                int ny = y + delta[i][1];

                if (canGo(nx, ny) && !visitedBfs[nx][ny]) {
                    q.offer(new Pair(nx, ny));
                    visitedBfs[nx][ny] = true;
                }
            }
        }

        if (maxValue == Integer.MIN_VALUE) return;

        ans[0] = maxNode.x;
        ans[1] = maxNode.y;
    }

    public static boolean canGo(int nx, int ny) {
        return inRange(nx, ny) && grid[ans[0]][ans[1]] > grid[nx][ny];
    }

    public static boolean inRange(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    public static void init() throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        grid = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        ans[0] = sc.nextInt() - 1;
        ans[1] = sc.nextInt() - 1;
    }
}