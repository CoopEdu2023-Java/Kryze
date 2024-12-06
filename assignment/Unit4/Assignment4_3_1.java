public class Assignment4_3_1 {
    public static void main(String[] args) {
        Thread evenThread = new Thread(() -> {
            for (int i = 0; i <= 10; i += 2) {
                System.out.println("Even: " + i);
            }
        });

        Thread oddThread = new Thread(() -> {
            for (int i = 1; i <= 10; i += 2) {
                System.out.println("Odd: " + i);
            }
        });

        evenThread.start();
        oddThread.start();
    }
}
