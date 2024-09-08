import java.util.Scanner;

import org.xml.sax.SAXException;

public class assignment5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer height = 9;
        int i, j;
        for (i = 1; i <= height; i++) {
            for (j = 1; j <= i; j++) {
                System.out.print(i + " * " + j + " = " + (i * j) + " ");
            }
            System.out.print("\n");
        }
    }
}
