import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX_N = 100000;
    public static final int MAX_VALUE = 1000000000;

    public static int n;
    public static HashMap<Integer, Integer> starts = new HashMap<>();
    public static HashMap<Integer, Integer> ends = new HashMap<>();

    public static void main(String[] args) throws IOException {
        init();

        int room = 0;
        int ans = 0;
        for (int i = 1; i <= MAX_VALUE; i++) {
            if (starts.containsKey(i)) {
                room += starts.get(i);
            }

            ans = Math.max(ans, room);

            if (ends.containsKey(i)) {
                room -= ends.get(i);
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

            int cnt = 0;
            if (starts.containsKey(start)) {
                cnt = starts.get(start);
            }
            starts.put(start, cnt + 1);

            cnt = 0;
            if (ends.containsKey(end)) {
                cnt = ends.get(end);
            }
            ends.put(end, cnt + 1);
        }
    }
}

// 10만 명
// 입실일 배열
// 퇴실일 배열
// 입실 + 1,
// 퇴실 - 1