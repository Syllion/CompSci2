import java.util.Scanner;

/**
 * This is the human pig player. It makes all of its decisions based on input
 * from the keyboard.
 * @author      Adam Smith
 * @version     1.0
 */

public class HumanPigPlayer extends PigPlayer {

    // the shared Scanner among all human pig players (in case there are many)
    static Scanner inputScanner = null;

    /**
     * The main constructor for <code>HumanPigPlayer</code>.
     * @param name The <code>HumanPigPlayer</code>'s name
     */
    public HumanPigPlayer(String name) {
        super(name);

        // if this is the first HumanPigPlayer, allocate the Scanner
        if (inputScanner == null) inputScanner = new Scanner(System.in);
    }

    /**
     * Alert the human player that his/her turn is beginning.
     * @param myScore the player's current score
     * @param opponentsScore the opponent's current score
     */
    public void beginTurn(int myScore, int opponentsScore) {
        System.out.println(getName() +", it is now your turn!");
        System.out.println("\tYour score is "+myScore+", and your opponent's is " +opponentsScore+".");
    }

    /**
     * Should the player roll again? This method just asks the human at the
     * keyboard.
     * @param turnNumber which turn the player is on (unused)
     * @param rollNumber which roll the player is on (unused)
     * @param poolSize the number of points currently in the pool
     * @param myScore the number of points the player has already won (unused)
     * @param opponentsScore the number of points the opponent has already won
     * (unused)
     * @return true to roll again, false to stop
     */
    public boolean decideIfShouldRoll(int turnNumber, int rollNumber, int poolSize, int myScore, int opponentsScore) {
        System.out.println("The pool is now " +poolSize+".");
        return getYesNoQuestion("Do you wish to roll?");
    }

    // private helper function that keeps asking a question until it gets a yes or a no
    private static boolean getYesNoQuestion(String question) {
        while (true) {
            System.out.print(question +" ");
            String answer = inputScanner.nextLine();
            if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")) return true;
            if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")) return false;
        }
    }

}
