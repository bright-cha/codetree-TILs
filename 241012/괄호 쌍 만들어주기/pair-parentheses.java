import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LEN = 100000;
    public static String str = null;
    public static int strLen;
    public static int[] cnts = new int[MAX_LEN];
    public static int[] closeCnts = new int[MAX_LEN];

    public static void main(String[] args)  throws IOException {
        init();
        preprocessing();

        int cnt = 0;

        for (int i = 0; i < strLen; i++) {
            if (cnts[i] == 2) {
                cnt += closeCnts[i];
            }
        }

        System.out.println(cnt);
    }

    public static void preprocessing() {
        for (int i = 1; i < strLen; i++) {
            char prevChar = str.charAt(i - 1);
            char curChar = str.charAt(i);

            switch (curChar) {
                case '(': 
                    if (prevChar == '(') {
                        cnts[i] = 2;
                    } else {
                        cnts[i] = 1;
                    }
                    break;
                case ')':
                    if (prevChar == '(') {
                        cnts[i] = -1;
                    } else {
                        cnts[i] = -2;
                    }
                    break;
            }
        }

        if (cnts[strLen - 1] == -2) {
            closeCnts[strLen - 1] = 1;
        }

        for (int i = strLen - 2; i >= 0; i--) {
            if (cnts[i] == -2) {
                closeCnts[i] = closeCnts[i + 1] + 1;
            } else {
                closeCnts[i] = closeCnts[i + 1];
            }
        }
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        strLen = str.length();
    }
}