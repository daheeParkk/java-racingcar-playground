package racingCarGame.utils;

import java.util.Random;

public class RandomNumber implements RandomGeneration{

    private static final int CONDITION_NUMBER = 9;

    private static final Random random = new Random();

    @Override
    public int generateRandomNumber() {
        return random.nextInt(CONDITION_NUMBER);
    }
}
