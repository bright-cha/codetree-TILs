import java.util.*;

public class Main {
    static int n;
    static int ans = Integer.MAX_VALUE;
    static int[] arr;

    public static void main(String[] args) {
        init();
        solve(0, 0);
        if(ans == Integer.MAX_VALUE) ans = -1;
        System.out.println(ans);
    }

    private static void solve(int cnt, int local) {
        if(local == n - 1) {
            ans = Math.min(ans, cnt);
            return;
        }

        for(int i = 1; i <= arr[local]; i++) {
            solve(cnt + 1, local + i);
        }
    }

    private static void init() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
    }
}