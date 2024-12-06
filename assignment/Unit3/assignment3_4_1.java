import java.util.Arrays;
import java.util.Random;

public class assignment3_4_1 {
    public static void main(String[] args) {
        int size = 100000;
        int[] array = new Random().ints(size, 0, 100000).toArray();
        int[] array1 = array.clone();
        int[] array2 = array.clone();

        long start = System.currentTimeMillis();
        bubbleSort(array1);
        long end = System.currentTimeMillis();
        System.out.println("Bubble Sort time: " + (end - start) + " ms");

        start = System.currentTimeMillis();
        Arrays.sort(array2);
        end = System.currentTimeMillis();
        System.out.println("Built-in Sort time: " + (end - start) + " ms");
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
