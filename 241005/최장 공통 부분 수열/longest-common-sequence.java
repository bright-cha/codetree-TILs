import java.io.*;
import java.util.*;

public class Main {
    public static final int MAX_A_LEN = 1000;
    public static final int MAX_B_LEN = 1000;

    public static String a = null;
    public static String b = null;
    public static int lenA, lenB;
    public static int[][] dp = new int[MAX_A_LEN + 1][MAX_B_LEN + 1];

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 1; i <= lenA; i++) {
            for (int j = 1; j <= lenB; j++) {
                
            }
        }

    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        a = br.readLine();
        b = br.readLine();
        lenA = a.length;
        lenB = b.length;
    }
}