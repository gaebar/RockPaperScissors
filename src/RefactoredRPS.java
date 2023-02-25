import java.util.Random;
import java.util.Scanner;

public class RefactoredRPS {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] rps = { "r", "p", "s" };
        Random random = new Random();

        while (true) {
            String computerMove = rps[random.nextInt(rps.length)];
            String playerMove = getPlayerMove(scanner);
            String result = getResult(playerMove, computerMove);
            System.out.println("Computer played: " + computerMove);
            System.out.println(result);

            System.out.println("Play again? (y/n)");
            String playAgain = scanner.nextLine();
            if (!playAgain.equalsIgnoreCase("y")) {
                break;
            }
        }

        scanner.close();
    }

    private static String getPlayerMove(Scanner scanner) {
        String playerMove = "";
        while (!isValidMove(playerMove)) {
            System.out.println("Please enter your move (r, p, or s): ");
            playerMove = scanner.nextLine();
            if (!isValidMove(playerMove)) {
                // played around with the print format, adding the user input in quotation marks and capitalizing it
                System.out.printf("\"%S\" is not a valid move.%n", playerMove);

            }
        }
        return playerMove;
    }

    private static boolean isValidMove(String move) {
        return move.equals("r") || move.equals("p") || move.equals("s");
    }

    private static String getResult(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "The game was a tie!";
        } else if (playerMove.equals("r") && computerMove.equals("s")
                || playerMove.equals("p") && computerMove.equals("r")
                || playerMove.equals("s") && computerMove.equals("p")) {
            return "You win!";
        } else {
            return "You lose!";
        }
    }
}
