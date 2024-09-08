import java.util.ArrayList;
import java.util.Scanner;

public class assignment3_1_1 {
    public static double IteratorFunc(double a[], double n, double x) {
        double sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += a[i] * Math.pow(x, i);
        }
        return sum;
    }

    public static double AdvancedFunc(double a[], double n, double x) {
        double sum = 0, fac = 1;
        for (int i = 0; i <= n; i++) {
            sum += a[i] * fac;
            fac *= x;
        }
        return sum;
    }

    public static void main(String[] args) {
        double n, x;
        double[] a = new double[5005];
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextDouble();
        x = scanner.nextDouble();
        for (int i = 0; i <= n - 1; i++) {
            a[i] = scanner.nextDouble();
        }
        System.out.println(IteratorFunc(a, n, x));
        System.out.println(AdvancedFunc(a, n, x));
    }
}
