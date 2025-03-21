import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int ans = -1000;
        for (int i = 0; i < n; i++) {
            int temp = 0;

            for (int j = i; j < n; j++) {
                temp += a[j];
                if (temp < -1000) break;
                ans = Math.max(ans, temp);
            }
        }

        System.out.println(ans);
    }
}