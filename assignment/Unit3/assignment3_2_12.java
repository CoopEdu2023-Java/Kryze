public class assignment3_2_12 {
    public static boolean isMinHeap(int[] array) {
        int n = array.length;
        for (int i = 1; i <= n / 2; i++) {
            int leftChild = 2 * i;
            int rightChild = 2 * i + 1;

            if (leftChild < n && array[i] > array[leftChild]) {
                return false;
            }

            if (rightChild < n && array[i] > array[rightChild]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] heapArray = { 0, 1, 3, 5, 7, 9, 6, 8 };
        System.out.println(isMinHeap(heapArray));
    }
}
