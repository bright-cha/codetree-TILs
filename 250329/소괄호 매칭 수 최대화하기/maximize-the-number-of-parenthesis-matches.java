import java.util.*;

class Pair implements Comparable<Pair> {
    String s;
    int len;
    int cntR;

    public Pair(String s, int len, int cntR) {
        this.s = s;
        this.len = len;
        this.cntR = cntR;
    }

    @Override
    public int compareTo(Pair p) {
        if (this.len == p.len) return this.cntR - p.cntR;
        return this.len - p.len;
    }
}

public class Main {


    public static Pair[] pairs;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            String str = sc.next();

            int num = 0;
            int cntR = 0;
            int len = str.length();
            for (int j = 0; j < len; j++) {
                if (str.charAt(j) == '(') {
                    num--;
                } else {
                    num++;
                    cntR++;
                }
            }

            pairs[i] = new Pair(str, num, cntR);
        }

        Arrays.sort(pairs, 0, n);

        int score = 0;
        for(int i = 0; i < n; i++) {
            Pair p = pairs[i];

            for (int j = 0; j < p.s.length(); j++) {
                if (p.s.charAt(j) == '(') {
                    for (int k = j + 1; k < p.s.length(); k++) {
                        if (p.s.charAt(k) == ')') {
                            score++;
                        }
                    }

                    for (int k = i + 1; k < n; k++) {
                        score += pairs[k].cntR;
                    }
                }
            }
        }

        System.out.println(score);

    }
}




