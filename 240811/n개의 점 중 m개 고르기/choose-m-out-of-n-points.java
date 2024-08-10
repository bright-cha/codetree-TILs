import java.util.*;

public class Main {
    static int n, m;
    static int ans = Integer.MAX_VALUE;
    static int[][] nodeArr;
    static int[] mArr;

    public static void main(String[] args) {
        init();
        solve(0);
        
        System.out.println((int) Math.pow(ans, 2));
    }

    private static void solve(int cnt) {
        if(cnt == m) {
            for(int i = 0; i < m; i++) {
                for(int j = i + 1; j < m; j++) {
                    uclidian(i, j);
                }
            }
            return;
        }

        for(int i = cnt; i < n; i++) {
            mArr[cnt] = i;
            solve(cnt + 1);
        }
    }

    private static void uclidian(int one, int two) {
        int x1 = nodeArr[one][0];
        int y1 = nodeArr[one][1];        
        int x2 = nodeArr[two][0];
        int y2 = nodeArr[two][1];

        int dist = (int) Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        ans = Math.min(ans, dist);
    }

    private static void init() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        nodeArr = new int[n][2];
        mArr = new int[m];

        for(int i = 0; i < n; i++) {
            nodeArr[i][0] = sc.nextInt();
            nodeArr[i][1] = sc.nextInt();
        }
        
    }
}