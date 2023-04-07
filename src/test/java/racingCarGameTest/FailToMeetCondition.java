package racingCarGameTest;

import racingCarGame.utils.RandomNumber;

import java.util.Random;

public class FailToMeetCondition implements RandomNumber {

    private static final int NOT_CONDITION_NUMBER = 3;

    private static final Random random = new Random();

    @Override
    public int generateRandomNumber() {
        return random.nextInt(NOT_CONDITION_NUMBER);
    }
}
