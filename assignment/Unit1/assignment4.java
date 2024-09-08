import java.util.Scanner;

import org.xml.sax.SAXException;

public class assignment4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer height = scanner.nextInt();
        for (int i = 1; i <= height / 2; i++) {
            for (int j = 1; j <= height / 2 - i + 1; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
        if (height % 2 == 1) {
            for (int j = 1; j <= height; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
        for (int i = height / 2; i >= 1; i--) {
            for (int j = 1; j <= height / 2 - i + 1; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}
