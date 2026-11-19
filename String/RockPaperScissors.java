import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalGames = sc.nextInt();
        String[][] gameHistory = new String[totalGames][3];
        int userWins = 0, compWins = 0;

        for (int i = 0; i < totalGames; i++) {
            String userChoice = sc.next();
            String compChoice = getComputerChoice();
            String winner = findWinner(userChoice, compChoice);
            gameHistory[i][0] = userChoice;
            gameHistory[i][1] = compChoice;
            gameHistory[i][2] = winner;
            if (winner.equals("User")) userWins++;
            if (winner.equals("Computer")) compWins++;
        }

        String[][] stats = calculateStats(userWins, compWins, totalGames);
        displayResults(gameHistory, stats);
        sc.close();
    }

    static String getComputerChoice() {
        int r = (int) (Math.random() * 3);
        if (r == 0) return "rock";
        if (r == 1) return "paper";
        return "scissors";
    }

    static String findWinner(String u, String c) {
        if (u.equals(c)) return "Tie";
        if ((u.equals("rock") && c.equals("scissors")) ||
            (u.equals("paper") && c.equals("rock")) ||
            (u.equals("scissors") && c.equals("paper"))) {
            return "User";
        }
        return "Computer";
    }

    static String[][] calculateStats(int uWin, int cWin, int total) {
        String[][] stats = new String[2][2];
        stats[0][0] = String.valueOf((double) uWin / total);
        stats[0][1] = String.valueOf(((double) uWin / total) * 100);
        stats[1][0] = String.valueOf((double) cWin / total);
        stats[1][1] = String.valueOf(((double) cWin / total) * 100);
        return stats;
    }

    static void displayResults(String[][] history, String[][] stats) {
        System.out.println("Game\tUser\tComp\tWinner");
        for (int i = 0; i < history.length; i++) {
            System.out.println((i + 1) + "\t" + history[i][0] + "\t" + history[i][1] + "\t" + history[i][2]);
        }
        System.out.println("\nPlayer\tAvg\tPercentage");
        System.out.println("User\t" + stats[0][0] + "\t" + stats[0][1] + "%");
        System.out.println("Comp\t" + stats[1][0] + "\t" + stats[1][1] + "%");
    }
}
