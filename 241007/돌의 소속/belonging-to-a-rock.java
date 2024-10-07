import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX_N = 100000;
    public static final int MAX_Q = 100000;
    public static int n, q;
    public static HashMap<Integer, Integer> hm = new HashMap<>();

    public static void main(String[] args) throws IOException {
        init();
        
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(br.readLine());
            hm.put(i, num);
        }

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int first = 0, second = 0, third = 0;
            for (int j = start; j <= end; j++) {
                int line = hm.get(j);
                
                switch (line) {
                    case 1:
                    first++;
                    break;
                    case 2:
                    second++;
                    break;
                    case 3:
                    third++;
                    break;
                }
            }

            System.out.println(first + " " + second + " " + third);
        }
    }
}