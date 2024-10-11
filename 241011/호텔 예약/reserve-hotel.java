import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {
    int day;
    int value;

    public Point(int day, int value) {
        this.day = day;
        this.value = value;
    }

    @Override
    public int compareTo(Point p) {
        if (this.day != p.day) {
            return this.day - p.day;
        }
        return p.value - this.value;
    }
}

public class Main {
    public static final int MAX_N = 100000;
    public static final int MAX_VALUE = 1000000000;

    public static int n;
    public static ArrayList<Point> points = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        init();

        int room = 0;
        int ans = 0;

        for (int i = 0; i < n * 2; i++) {
            int value = points.get(i).value;
            room += value;

            ans = Math.max(ans, room);
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

            points.add(new Point(start, 1));
            points.add(new Point(end, -1));
        }

        Collections.sort(points);
    }
}

// 10만 명
// 입실일 배열
// 퇴실일 배열
// 입실 + 1,
// 퇴실 - 1
// 배열 입력 후 정렬