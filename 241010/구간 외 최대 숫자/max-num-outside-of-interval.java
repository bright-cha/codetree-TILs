import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX_N = 100000;
    public static final int MAX_Q = 100000;
    public static final int MAX_VALUE = (int) 1e9;

    public static int n, q;
    public static int[] nums = new int[MAX_N + 1];
    public static int[] left = new int[MAX_N + 1];
    public static int[] right = new int[MAX_N + 1];

    public static void main(String[] args) throws IOException {
        init();
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            left[i] = Math.max(left[i - 1], nums[i]);
        }

        right[n] = nums[n];
        for (int i = n - 1; i >= 1; i--) {
            right[i] = Math.max(right[i + 1], nums[i]);
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            find(start, end);
        }
    }

    public static void find(int start, int end) {
        System.out.println(Math.max(left[start - 1], right[end + 1]));
    }
}

// 2 ~ 10만 사이 값을 제외한 최댓값 구하기 * 10만번
// 10억개의 수 중

// 배열에 수를 저장한다 = 몇 번째 입력받은 수인지 기록
// 최댓값 = treeset으로 구한다.
// 전체 set 중 구간 수를 제외한 수 중 최댓값
// 처음부터 2번째 까지의 수 중 최대값
// 마지막부터 10만 까지의 수 중 최대값

// 배열 -> 두 개의 set 
// 하나의 입력이 주어질 때 10만 정수 배열
// 두개의 set 만들기