package racingCarGame.service;

import racingCarGame.domain.Car;
import racingCarGame.domain.RacingCars;
import racingCarGame.exception.CharacterLimitException;
import racingCarGame.exception.DuplicateException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarService {

    private static final String STICK = "-";

    private static RacingCars racingCars;
    private int maxPosition;

    public RacingCars generateCars(String carsNames) throws CharacterLimitException, DuplicateException {

        List<Car> cars = new ArrayList<>();
        List<String> separatedCars = separateCar(carsNames);

        for (String carName : separatedCars) {
            cars.add(new Car(carName));
        }
        racingCars = new RacingCars(cars);
        return racingCars;
    }

    private List<String> separateCar(String carsName) {
        return Arrays.stream(carsName.split(",")).collect(Collectors.toList());
    }

    public void moveCar(String carName) {
        racingCars.moveCar(carName);
    }

    public int findMaxPosition(RacingCars racingCars) {
        for (int i=0; i<racingCars.getNumberOfCars(); i++) {
            int position = racingCars.getPositionByIndex(i);
            maxPosition = Math.max(maxPosition, position);
        }
        return maxPosition;
    }

    public String getStick(String carName) {
        StringBuilder stick = new StringBuilder();
        int position = racingCars.getPositionByName(carName);

        for (int i=0; i<position; i++) {
            stick.append(STICK);
        }
        return stick.toString();
    }
}
