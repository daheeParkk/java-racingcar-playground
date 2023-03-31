package racingCarGame.service;

import racingCarGame.domain.RacingCars;

import java.util.Random;

public class RacingService {

    private static final int MINIMUM_FORWARD_CONDITION = 4;
    public static final Random randomNumber = new Random();

    public void generateRandomTime(long seed) {
        randomNumber.setSeed(seed);
    }

    public boolean isForwardCondition(int number) {
        return number >= MINIMUM_FORWARD_CONDITION;
    }

    public void moveCarsOrNot(RacingCars racingCars) {
        for (int i=0; i<racingCars.getNumberOfCars(); i++) {
            if (isForwardCondition(randomNumber.nextInt(9))) {
                racingCars.moveCar(racingCars.getNameByIndex(i));
            }
        }
    }
}
