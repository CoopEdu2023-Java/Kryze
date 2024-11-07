import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class assignment_4_3_3 {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> a = new ArrayList<Integer>(Arrays.asList(3, 5, 2, 4, 1, 6));
        List<Integer> b = new ArrayList<Integer>(5);
        List<Thread> threads = new ArrayList<Thread>();
        for (int i : a) {
            Thread thread = new Thread(() -> {
                try {
                    Thread.sleep(i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                b.add(i);
            });
            threads.add(thread);
        }
        for (Thread athread : threads) {
            athread.start();
        }
        for (Thread athread : threads) {
            athread.join();
        }
        for (int i : b) {
            System.out.println(i);
        }
    }
}
