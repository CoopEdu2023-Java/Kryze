import java.io.File;

public class assignment_4_2_3 {
    public static void findJavaFiles(String directoryPath) {
        File directory = new File(directoryPath);

        // 检查是否是目录
        if (!directory.isDirectory()) {
            System.out.println("给定的路径不是一个目录: " + directoryPath);
            return;
        }

        // 获取目录中的所有文件和子目录
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                // 如果是目录，递归调用
                if (file.isDirectory()) {
                    findJavaFiles(file.getAbsolutePath());
                } else if (file.getName().endsWith(".java")) {
                    // 打印 .java 文件的路径
                    System.out.println(file.getAbsolutePath());
                }
            }
        }
    }

    public static void main(String[] args) {
        String directoryPath = "/"; // 替换为你的目录路径
        findJavaFiles(directoryPath);
    }
}