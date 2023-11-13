import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] a = sc.next().split("-");
        System.out.print(a[0] + "-" + a[2] + "-" + a[1]);
    }
}