/**
 * This is the skeleton of the Pig game.
 * @author   Adam Smith & Nalin Richardson
 * @version   1.1
 */

class Pig {
    /**
     * The score needed to win a round.
     */
    public static final int WINNING_SCORE = 100;

    public static void main(String[] args) {
        // intro, initialize players
        System.out.println("Welcome to Pig!");
        PigPlayer human = new HumanPigPlayer("Human");
        PigPlayer opponent = new ComputerPigPlayer("Skynet"); // could be human too
        int[] roundsWon = new int[2];

        // round 1
        System.out.println("Round 1!");
        if (playRound(human, opponent)) roundsWon[0]++;
        else roundsWon[1]++;

        System.out.println();

        // round 2
        System.out.println("Round 2!");
        if (playRound(opponent, human)) roundsWon[1]++;
        else roundsWon[0]++;

        // report the final results
        reportFinalTally(roundsWon, human, opponent);
    }

    /**
     * Do one round, crediting the winner.
     * @param player1 the first player
     * @param player2 the second player
     * @return true if player1 won, false if player2
     */
    private static boolean playRound(PigPlayer player1, PigPlayer player2) {
        int player1Score = 0, player2Score = 0;
        int turn = 0;
        boolean winner;
        for (int i = 0; ; i++) {
            turn++;
            player1Score += playTurn(player1, turn, player1Score, player2Score);
            if (player1Score >= WINNING_SCORE) {
                System.out.println(player1.getName() + " has won!!");
                winner = true;
                break;
            }

            player2Score += playTurn(player2, turn, player2Score, player1Score);
            if (player2Score >= WINNING_SCORE) {
                System.out.println(player2.getName() + " has won!!");
                winner = false;
                break;
            }

            System.out.println("------------------------");
        }
        return winner;
    }

    /**
     * Play a single turn, returning how many points the player got.
     * @param player the player whose turn it is
     * @param turnNum the turn number (0-indexed)
     * @param score the player's score
     * @param opponentsScore the player's adversary's score
     * @return the points that the player won
     */
    private static int playTurn(PigPlayer player, int turnNum, int score, int opponentsScore) {
        int playerPool = 0;
        player.beginTurn(score, opponentsScore);
        int rollNum = 0;
        while (player.decideIfShouldRoll(turnNum, rollNum, playerPool, score, opponentsScore)) {
            int roll = roll();
            System.out.println(player.getName() + " rolled a " + roll);
            if (roll != 1) {
                playerPool += roll;
            } else {
                System.out.println("Turn is over, all points have been lost.");
                return 0;
            }
            rollNum++;

        }
        System.out.println("{Times rolled: "+rollNum+"}");
        return playerPool;

    }

    /**
     * Deliver a final report, indicating the overall winner after all rounds
     * have been played.
     * @param roundsWon an array of <code>int</code>s indicating the number of rounds each player won
     * @param player1 the first player
     * @param player2 the second player
     */
    private static void reportFinalTally(int[] roundsWon, PigPlayer player1, PigPlayer player2) {
        System.out.println("\n" + player1.getName() + " has won " + roundsWon[0] + " games.");
        System.out.println(player2.getName() + " has won " + roundsWon[1] + " games.");

        if (roundsWon[0] == roundsWon[1]) {
            System.out.println("\nThere was a tie!");
        } else if (roundsWon[0] > roundsWon[1]) {
            System.out.println("\n" + player1.getName() + " has won the game!!");
        } else {
            System.out.println("\n" + player2.getName() + " has won the game!!");
        }
    }

    /**
     * Rolls a "die"
     * @return The rolled value
     */
    private static int roll() {
        return (int) (Math.random() * 6) + 1;
    }
}