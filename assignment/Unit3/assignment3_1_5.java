import java.util.Scanner;

public class assignment3_1_5 {
    public static int DoubleDivide(int n, int a[], int target) {
        int right = n - 1, left = 0, middle;
        while (right >= left) {
            middle = (right + left) / 2;
            if (a[middle] == target)
                return middle;
            else {
                if (target > a[middle])
                    left = middle + 1;
                if (target < a[middle])
                    right = middle - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int target = scanner.nextInt();
        int[] nums = new int[50005];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(DoubleDivide(n, nums, target));
    }

}