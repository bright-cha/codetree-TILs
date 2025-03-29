import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] bCards = new int[2 * n + 1];
        for (int i = 0; i < n; i++) {
            bCards[sc.nextInt()] = 1;
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (bCards[i] == 0) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}