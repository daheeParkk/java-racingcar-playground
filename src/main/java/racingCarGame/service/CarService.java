package racingCarGame.service;

import racingCarGame.domain.Car;
import racingCarGame.domain.RacingCars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarService {

    private static RacingCars racingCars;

    public RacingCars generateCars(String carsNames) {

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
}
