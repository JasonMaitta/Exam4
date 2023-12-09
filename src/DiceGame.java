import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

public class DiceGame {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the number of sides for the die being used: ");
            int numSides = scanner.nextInt();

            System.out.print("Enter the number of players: ");
            int numPlayers = scanner.nextInt();

            List<Player> players = new ArrayList<>();

            for (int i = 1; i <= numPlayers; i++) {
                System.out.print("Enter the name for player " + i + ": ");
                String playerName = scanner.next();
                Die playerDie = new Die(numSides);
                players.add(new Player(playerName, playerDie));
            }

            for (Player player : players) {
                player.getDie().roll();
                System.out.println(player.getName() + " rolled a " + player.getDie().getValue() +
                        " on a " + player.getDie().getNumSides() + " sided die");
            }

            FileWriter fileWriter = new FileWriter("DiceGameOutput.txt");
            if (decideWinner(players) == -1) {
                fileWriter.write("The game is a tie.");
                System.out.println("The game is a tie.");
            } else {
                String winnerName = players.get(decideWinner(players)).getName();
                fileWriter.write(winnerName + " won the game.");
                System.out.println(winnerName + " won the game.");
            }
            fileWriter.close();
        } catch (IOException | java.util.InputMismatchException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    private static int decideWinner(List<Player> players) {
        int max = 0;
        int countMax = 0;
        int winnerIndex = -1;

        for (int i = 0; i < players.size(); i++) {
            int value = players.get(i).getDie().getValue();

            if (value > max) {
                max = value;
                countMax = 1;
                winnerIndex = i;
            } else if (value == max) {
                countMax++;
            }
        }

        return (countMax > 1) ? -1 : winnerIndex;
    }
}