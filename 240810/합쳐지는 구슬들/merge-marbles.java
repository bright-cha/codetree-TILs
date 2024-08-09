import java.util.*;

public class Main {
    static int n, m, t;
    static int[] ans = new int[2];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static Bead[] beads;
    static int[][] grid;

    public static void main(String[] args) {
        init();

        while(t-- > 0) {
            move();
            check();
        }

        System.out.println(ans[0] + " " + ans[1]);
    }

    public static void check() {
        for(int i = 1; i <= m; i++) {
            if(beads[i] == null) continue;

            Bead bead = beads[i];
            int x = bead.row;
            int y = bead.col;

            if(grid[x][y] != 0) {
                Bead bead2 = beads[grid[x][y]];

                int bigNum;
                int newDir;
                int newWeight = bead.weight + bead2.weight;

                if(bead.num > bead2.num) {
                    bigNum = bead.num;
                    newDir = bead.dir;
                    beads[bead2.num] = null;
                } else {
                    bigNum = bead2.num;
                    newDir = bead2.dir;
                    beads[bead.num] = null;
                }

                beads[bigNum] = new Bead(bigNum, x, y, newDir, newWeight);
                ans[0]--;
                ans[1] = Math.max(ans[1], newWeight);
                grid[x][y] = bigNum;
                continue;
            }
            grid[x][y] = bead.num;
        }
    }

    public static void move() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0) continue;
                int num = grid[i][j];
                Bead bead = beads[num];
                int nx = i + dx[bead.dir];
                int ny = j + dy[bead.dir];

                if(inRange(nx, ny)) {
                    bead.row = nx;
                    bead.col = ny;
                } else {
                    bead.dir = (bead.dir + 2) % 4;
                }

                grid[i][j] = 0;
            }
        }
    }

    public static boolean inRange(int x, int y) {
        if (0 <= x && x < n && 0 <= y && y < n) return true;
        return false;
    }

    public static void init() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        t = sc.nextInt();
        grid = new int[n][n];
        beads = new Bead[m + 1];
        ans[0] = m;

        for(int i = 1; i <= m; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            String d = sc.next();
            int dir = 0;
            switch(d) {
                case "R":
                    dir = 0;
                    break;
                case "D":
                    dir = 1;
                    break;
                case "L":
                    dir = 2;
                    break;
                case "U":
                    dir = 3;
                    break;
            }
            int w = sc.nextInt();

            beads[i] = new Bead(i, r, c, dir, w);
            grid[r][c] = i;
            ans[1] = Math.max(ans[1], w);
        }

    }

    public static class Bead {
        int num;
        int row;
        int col;
        int dir;
        int weight;

        public Bead(int num, int row, int col, int dir, int weight) {
            this.num = num;
            this.row = row;
            this.col = col;
            this.dir = dir;
            this.weight = weight;
        }
    }
}