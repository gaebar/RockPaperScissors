
/*
FIRST RockPaperScissors REFACTOR ATTEMPT - Personal notes:

This version of the code extracts the complexity into separate methods and uses
more descriptive method names, making the code easier to read and understand.

The getPlayerMove method handles getting a valid move from the player, while the
isValidMove method checks whether a given move is valid. The getResult method calculates
the game's outcome based on the player and computer moves.

With these changes, the cognitive complexity of the main method is reduced to 12,
well below the allowed limit of 15.

MORE:
- Made the print statement for the System.out.println(playerMove + " is not a valid move."); more readable.
I played a bit with the printf statement:
- added quotation marks around the %s format specifier ("\"%S\" is not ..."),
- returned the user input in capital letters (%S instead of %s).

NEXT STEPS:
On a new file, I want to:
-  add variables for the values "Rock", "Paper", and "Scissors" to make the code more readable;
- add comments describing the purpose and functionality of each code section.
*/

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
