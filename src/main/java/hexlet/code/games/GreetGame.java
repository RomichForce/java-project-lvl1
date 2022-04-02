package hexlet.code.games;

import hexlet.code.Engine;

public class GreetGame extends Engine {
    public GreetGame() {
        super("");
    }

    /**
     * Set up new data for the next round.
     *
     * @return Data for the next round.
     */
    public RoundSetting setNextRound() {
        return new RoundSetting("", "");
    }

    /**
     * Start the game.
     */
    @Override
    public void runGame() {
        getPlayerName();
    }
}
