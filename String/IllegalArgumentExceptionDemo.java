import java.util.Scanner;

public class IllegalArgumentExceptionDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        
        try {
            generateException(input);
        } catch (RuntimeException e) {
            System.out.println("Program stopped abruptly in main simulation.");
        }
        
        handleException(input);
        scanner.close();
    }
    
    public static void generateException(String str) {
        str.substring(5, 2);
    }
    
    public static void handleException(String str) {
        try {
            str.substring(5, 2);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException.");
        } catch (RuntimeException e) {
            System.out.println("Caught generic RuntimeException.");
        }
    }
}
