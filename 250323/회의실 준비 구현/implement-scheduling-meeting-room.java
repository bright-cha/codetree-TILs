import java.util.*;

class Scedule implements Comparable<Scedule>{
    int s;
    int e;

    public Scedule(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo (Scedule s) {
        return this.e - s.e;
    }
}

public class Main {

    static Scedule[] list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        list = new Scedule[n];

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            list[i] = new Scedule(s, e);
        }

        Arrays.sort(list, 0, n);

        int cnt = 0;
        int cur = -1;
        for (int i = 0; i < n; i++) {
            Scedule cs = list[i];

            if (cur <= cs.s) {
                cur = cs.e;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}