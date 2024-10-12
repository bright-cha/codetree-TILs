import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX_N = 50000;
    
    public static int n;
    public static int[] nums = new int[MAX_N + 1];
    public static int[] modIndex = new int[7];  // 나머지값 0~6에 대한 첫 등장 인덱스 저장

    public static void main(String[] args) throws IOException {
        init();

        Arrays.fill(modIndex, -1);  // 나머지가 처음 등장한 위치를 저장하기 위해 -1로 초기화
        modIndex[0] = 0;  // 합이 0인 경우는 인덱스 0에서 처리

        int ans = 0;
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum = (sum + nums[i]) % 7;  // 현재까지의 누적 합을 7로 나눈 나머지

            if (modIndex[sum] != -1) {
                // 같은 나머지가 나온 첫 번째 위치와 현재 위치 간의 거리를 계산
                ans = Math.max(ans, i - modIndex[sum]);
            } else {
                // 나머지가 처음 나왔다면 해당 위치를 저장
                modIndex[sum] = i;
            }
        }

        System.out.println(ans);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }
    }
}