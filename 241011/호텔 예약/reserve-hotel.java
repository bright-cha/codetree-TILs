import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX_N = 100000;
    public static final int MAX_VALUE = 1000000000;

    public static int n;
    public static int[] starts = new int[MAX_N];
    public static int[] ends = new int[MAX_N];

    public static void main(String[] args) throws IOException {
        init();

        int day = 0;
        int room = 0;
        int ans = 0;
        int start = 0;
        int end = 0;

        // for (int i = 0; i < n; i++) {
        //     System.out.print(starts[i] + " ");
        // }

        while(day <= starts[n - 1] && day <= ends[n - 1]) {
            day++;

            while (starts[start] == day) {
                room++;
                start++;
            }

            ans = Math.max(ans, room);

            while (ends[end] == day) {
                room--;
                end++;
            }
        }

        System.out.println(ans);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            starts[i] = start;
            ends[i] = end;
        }

        Arrays.sort(starts, 0, n);
        Arrays.sort(ends, 0, n);
    }
}

// 10만 명
// 입실일 배열
// 퇴실일 배열
// 입실 + 1,
// 퇴실 - 1
// 배열 입력 후 정렬