import java.util.Scanner;

public class assignment8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String additon = scanner.nextLine();
        System.out.print("Enter the amount of the elements in the array:");
        int num = scanner.nextInt();
        scanner.nextLine();
        String[] base = new String[num];
        for (int i = 0; i < num; ++i)
            base[i] = scanner.nextLine();
        String ans = "";
        for (int i = 0; i < num - 1; i++) {
            ans = ans + base[i] + additon;
        }
        System.out.println(ans + base[num - 1]);
    }
}
