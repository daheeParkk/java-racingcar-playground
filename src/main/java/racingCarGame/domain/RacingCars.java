package racingCarGame.domain;

import racingCarGame.exception.DuplicateException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private static final String COMMA = ",";

    private static List<Car> cars;

    private int position;

    public RacingCars(List<Car> cars) {
        checkDuplicate(cars);
        RacingCars.cars = new ArrayList<>(cars);
    }

    public static RacingCars from(String carsNames) {
        List<String> separatedCars = separateCars(carsNames);
        cars = separatedCars.stream()
                .map(Car::new)
                .collect(Collectors.toList());
        return new RacingCars(cars);
    }

    private static List<String> separateCars(String carsNames) {
        return Arrays.stream(carsNames.split(COMMA)).collect(Collectors.toList());
    }

    private void checkDuplicate(List<Car> cars) {
        long deduplicatedCount = cars.stream()
                .map(Car::getName)
                .distinct()
                .count();

        if (cars.size() != deduplicatedCount) {
            throw new DuplicateException();
        }
    }

    public int getNumberOfCars() {
        return cars.size();
    }

    public void moveCar(String carName) {
        cars.stream()
                .filter(car -> car.isEqualName(carName))
                .forEach(Car::movePosition);
    }

    public int getPositionByName(String carName) {
      cars.stream()
                .filter(car -> car.isEqualName(carName))
                .forEach(car -> position = car.getPosition());
        return position;
    }

    public String getNameByIndex(int index) {
        return cars.get(index).getName();
    }

    public int getPositionByIndex(int index) {
        return cars.get(index).getPosition();
    }

    public boolean isSamePosition(int index, int maxPosition) {
        return getPositionByIndex(index) == maxPosition;
    }

    public void tryMoveCars(int randomNumber) {
        cars.stream()
                .filter(car -> randomNumber >= 4)
                .forEach(Car::movePosition);
    }

    public int findMaxPosition() {
        return 0;
    }
}
