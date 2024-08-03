import java.util.*;

public class Main {
    static int n;
    static int ans = 0;
    static int[][] grid;
    static int[] startX = {1, 1, n, 0};
    static int[] startY = {0, n, 1, 1};
    // 오, 왼, 위, 아래
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        init();

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < n; j++) {
                solve(i, j);
            }
        }

        System.out.println(ans);
    }

    private static void solve(int dir, int idx) {
        int time = 2;

        int x = startX[dir];
        int y = startY[dir];
        if(x == 1) x *= idx;
        if(y == 1) y *= idx;

        while(inRange(x, y)) {
            x += dx[dir];
            y += dy[dir];

            if(!inRange(x, y)) break;
            if(grid[x][y] == 1) dir = meetOne(dir);
            if(grid[x][y] == 2) dir = meetTwo(dir);

            time++;
        }

        ans = Math.max(time, ans);
    }

    private static int meetOne(int dir) {
        switch(dir) {
            case 0:
                return 2;
            case 1:
                return 3;
            case 2:
                return 0;
            case 3:
                return 1;
        }
        return dir;
    }

    private static int meetTwo(int dir) {
        switch(dir) {
            case 0:
                return 3;
            case 1:
                return 2;
            case 2:
                return 1;
            case 3:
                return 0;
        }
        return dir;
    }

    private static boolean inRange(int row, int col) {
        if(0 <= row && row < n && 0 <= col && col < n) return true;
        return false;
    }

    private static void init() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        grid = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
    }
}