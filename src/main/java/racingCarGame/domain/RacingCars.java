package racingCarGame.domain;

import racingCarGame.exception.DuplicateException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RacingCars {

    private final List<Car> cars;
    private final List<String> carsNames = new ArrayList<>();
    private int position;

    public RacingCars(List<Car> cars) {
        checkDuplicate(cars);
        this.cars = new ArrayList<>(cars);
    }

    private void checkDuplicate(List<Car> cars) {
        for (Car car : cars) {
            carsNames.add(car.getName());
        }
        Set<String> deduplicatedCar = new HashSet<>(carsNames);

        if (cars.size() != deduplicatedCar.size()) {
            throw new DuplicateException();
        }
    }

    public int getNumberOfCars() {
        return cars.size();
    }

    public void moveCar(String carName) {
        for (Car car : cars) {
            if (car.isEqual(carName)) {
                car.movePosition();
            }
        }
    }

    public int getPositionByName(String carName) {
        for (Car car : cars) {
            if (car.isEqual(carName)) {
                position = car.getPosition();
            }
        }
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
}
