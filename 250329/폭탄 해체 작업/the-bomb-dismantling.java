import java.util.*;
import java.io.*;


class Bomb implements Comparable<Bomb> {
    int score;
    int limit;

    public Bomb(int s, int l) {
        this.score = s;
        this.limit = l;
    }

    @Override
    public int compareTo(Bomb b) {

        if (this.limit == b.limit) {
            return b.score - this.score;
        }

        return this.limit - b.limit;
    }
}

public class Main {

    public static final int MAX_N = 10000;
    public static final int MAX_SCORE = 1000;
    public static final int MAX_TIME = 10000;

    public static int n, maxTime, maxScore;
    public static Bomb[] bombs = new Bomb[MAX_N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int score = Integer.parseInt(st.nextToken());
            int limit = Integer.parseInt(st.nextToken());

            maxTime = Math.max(maxTime, limit);

            bombs[i] = new Bomb(score, limit);
        }

        Arrays.sort(bombs, 0, n);

        int time = 1;
        for (int i = 0; i < n; i++) {
            Bomb cur = bombs[i];
            if (cur.limit < time) continue;

            maxScore += cur.score;

            time++;
        }













        System.out.println(maxScore);
    }
}