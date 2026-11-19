public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            generateException();
        } catch (NullPointerException e) {
            System.out.println("Caught unhandled method via main try block.");
        }
        
        handleException();
    }
    
    public static void generateException() {
        String text = null;
        text.length();
    }
    
    public static void handleException() {
        String text = null;
        try {
            text.length();
        } catch (NullPointerException e) {
            System.out.println("Successfully handled NullPointerException.");
        }
    }
}
