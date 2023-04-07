package racingCarGameTest;

import racingCarGame.utils.RandomGeneration;

import java.util.Random;

public class SatisfyCondition implements RandomGeneration {

    private static final int NUMBER_OF_CONDITION_NUMBERS = 5;
    private static final int MINIMUM_CONDITION_NUMBERS = 4;

    private static final Random random = new Random();

    @Override
    public int generateRandomNumber() {
        return random.nextInt(NUMBER_OF_CONDITION_NUMBERS)+MINIMUM_CONDITION_NUMBERS;
    }
}
