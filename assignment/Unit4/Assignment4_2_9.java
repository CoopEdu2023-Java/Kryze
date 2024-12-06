import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Assignment4_2_9 {
    public static void testBufferSizes(String path) throws IOException {
        int[] bufferSizes = {8192, 10240, 8388608};
        for (int size : bufferSizes) {
            try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path), size)) {
                long start = System.currentTimeMillis();
                while (bis.read() != -1) {}
                long end = System.currentTimeMillis();
                System.out.println("Buffer size " + size + ": " + (end - start) + " ms");
            }
        }
    }
}
