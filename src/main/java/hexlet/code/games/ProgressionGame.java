package hexlet.code.games;

import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.List;

public final class ProgressionGame extends Engine {
    private static final String START_MESSAGE = "What number is missing in the progression?";
    private static final int PROGRESSION_CHANGE_START = 0;
    private static final int PROGRESSION_MIN = 5;
    private static final int PROGRESSION_MAX = 10;
    private static final int RAND_MIN = -50;
    private static final int RAND_MAX = 50;

    public ProgressionGame() {
        super(START_MESSAGE);
    }

    public RoundSetting setNextRound() {
        final int progressionLength = getRandomValue(PROGRESSION_MIN, PROGRESSION_MAX);
        final int changeableValue = getRandomValue(PROGRESSION_CHANGE_START, progressionLength);
        final int progressionDiff = getRandomValue(RAND_MIN, RAND_MAX);
        final int startElement = getRandomValue(RAND_MIN, RAND_MAX);
        final List<String> progression = fillProgression(progressionLength, startElement, progressionDiff);
        final String rightAnswer = progression.get(changeableValue);
        progression.set(changeableValue, "..");
        final String questTarget = String.join(" ", progression);
        return new RoundSetting(questTarget, rightAnswer);
    }

    private List<String> fillProgression(int length, int firstElement, int diff) {
        final List<String> progression = new ArrayList<>();
        progression.add(String.valueOf(firstElement));
        for (int i = 0, element = firstElement; i < length - 1; i++) {
            element += diff;
            progression.add(String.valueOf(element));
        }
        return progression;
    }
}
