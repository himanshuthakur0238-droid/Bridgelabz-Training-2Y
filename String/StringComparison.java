x	import java.util.Scanner;

public class StringComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        
        boolean customResult = compareStrings(str1, str2);
        boolean builtInResult = str1.equals(str2);
        
        System.out.println("Custom Match: " + customResult);
        System.out.println("Built-in Match: " + builtInResult);
        System.out.println("Results Match: " + (customResult == builtInResult));
        
        scanner.close();
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
