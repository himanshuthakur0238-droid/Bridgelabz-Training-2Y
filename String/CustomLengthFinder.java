import java.util.Scanner;

public class CustomLengthFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();
        
        int customLen = getLength(text);
        int builtInLen = text.length();
        
        System.out.println("Custom Length: " + customLen);
        System.out.println("Built-in Length: " + builtInLen);
        
        scanner.close();
    }
    
    public static int getLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }
}
