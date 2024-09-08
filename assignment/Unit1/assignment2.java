import java.util.Scanner;

public class assignment2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer a = scanner.nextInt();
        int i;
        for (i = 2; i * i < a; ++i) {
            if (a % i == 0 && a != 2) {
                System.out.print("not prime");
                return;
            }
        }
        System.out.print("prime");
    }
}
