import java.util.*;

class Jewel implements Comparable<Jewel> {
    int w;
    int v;
    float p;

    public Jewel(int w, int v) {
        this.w = w;
        this.v = v;
        this.p = (float) v / w;
    }

    @Override
    public int compareTo(Jewel j) {
        return Float.compare(j.p, this.p);
    }
}

public class Main {

    static final int MAX_N = 100000;
    static final int MAX_M = 1000000000;
    static Jewel[] list = new Jewel[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();

            list[i] = new Jewel(w, v);
        }

        Arrays.sort(list, 0, n);

        int idx = 0;
        float ans = 0;
        while (m > 0) {
            if (m >= list[idx].w) {
                ans += list[idx].v;
                m -= list[idx].w;
            } else {
                ans += list[idx].p * m;
                break;
            }
            idx++;
        }

        System.out.printf("%.3f", ans);
        
    }
}