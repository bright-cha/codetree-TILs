import java.io.*;
import java.util.*;

class Point implements Comparable<Point> {
    int s;
    int e;

    public Point(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo (Point p) {
        return this.s - p.s;
    }
}

public class Main {
    public static final int MAX_N = 100000;
    public static final int MAX_VALUE = 200000;

    public static int n;
    public static ArrayList<Point> points = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        init();

        int cnt = 0;
        int ans = 0;

        for (int i = 0; i < 2 * n; i++) {
            int x = points.get(i).s;
            int v = points.get(i).e;

            cnt += v;
            ans = Math.max(ans, cnt);
        }

        System.out.println(ans);
        
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            points.add(new Point(s, 1));
            points.add(new Point(e, -1));
        }

        Collections.sort(points);
    }
}