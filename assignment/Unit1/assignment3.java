import java.util.Scanner;

public class assignment3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();
        int fac = 2;
        boolean isFirst = true;
        System.out.print(n + " =");
        while (n != 1) {
            if (n % fac == 0) {
                if (!isFirst) {
                    System.out.print("*");
                }
                System.out.print(" " + fac + " ");
                n /= fac;
                isFirst = false;
            } else
                fac++;
        }
    }
}
