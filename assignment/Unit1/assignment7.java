import java.util.Scanner;

public class assignment7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        StringBuilder rev = new StringBuilder(n);
        rev.reverse();
        String revString = rev.toString();
        System.out.print((revString.equals(n)) ? "yes" : "No");

    }
}
