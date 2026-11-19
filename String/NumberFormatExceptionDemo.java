import java.util.Scanner;

public class NumberFormatExceptionDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        
        try {
            generateException(input);
        } catch (NumberFormatException e) {
            System.out.println("Program stopped abruptly in main simulation.");
        }
        
        handleException(input);
        scanner.close();
    }
    
    public static void generateException(String text) {
        Integer.parseInt(text);
    }
    
    public static void handleException(String text) {
        try {
            Integer.parseInt(text);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException.");
        } catch (RuntimeException e) {
            System.out.println("Caught generic RuntimeException.");
        }
    }
}
