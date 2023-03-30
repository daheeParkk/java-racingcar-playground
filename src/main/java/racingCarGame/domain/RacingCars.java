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
}
