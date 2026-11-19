import java.util.Scanner;

public class CustomTrim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        int[] bounds = findBounds(text);
        String customTrimmed = customSubstring(text, bounds[0], bounds[1]);
        String builtInTrimmed = text.trim();
        boolean match = compareStrings(customTrimmed, builtInTrimmed);
        System.out.println("Custom: [" + customTrimmed + "]");
        System.out.println("Built-in: [" + builtInTrimmed + "]");
        System.out.println("Match: " + match);
        sc.close();
    }

    static int[] findBounds(String s) {
        int start = 0;
        int end = s.length();
        while (start < end && s.charAt(start) == ' ') {
            start++;
        }
        while (end > start && s.charAt(end - 1) == ' ') {
            end--;
        }
        return new int[]{start, end};
    }

    static String customSubstring(String s, int start, int end) {
        String res = "";
        for (int i = start; i < end; i++) {
            res += s.charAt(i);
        }
        return res;
    }

    static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
