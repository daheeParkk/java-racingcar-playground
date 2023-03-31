package racingCarGame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private final List<Car> cars;

    public RacingCars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
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
        int position = 0;

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
