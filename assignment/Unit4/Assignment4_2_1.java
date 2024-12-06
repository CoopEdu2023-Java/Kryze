import java.io.File;

public class Assignment4_2_1 {
    public static String[] listDirectoryContents(String path) {
        File directory = new File(path);
        return directory.list();
    }
}
