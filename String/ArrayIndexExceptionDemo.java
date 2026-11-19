import java.util.Scanner;

public class ArrayIndexExceptionDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = scanner.next();
        }
        
        try {
            generateException(names);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Program stopped abruptly in main simulation.");
        }
        
        handleException(names);
        scanner.close();
    }
    
    public static void generateException(String[] array) {
        String name = array[array.length + 5];
    }
    
    public static void handleException(String[] array) {
        try {
            String name = array[array.length + 5];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException.");
        } catch (RuntimeException e) {
            System.out.println("Caught generic RuntimeException.");
        }
    }
}
