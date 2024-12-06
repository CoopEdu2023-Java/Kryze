import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Assignment4_2_3 {
    public static List<String> findJavaFiles(String path) {
        List<String> javaFiles = new ArrayList<>();
        File directory = new File(path);
        findFiles(directory, javaFiles);
        return javaFiles;
    }

    private static void findFiles(File file, List<String> javaFiles) {
        if (file.isDirectory()) {
            for (File subFile : file.listFiles()) {
                findFiles(subFile, javaFiles);
            }
        } else if (file.getName().endsWith(".java")) {
            javaFiles.add(file.getAbsolutePath());
        }
    }
}
