import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Assignment4_2_7 {
    public static void readFile(String path) throws IOException {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
             Scanner scanner = new Scanner(bis)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
    }
}
