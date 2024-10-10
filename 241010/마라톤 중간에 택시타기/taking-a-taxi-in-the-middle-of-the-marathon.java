import java.io.*;
import java.util.*;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static final int MAX_N = 100000;
    public static int n;
    public static Pair[] points = new Pair[MAX_N + 1];
    public static int[] leftSum = new int[MAX_N + 1];
    public static int[] rightSum = new int[MAX_N + 1];

    public static void main(String[] args) throws IOException {
        init();
        findAns();
    }

    public static void findAns() {
        int ans = Integer.MAX_VALUE;
        for (int i = 2; i < n; i++) {
            ans = Math.min(ans, leftSum[i - 1] + rightSum[i + 1] + saveTaxiDistance(points[i - 1], points[i + 1]));
        }

        System.out.println(ans);
    }

    // 두 점의 택시거리 구하기
    public static int saveTaxiDistance(Pair a, Pair b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y + b.y);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Pair(x, y);
        }

        // i까지 포함된 왼쪽
        for (int i = 2; i <= n; i++) {
            Pair pair1 = points[i];
            Pair pair2 = points[i - 1];
            leftSum[i] = leftSum[i - 1] + saveTaxiDistance(pair1, pair2);
        }

        // i까지 포함된 오른쪽
        for (int i = n - 1; i >= 1; i--) {
            Pair pair1 = points[i];
            Pair pair2 = points[i + 1];
            rightSum[i] = rightSum[i + 1] + saveTaxiDistance(pair1, pair2);
        }
    }
}