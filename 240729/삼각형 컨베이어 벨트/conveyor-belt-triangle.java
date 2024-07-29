import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();
        Deque<Integer> que = new ArrayDeque<>();

        for(int i = 0; i < n * 3; i++) {
            que.add(sc.nextInt());
        }

        while(t-- > 0) {
            int num = que.pollLast();
            que.offerFirst(num);
        }

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(que.poll() + " ");
            }
            System.out.println();
        }
    }
}