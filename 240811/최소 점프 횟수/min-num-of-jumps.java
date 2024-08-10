import java.util.Scanner;

public class Main {
    public static final int INT_MAX = Integer.MAX_VALUE;
    public static final int MAX_N = 10;
    
    public static int n;
    public static int[] num = new int[MAX_N];
    
    public static int ans = INT_MAX;
    
    public static void findMin(int idx, int cnt) {
        // 마지막 위치를 넘었을 때
        // 그 중 최소 이동 횟수를 갱신합니다.
        if(idx >= n - 1) {
            ans = Math.min(ans, cnt);
            return;
        }
        
        for(int dist = 1; dist <= num[idx]; dist++)
            findMin(idx + dist, cnt + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        
        for(int i = 0; i < n; i++)
            num[i] = sc.nextInt();
        
        findMin(0, 0);
        
        if(ans == INT_MAX)
            ans = -1;
        
        System.out.print(ans);
    }
}