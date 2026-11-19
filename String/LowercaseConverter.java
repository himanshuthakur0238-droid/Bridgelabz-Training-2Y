import java.util.Scanner;

public class LowercaseConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        
        String customLower = convertToLowercase(text);
        String builtInLower = text.toLowerCase();
        
        boolean match = compareStrings(customLower, builtInLower);
        System.out.println("Custom: " + customLower);
        System.out.println("Built-in: " + builtInLower);
        System.out.println("Match: " + match);
        
        scanner.close();
    }
    
    public static String convertToLowercase(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                result += (char) (ch + 32);
            } else {
                result += ch;
            }
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
