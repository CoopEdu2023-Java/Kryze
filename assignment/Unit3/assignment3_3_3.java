import java.util.HashMap;
import java.util.Map;

public class assignment3_3_3 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> countMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            countMap.put(c, countMap.getOrDefault(c, 0) - 1);
        }

        for (int count : countMap.values()) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        assignment3_3_3 solution = new assignment3_3_3();

        String s1 = "你好";
        String t1 = "好你";
        System.out.println("Unicode 测试1: " + solution.isAnagram(s1, t1)); // 输出: true

        String s2 = "hello";
        String t2 = "世界";
        System.out.println("Unicode 测试2: " + solution.isAnagram(s2, t2)); // 输出: false
    }
}
