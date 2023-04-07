package racingCarGameTest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingCarGame.domain.RacingCars;
import racingCarGame.service.CarService;

import static org.assertj.core.api.Assertions.assertThat;

public class CarServiceTest {

    private static final int MOVED_POSITION_ONCE = 1;

    private static CarService carService;

    @BeforeAll
    public static void generateService() {
        carService = new CarService();
    }

    @DisplayName("전달받은 차의 수만큼 차를 만드는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"car1,car2,car3=3", "car1,car2=2"}, delimiter = '=')
    public void generateCarsTest(String carsNames, int numberOfCars) {
        RacingCars racingCars = RacingCars.from(carsNames);
        assertThat(racingCars.getNumberOfCars()).isEqualTo(numberOfCars);
    }

    @DisplayName("위치가 +1되는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"car1,car2,car3>car1", "car1,car2,car3>car2"}, delimiter = '>')
    public void movePositionTest(String carsNames, String carName) {
        RacingCars racingCars = carService.generateCars(carsNames);
        carService.moveCar(carName);
        assertThat(racingCars.getPositionByName(carName)).isEqualTo(MOVED_POSITION_ONCE);
    }

    @DisplayName("가장 큰 위치 값을 구하는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"car1,car2,car3>car1>5", "car1,car2>car1>3"}, delimiter = '>')
    public void findMaxPositionTest(String carsNames, String car1, int numberOfMoves) {
        RacingCars racingCars = carService.generateCars(carsNames);

        for (int i = 0; i < numberOfMoves; i++) {
            racingCars.moveCar(car1);
        }
        assertThat(carService.findMaxPosition(racingCars)).isEqualTo(numberOfMoves);
    }

    @DisplayName("위치 값만큼 '-'를 만드는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"car1,car2,car3>car1>3>---", "a,b,c,d>a>5>-----"}, delimiter = '>')
    public void makeStick(String carsNames, String testCar, int numberOfMoves, String result) {
        RacingCars racingCars = carService.generateCars(carsNames);

        for (int i = 0; i < numberOfMoves; i++) {
            racingCars.moveCar(testCar);
        }
        assertThat(carService.getStick(testCar)).isEqualTo(result);
    }
}
