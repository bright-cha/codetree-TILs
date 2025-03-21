import java.util.*;
public class Main {

    static final int MAX_N = 100000;
    static Queue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();

            pq.offer(temp);
        }

        int ans = 0;
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            pq.offer(a + b);

            ans += a + b;
        }

        System.out.println(ans);

        
    }
}