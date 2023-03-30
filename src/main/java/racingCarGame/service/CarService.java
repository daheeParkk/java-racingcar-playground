package racingCarGame.service;

import racingCarGame.domain.Car;
import racingCarGame.domain.RacingCars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarService {

    public RacingCars generateCars(String carsName) {

        List<Car> cars = new ArrayList<>();
        List<String> carNames = separateCar(carsName);

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return new RacingCars(cars);
    }

    private List<String> separateCar(String carsName) {
        return Arrays.stream(carsName.split(",")).collect(Collectors.toList());
    }
}
