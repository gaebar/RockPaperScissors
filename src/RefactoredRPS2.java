import java.util.Random;
import java.util.Scanner;

public class RefactoredRPS2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] moves = { "r", "p", "s" };
        Random random = new Random();
        String r = "Rock";
        String p = "Paper";
        String s = "Scissors";

        while (true) { // loop until user chooses to exit
            String computerMove = moves[random.nextInt(moves.length)];
            String playerMove = getPlayerMove(scanner, r, p, s); // get valid player move
            String result = getResult(playerMove, computerMove, r, p, s); // get game result

            System.out.println("Computer played: " + getMoveName(computerMove, r, p, s));
            System.out.println(result);

            System.out.println("Play again? (y/n)");
            scanner.nextLine(); // consume the newline character
            String playAgain = scanner.nextLine();

            if (!playAgain.equals("y")) { // exit loop if user chooses to quit
                break;
            }
        }
        scanner.close(); // close scanner
    }

    private static String getPlayerMove(Scanner scanner, String r, String p, String s) {
        String playerMove = "";
        while (!isValidMove(playerMove)) { // loop until player enters a valid move
            System.out.printf("Please enter your move (%s, %s, or %s): ", r, p, s);
            playerMove = scanner.nextLine();
            if (!isValidMove(playerMove)) {
                System.out.printf("\"%s\" is not a valid move.%n", playerMove);
            }
        }
        return playerMove;
    }

    private static String getMoveName(String move, String r, String p, String s) { // convert move from shorthand to full name
        if (move.equals("r")) {
            return r;
        } else if (move.equals("p")) {
            return p;
        } else if (move.equals("s")) {
            return s;
        }
        return "Unknown";
    }

    private static boolean isValidMove(String move) { // check if move is valid
        return move.equals("r") || move.equals("p") || move.equals("s");
    }

    private static String getResult(String playerMove, String computerMove, String r, String p, String s) {
        if (playerMove.equals(computerMove)) {
            return "The game was a tie!";
        } else if (playerMove.equals("r")) {
            if (computerMove.equals("p")) {
                return p + " covers " + r + ". You lose!";
            } else if (computerMove.equals("s")) {
                return r + " crushes " + s + ". You win!";
            }
        } else if (playerMove.equals("p")) {
            if (computerMove.equals("r")) {
                return p + " covers " + r + ". You win!";
            } else if (computerMove.equals("s")) {
                return s + " cuts " + p + ". You lose!";
            }
        } else if (playerMove.equals("s")) {
            if (computerMove.equals("p")) {
                return s + " cuts " + p + ". You lose!";
            } else if (computerMove.equals("r")) {
                return r + " crushes " + s + ". You lose!";
            }
        }
        return "An error occurred.";
    }
};
