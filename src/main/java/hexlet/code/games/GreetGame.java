package hexlet.code.games;

import hexlet.code.Engine;

public final class GreetGame extends Engine {
    public GreetGame() {
        super("");
    }

    public RoundSetting setNextRound() {
        return new RoundSetting("", "");
    }

    @Override
    public void runGame() {
        getPlayerName();
    }
}
