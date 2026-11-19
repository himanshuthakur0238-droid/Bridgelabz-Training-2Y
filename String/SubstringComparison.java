import java.util.Scanner;

public class SubstringComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        
        String customSub = customSubstring(text, start, end);
        String builtInSub = text.substring(start, end);
        
        boolean match = compareStrings(customSub, builtInSub);
        System.out.println("Custom: " + customSub);
        System.out.println("Built-in: " + builtInSub);
        System.out.println("Match: " + match);
        
        scanner.close();
    }
    
    public static String customSubstring(String str, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += str.charAt(i);
        }
        return result;
    }
    
    public static boolean compareStrings(String s1, String s2) {
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
