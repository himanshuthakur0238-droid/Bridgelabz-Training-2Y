import java.util.Scanner;

public class VowelConsonantTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[][] matrix = createMatrix(text);
        displayMatrix(matrix);
        sc.close();
    }

    static String checkChar(char c) {
        if (c >= 'A' && c <= 'Z') c = (char) (c + 32);
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return "Vowel";
        if (c >= 'a' && c <= 'z') return "Consonant";
        return "Not a Letter";
    }

    static String[][] createMatrix(String s) {
        String[][] m = new String[s.length()][2];
        for (int i = 0; i < s.length(); i++) {
            m[i][0] = String.valueOf(s.charAt(i));
            m[i][1] = checkChar(s.charAt(i));
        }
        return m;
    }

    static void displayMatrix(String[][] m) {
        System.out.println("Char\tType");
        for (int i = 0; i < m.length; i++) {
            System.out.println(m[i][0] + "\t" + m[i][1]);
        }
    }
}
