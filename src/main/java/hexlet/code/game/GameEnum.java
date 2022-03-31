package hexlet.code.game;

public enum GameEnum {
    Greet {
        public BaseGame get() {
            return null;
        }
    },
    Even {
        public BaseGame get() {
            return new EvenGame();
        }
    };

    public static final GameEnum[] LIST = GameEnum.values();

    public static GameEnum getGame(int i) {
        if (i < 0 || i > LIST.length) {
            return null;
        }
        return LIST[(i - 1)];
    }

    public abstract BaseGame get();
}
