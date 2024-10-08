import java.util.Scanner;

public class Main {
    public static final int MAX_N = 100000;
    public static final int MAX_C = 3;
    
    // 변수 선언
    public static int n, q;
    public static int[] arr = new int[MAX_N + 1];
    public static int[][] prefixSum = new int[MAX_C + 1][MAX_N + 1];
    
    // 번호가 c인 돌 중 [s, e] 구간 내의 원소의 합을 반환합니다.
    public static int getSum(int c, int s, int e) {
        return prefixSum[c][e] - prefixSum[c][s - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 입력:
        n = sc.nextInt();
        q = sc.nextInt();
        for(int i = 1; i <= n; i++)
            arr[i] = sc.nextInt();

        // 누적합 배열을 만들어줍니다.
        // prefixSum[i][j] : 번호가 i인 돌에 대한 누적합을 저장합니다.
        for(int i = 1; i <= 3; i++) {
            prefixSum[i][0] = 0;
            for(int j = 1; j <= n; j++) {
                // arr[j]가 i라면, 개수가 하나 더 증가합니다.
                if(arr[j] == i)
                    prefixSum[i][j] = prefixSum[i][j - 1] + 1;
                else
                    prefixSum[i][j] = prefixSum[i][j - 1];
            }
        }
        
        // q개의 질의에 대해
        // 각 돌의 개수를 출력합니다.
        while(q-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            System.out.print(getSum(1, a, b) + " ");
            System.out.print(getSum(2, a, b) + " ");
            System.out.println(getSum(3, a, b));
        }
    }
}