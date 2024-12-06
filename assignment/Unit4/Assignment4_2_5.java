import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Assignment4_2_5 {
    public static void readFile(String path) throws IOException {
        try (FileInputStream fis = new FileInputStream(path);
             Scanner scanner = new Scanner(fis)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
    }
}
