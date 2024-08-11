import java.util.*;

public class Main {
    static int n;
    static int ans = Integer.MIN_VALUE;
    static int[][] grid;
    static boolean[] visited;

    public static void main(String[] args) {
        init();
        paint(0, Integer.MAX_VALUE);
        System.out.println(ans);
    }

    public static void paint(int cnt, int value) {
        if(cnt == n) {
            ans = Math.max(value, ans);
            return;
        }

        for(int i = 0; i < n; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            paint(cnt + 1, Math.min(value, grid[cnt][i]));
            visited[i] = false;
        }

        
    }

    public static void init() {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        grid = new int[n][n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
    }
}