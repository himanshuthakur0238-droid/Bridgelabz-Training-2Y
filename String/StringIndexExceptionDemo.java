import java.util.Scanner;

public class StringIndexExceptionDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.util.in != null ? System.in : null);
        String input = scanner.next();
        
        try {
            generateException(input);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Program stopped abruptly in main simulation.");
        }
        
        handleException(input);
        scanner.close();
    }
    
    public static void generateException(String str) {
        str.charAt(str.length() + 10);
    }
    
    public static void handleException(String str) {
        try {
            str.charAt(str.length() + 10);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException successfully.");
        }
    }
}
