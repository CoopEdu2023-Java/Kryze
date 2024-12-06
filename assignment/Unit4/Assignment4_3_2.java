public class Assignment4_3_2 {
    public static void main(String[] args) {
        for (int numThreads = 1; numThreads <= 8; numThreads++) {
            int currentThreads = numThreads; // Create a final or effectively final variable
            long start = System.currentTimeMillis();

            Thread[] threads = new Thread[currentThreads];
            for (int i = 0; i < currentThreads; i++) {
                threads[i] = new Thread(() -> {
                    for (int j = 0; j < 1_000_000 / currentThreads; j++) {
                        Math.sqrt(j);
                    }
                });
                threads[i].start();
            }

            for (Thread thread : threads) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            long end = System.currentTimeMillis();
            System.out.println("Threads: " + currentThreads + ", Time: " + (end - start) + " ms");
        }
    }
}
