import java.util.Scanner;

public class ShortestLongestWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String[] words = customSplit(text);
        String[][] matrix = createMatrix(words);
        int[] indices = findMinMax(matrix);
        System.out.println("Shortest: " + matrix[indices[0]][0]);
        System.out.println("Longest: " + matrix[indices[1]][0]);
        sc.close();
    }

    static int getLen(String s) {
        int c = 0;
        try {
            while (true) { s.charAt(c); c++; }
        } catch (Exception e) { return c; }
    }

    static String[] customSplit(String s) {
        int len = getLen(s);
        if (len == 0) return new String[0];
        int spaces = 0;
        for (int i = 0; i < len; i++) if (s.charAt(i) == ' ') spaces++;
        String[] res = new String[spaces + 1];
        int idx = 0; String w = "";
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') { res[idx++] = w; w = ""; }
            else w += s.charAt(i);
        }
        res[idx] = w;
        return res;
    }

    static String[][] createMatrix(String[] w) {
        String[][] m = new String[w.length][2];
        for (int i = 0; i < w.length; i++) {
            m[i][0] = w[i];
            m[i][1] = String.valueOf(getLen(w[i]));
        }
        return m;
    }

    static int[] findMinMax(String[][] m) {
        int minIdx = 0, maxIdx = 0;
        int min = Integer.parseInt(m[0][1]);
        int max = min;
        for (int i = 1; i < m.length; i++) {
            int len = Integer.parseInt(m[i][1]);
            if (len < min) { min = len; minIdx = i; }
            if (len > max) { max = len; maxIdx = i; }
        }
        return new int[]{minIdx, maxIdx};
    }
}
