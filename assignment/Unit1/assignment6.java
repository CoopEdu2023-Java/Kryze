import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class assignment6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the amount of numbers:");
        Integer n = scanner.nextInt();
        Integer[] num = new Integer[n];
        for (int i = 0; i < n; ++i)
            num[i] = scanner.nextInt();
        Set<Integer> setList = new HashSet<>(Arrays.asList(num));
        System.out.print(setList.toArray()[setList.size() - 3]);
    }
}
