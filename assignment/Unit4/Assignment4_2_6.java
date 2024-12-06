import java.io.FileOutputStream;
import java.io.IOException;

public class Assignment4_2_6 {
    public static void writeFile(String path, String content) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(content.getBytes());
        }
    }
}
