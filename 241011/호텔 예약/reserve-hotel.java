import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX_N = 100000;

    public static int n;
    public static int[] starts = new int[MAX_N];
    public static int[] ends = new int[MAX_N];

    public static void main(String[] args) throws IOException {
        init();

        int day = 1;
        int room = 0;
        int ans = 0;
        int startIdx = 0;
        int endIdx = 0;

        while (day <= ends[n - 1]) {
            // 입실일이 day인 사람들을 카운트
            while (startIdx < n && starts[startIdx] == day) {
                room++;
                startIdx++;
            }

            // 최대 방 개수 갱신
            ans = Math.max(ans, room);

            // 퇴실일이 day인 사람들을 카운트
            while (endIdx < n && ends[endIdx] == day) {
                room--;
                endIdx++;
            }

            // 다음 날로 넘어감
            day++;
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

        // 입실일과 퇴실일을 정렬
        Arrays.sort(starts, 0, n);
        Arrays.sort(ends, 0, n);
    }
}