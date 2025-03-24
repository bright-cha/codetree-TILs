import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for(int i = 0; i < n; i++)
            prices[i] = sc.nextInt();

        int ans = 0;


        int maxNum = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (maxNum < prices[i]) {
                maxNum = prices[i];
                continue;
            }

            ans = Math.max(ans, maxNum - prices[i]);
        }

        System.out.println(ans);
    }
}