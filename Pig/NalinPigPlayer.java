import java.util.Scanner;

/**
 * Smarter Computer Pig Player. Makes an educated number of guesses based on the distance between players scores.
 * @author      Nalin Richardson & Adam Smith
 * @version     1.1
 *
 */

public class NalinPigPlayer extends PigPlayer {

    /**
     * The main constructor for <code>ComputerPigPlayer</code>.
     *
     * @param name The <code>ComputerPigPlayer</code>'s name
     */
    public NalinPigPlayer(String name) {
        super(name);
    }

    /**
     * This function does nothing. It is here to fulfill the requirements of the abstract <code>PigPlayer</code> class.
     *
     * @param myScore        the player's current score (unused)
     * @param opponentsScore the opponent's current score (unused)
     */
    @Override
    public void beginTurn(int myScore, int opponentsScore) {
    }

    /**
     * Should the player roll again? The computer always rolls once.
     *
     * @param turnNumber     which turn the player is on (unused)
     * @param rollNumber     which roll the player is on
     * @param poolSize       the number of points currently in the pool (unused)
     * @param myScore        the number of points the player has already won (unused)
     * @param opponentsScore the number of points the opponent has already won
     *                       (unused)
     * @return true to roll again, false to stop
     */
    @Override
    public boolean decideIfShouldRoll(int turnNumber, int rollNumber, int poolSize, int myScore, int opponentsScore) {
        // If we have won, don't roll
        if ((myScore + poolSize) >= 100) return false;

        // If I can win in 26 or if they can win in 26 and im under 70, roll up tp 13 times
        if (((100 - myScore) <= 26) || (((opponentsScore >= 84) && (myScore <= 70)) && rollNumber < 13)) return true;

        int range = Math.abs(myScore - opponentsScore);

        // If we are tied (within 4), roll 4 times
        if (range <= 4 && rollNumber < 4) return true;

        // If we are within 4-10, roll 2 times
        if ((range > 4) && (range <= 10) && rollNumber < 2) return true;

        // If we are within 11-20, roll 3 times
        if ((range > 10) && (range <= 20) && rollNumber < 3) return true;

        // If we are within 21-25, roll 5 times
        if ((range > 20) && (range <= 25) && rollNumber < 5) return true;

        // If we are within 26-30, roll 7 times
        if ((range > 25) && (range <= 30) && rollNumber < 7) return true;

        // If we are behind by more 40 or more, roll 8 times
        if ((opponentsScore - myScore) >= 40 && rollNumber < 8) return true;

        // If we are ahead by 40 or more, roll 10 times
        if ((myScore - opponentsScore) >= 40 && rollNumber < 10) return true;

        return false;
    }
}

