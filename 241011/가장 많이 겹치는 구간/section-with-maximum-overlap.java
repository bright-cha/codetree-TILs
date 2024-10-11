import java.util.Scanner;

public class Main {    
    public static final int MAX_R = 200000;
    public static final int MAX_N = 100000;
    
    // 변수 선언
    public static int n;
    public static int[] x1 = new int[MAX_N];
    public static int[] x2 = new int[MAX_N];
    public static int[] checked = new int[MAX_R + 1];
    
    public static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
        }
        
        // 주어진 좌표의 범위가 작을 때에는
        // 배열을 이용하여 직접 각 칸에
        // +1 -1을 진행해도 무방합니다.
        for(int i = 0; i < n; i++) {
            checked[x1[i]]++;
            checked[x2[i]]--;
        }

        // 모든 곳을 조사해보며
        // 그 중 가장 많이 겹치는 횟수를 구합니다.
        // 겹치는 횟수는
        // 각 위치에 적혀있는 숫자들의 합을 누적해주면 구해집니다.
        int overlappedCnt = 0;
        for(int i = 1; i <= MAX_R; i++) {
            overlappedCnt += checked[i];
            ans = Math.max(ans, overlappedCnt);
        }
        
        System.out.print(ans);
    }
}