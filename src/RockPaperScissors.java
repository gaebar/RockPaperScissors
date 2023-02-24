import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        String[] rps = {"r", "p", "s"};
        String computerMove = rps[new Random().nextInt(rps.length)];


        Scanner scanner = new Scanner(System.in);
        String playerMove;

        while(true){
            System.out.println("Please enter your move (r, p, or s)");
            playerMove = scanner.nextLine();
            if (playerMove.equals("r") || playerMove.equals("p") || playerMove.equals(|"s")){
                break;
            }

    }
}
