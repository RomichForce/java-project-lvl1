package hexlet.code.games;

import hexlet.code.Engine;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public enum GameEnum {
    Greet(null),
    Even(new EvenGame()),
    Calc(new CalcGame()),
    GCD(new GCDGame()),
    Progression(new ProgressionGame());

    private final Engine selectGame;

    GameEnum(Engine choiceGame) {
        this.selectGame = choiceGame;
    }

    public static final GameEnum[] LIST = GameEnum.values();

    public static Pair<String, Engine> getGame(int i) {
        if (i < 0 || i > LIST.length) {
            return null;
        }
        final GameEnum game = LIST[(i - 1)];
        return new ImmutablePair<>(game.name(), game.selectGame);
    }
}
