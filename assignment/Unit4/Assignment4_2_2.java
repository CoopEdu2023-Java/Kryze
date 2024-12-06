import java.io.File;

public class Assignment4_2_2 {
    public static boolean fileExists(String path) {
        File file = new File(path);
        return file.exists();
    }
}
