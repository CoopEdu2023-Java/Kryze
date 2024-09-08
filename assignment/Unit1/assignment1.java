import java.util.Scanner;

public class assignment1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        if (a.equals(b))
            System.out.println("same");
        else
            System.out.println("different");
        scanner.close();
    }
}
