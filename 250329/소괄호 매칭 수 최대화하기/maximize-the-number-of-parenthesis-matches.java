import java.util.*;

class Pair implements Comparable<Pair> {
    String str;
    int cntL;
    int cntR;

    public Pair(String str, int cntL, int cntR) {
        this.str = str;
        this.cntL = cntL;
        this.cntR = cntR;
    }

    @Override
    public int compareTo(Pair p) {

        int value = this.cntR - this.cntL;

        if (value == (p.cntR - p.cntL)) return p.cntL - this.cntL;
        return value - (p.cntR - p.cntL);
    }
}

public class Main {

    public static Pair[] pairs;
    public static long score;
    public static long allR;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            String str = sc.next();

            int cntL = 0;
            int cntR = 0;

            int len = str.length();
            for (int j = 0; j < len; j++) {
                if (str.charAt(j) == '(') {
                    cntL++;
                } else {
                    cntR++;
                    allR++;
                }
            }

            pairs[i] = new Pair(str, cntL, cntR);
        }

        Arrays.sort(pairs, 0, n);

        for(int i = 0; i < n; i++) {
            Pair p = pairs[i];
            allR -= p.cntR;

            String str = p.str;
            int strLen = p.cntL + p.cntR;

            // 현재 R 체크
            for (int j = 0; j < strLen; j++) {
                if (str.charAt(j) == '(') {
                    score += p.cntR;
                    score += allR;
                } else {
                    p.cntR--;
                }
            }
        }

        System.out.println(score);
    }
}
