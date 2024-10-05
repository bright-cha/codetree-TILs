import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static TreeMap<String, Integer> tm = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        init();

        for (Map.Entry<String, Integer> entry : tm.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            if (tm.containsKey(str)) {
                tm.put(str, tm.get(str) + 1);
            } else {
                tm.put(str, 1);
            }
        }
    }
}