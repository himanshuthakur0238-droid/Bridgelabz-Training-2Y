import java.util.Scanner;

public class WordLengthMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        
        String[] words = customSplit(text);
        String[][] matrix = createWordLengthMatrix(words);
        
        System.out.println("Word\t\tLength");
        for (int i = 0; i < matrix.length; i++) {
            int lenVal = Integer.parseInt(matrix[i][1]);
            System.out.println(matrix[i][0] + "\t\t" + lenVal);
        }
        
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
    
    public static String[] customSplit(String str) {
        int len = getLength(str);
        if (len == 0) {
            return new String[0];
        }
        
        int spaceCount = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                spaceCount++;
            }
        }
        
        int[] spaceIndexes = new int[spaceCount + 2];
        spaceIndexes[0] = -1;
        int idx = 1;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == ' ') {
                spaceIndexes[idx] = i;
                idx++;
            }
        }
        spaceIndexes[idx] = len;
        
        String[] words = new String[spaceCount + 1];
        for (int i = 0; i < words.length; i++) {
            String word = "";
            for (int j = spaceIndexes[i] + 1; j < spaceIndexes[i + 1]; j++) {
                word += str.charAt(j);
            }
            words[i] = word;
        }
        return words;
    }
    
    public static String[][] createWordLengthMatrix(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            int len = getLength(words[i]);
            result[i][1] = String.valueOf(len);
        }
        return result;
    }
}
