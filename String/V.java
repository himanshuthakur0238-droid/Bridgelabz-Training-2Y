import java.util.Scanner;

public class UppercaseConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        
        String customUpper = convertToUppercase(text);
        String builtInUpper = text.toUpperCase();
        
        boolean match = compareStrings(customUpper, builtInUpper);
        System.out.println("Custom: " + customUpper);
        System.out.println("Built-in: " + builtInUpper);
        System.out.println("Match: " + match);
        
        scanner.close();
    }
    
    public static String convertToUppercase(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                result += (char) (ch - 32);
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
