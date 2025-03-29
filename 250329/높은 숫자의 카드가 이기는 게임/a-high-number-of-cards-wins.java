import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] bCards = new int[n];
        for (int i = 0; i < n; i++) {
            bCards[i] = sc.nextInt();
        }

        int cur = ((1 + 2 * n) * n) / 2;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            cur-=bCards[i];

            if (cur > 0) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}