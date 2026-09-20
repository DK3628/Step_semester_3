import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) return "Draw";
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        String[] playerDemoMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        Random rand = new Random();
        
        int wins = 0, losses = 0, draws = 0;
        int n = 5;
        
        System.out.println("Round | Player Move | Computer Move | Result");
        System.out.println("----------------------------------------------");
        for (int i = 0; i < n; i++) {
            String pMove = playerDemoMoves[i];
            String cMove = moves[rand.nextInt(3)];
            String result = playRound(pMove, cMove);
            
            System.out.printf("Round %d - Player: %s, Computer: %s -> %s\n", (i+1), pMove, cMove, result);
            
            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;
        }
        
        double winPercent = (wins * 100.0) / n;
        System.out.printf("\nFinal Summary (after %d rounds)\n", n);
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n", wins, losses, draws, winPercent);
    }
}