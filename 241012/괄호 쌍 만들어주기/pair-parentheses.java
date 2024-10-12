import java.util.*;
import java.io.*;

public class Main {
    public static final int MAX_LEN = 100000;
    public static String str = null;
    public static int strLen;
    public static int[] cnts = new int[MAX_LEN];

    public static void main(String[] args)  throws IOException {
        init();
        preprocessing();

        int openCnt = 0;
        int closeCnt = 0;

        for (int i = 0; i < strLen; i++) {
            if (cnts[i] == 2) {
                openCnt++;
            } else if (cnts[i] == -2) {
                closeCnt++;
            }
        }

        System.out.println(openCnt * closeCnt);
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
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        strLen = str.length();
    }
}