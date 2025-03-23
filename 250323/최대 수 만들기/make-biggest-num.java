import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                String strA = String.valueOf(a);
                String strB = String.valueOf(b);

                if (Long.valueOf(strA + strB) > Long.valueOf(strB + strA)) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
        }

    }
}