import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Assignment4_2_8 {
    public static void writeFile(String path, String content) throws IOException {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path))) {
            bos.write(content.getBytes());
        }
    }
}
