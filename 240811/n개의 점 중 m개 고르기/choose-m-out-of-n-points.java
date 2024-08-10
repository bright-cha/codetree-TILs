import java.util.*;

public class Main {
    static int n, m;
    static int ans = Integer.MAX_VALUE;
    static int[][] nodeArr;
    static int[] mArr;
    static boolean[] visited;

    public static void main(String[] args) {
        init();
        solve(0, 0);
        
        System.out.println(ans);
    }

    private static void solve(int idx, int cnt) {
        if(idx == n || cnt == m) {
            if(cnt != m) return;
            int tempDist = Integer.MIN_VALUE;

            for(int i = 0; i < m; i++) {
                for(int j = i + 1; j < m; j++) {
                    int currentDist = uclidian(mArr[i], mArr[j]);
                    tempDist = Math.max(tempDist, currentDist);
                }
            }
            
            ans = Math.min(ans, tempDist);
            return;
        }

        mArr[cnt] = idx;
        solve(idx + 1, cnt + 1);
        solve(idx + 1, cnt);
    }

    private static int uclidian(int one, int two) {
        int x1 = nodeArr[one][0];
        int y1 = nodeArr[one][1];        
        int x2 = nodeArr[two][0];
        int y2 = nodeArr[two][1];

        return (int) Math.pow(x1 - x2, 2) + (int) Math.pow(y1 - y2, 2);
    }

    private static void init() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        nodeArr = new int[n][2];
        mArr = new int[m];
        visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            nodeArr[i][0] = sc.nextInt();
            nodeArr[i][1] = sc.nextInt();
        }
    }
}