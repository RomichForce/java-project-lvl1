package hexlet.code.games;

import hexlet.code.Engine;

import java.util.function.IntBinaryOperator;

public class CalcGame extends Engine {
    private static final String START_MESSAGE = "What is the result of the expression?";
    private static final int RAND_MIN = 1;
    private static final int RAND_MAX = 10;

    public CalcGame() {
        super(START_MESSAGE);
    }

    private enum OperationEnum {
        SUM("+", (int firstValue, int secondValue) -> Math.addExact(firstValue, secondValue)),
        MULT("*", (int firstValue, int secondValue) -> Math.multiplyExact(firstValue, secondValue)),
        DIFF("-", (int firstValue, int secondValue) -> Math.subtractExact(firstValue, secondValue));

        private final String operation;
        private final IntBinaryOperator operationFunction;

        OperationEnum(String currentOperation, IntBinaryOperator binaryOperation) {
            this.operation = currentOperation;
            this.operationFunction = binaryOperation;
        }

        public int getOperationResult(int firstValue, int secondValue) {
            return operationFunction.applyAsInt(firstValue, secondValue);
        }

        public String getOperation() {
            return operation;
        }

        public static OperationEnum getRandomOperation() {
            final OperationEnum[] list = OperationEnum.values();
            final int randIndex = RAND.nextInt(0, list.length);
            return list[randIndex];
        }
    }

    private int getRandomValue() {
        return RAND.nextInt(RAND_MIN, RAND_MAX);
    }

    /**
     * Set up new data for the next round.
     *
     * @return Data for the next round.
     */
    public RoundSetting setNextRound() {
        final int firstValue = getRandomValue();
        final int secondValue = getRandomValue();
        final OperationEnum randOperation = OperationEnum.getRandomOperation();
        final String questTarget = String.format("%d %s %d", firstValue, randOperation.getOperation(), secondValue);
        final String rightAnswer = String.valueOf(randOperation.getOperationResult(firstValue, secondValue));
        return new RoundSetting(questTarget, rightAnswer);
    }
}
