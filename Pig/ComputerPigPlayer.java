import java.util.Scanner;

/**
 * This is a basic computer pig player. Follows simple method of holding at 20.
 * @author      Nalin Richardson & Adam Smith
 * @version     1.1
 */

public class ComputerPigPlayer extends PigPlayer {

    /**
     * The main constructor for <code>ComputerPigPlayer</code>.
     * @param name The <code>ComputerPigPlayer</code>'s name
     */
    public ComputerPigPlayer(String name) {
        super(name);
    }

    /**
     * This function does nothing. It is here to fulfill the requirements of the abstract <code>PigPlayer</code> class.
     * @param myScore the player's current score (unused)
     * @param opponentsScore the opponent's current score (unused)
     */
    @Override
    public void beginTurn(int myScore, int opponentsScore) {
    }

    /**
     * Should the player roll again? The computer always rolls once.
     * @param turnNumber which turn the player is on (unused)
     * @param rollNumber which roll the player is on
     * @param poolSize the number of points currently in the pool (unused)
     * @param myScore the number of points the player has already won (unused)
     * @param opponentsScore the number of points the opponent has already won
     * (unused)
     * @return true to roll again, false to stop
     */
    @Override
    public boolean decideIfShouldRoll(int turnNumber, int rollNumber, int poolSize, int myScore, int opponentsScore) {
        if (myScore + poolSize >= 100) return false;
        if (poolSize < 20) return true;
        return false;
    }
}