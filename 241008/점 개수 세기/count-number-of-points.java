import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX_N = 100000;
    public static final int MAX_Q = 100000;

    public static int n, q;
    public static TreeSet<Integer> numSet = new TreeSet<>();
    public static Map<Integer, Integer> sequenceMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            numSet.add(num);
        }

        int cnt = 1;
        for (int num : numSet) {
            sequenceMap.put(num, cnt);
            cnt++;
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (numSet.first() <= start) {
                start = sequenceMap.get(numSet.ceiling(start)) - 1;
            } else {
                start = 0;
            }

            if (numSet.last() >= end) {
                end = sequenceMap.get(numSet.floor(end));
            } else {
                end = numSet.size();
            }

            if (end < start) {
                System.out.println(0);
            }

            System.out.println(end - start);
        }
    }
}