import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX = 10;

    public static int n, m, k;
    public static String[][] grid = new String[MAX][MAX];

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < n; i++) {
            for (int z = 0; z < k; z++) {
                for (int j = 0; j < m; j++) {
                    for (int l = 0; l < k; l++) {
                        System.out.print(grid[i][j]);
                    }
                }
                System.out.println();
            }
        }
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            String line = br.readLine();

            for (int j = 0; j < m; j++) {
                grid[i][j] = String.valueOf(line.charAt(j));
            }
        }
    }
}