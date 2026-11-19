import java.util.Scanner;

public class RandomVotingCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] ages = generateAges(count);
        String[][] statusTable = checkVoting(ages);
        displayTable(statusTable);
        sc.close();
    }

    static int[] generateAges(int n) {
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            ages[i] = (int) (Math.random() * 90) + 10;
        }
        return ages;
    }

    static String[][] checkVoting(int[] ages) {
        String[][] table = new String[ages.length][2];
        for (int i = 0; i < ages.length; i++) {
            table[i][0] = String.valueOf(ages[i]);
            if (ages[i] < 0) {
                table[i][1] = "false";
            } else if (ages[i] >= 18) {
                table[i][1] = "true";
            } else {
                table[i][1] = "false";
            }
        }
        return table;
    }

    static void displayTable(String[][] table) {
        System.out.println("Age\tCan Vote");
        for (int i = 0; i < table.length; i++) {
            System.out.println(table[i][0] + "\t" + table[i][1]);
        }
    }
}
