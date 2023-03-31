package racingCarGameTest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingCarGame.domain.RacingCars;
import racingCarGame.service.CarService;
import racingCarGame.service.RacingService;

import static org.assertj.core.api.Assertions.*;

public class RacingServiceTest {

    private static final int MOVED_POSITION_ONCE = 1;

    private static RacingService racingService;
    private static CarService carService;

    @BeforeAll
    public static void generateRacingService() {
        racingService = new RacingService();
        carService = new CarService();
    }

    @DisplayName("4 이상이면 true를 반환하는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2,false","3,false","4,true","5,true"}, delimiter = ',')
    public void isForwardConditionTest(int number, boolean result) {
        assertThat(racingService.isForwardCondition(number)).isEqualTo(result);
    }

    @DisplayName("전달받은 차의 수만큼 차를 만드는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"car1,car2,car3=3","car1,car2=2"}, delimiter = '=')
    public void generateCarsTest(String carsNames, int numberOfCars) {
        RacingCars racingCars = carService.generateCars(carsNames);
        assertThat(racingCars.getNumberOfCars()).isEqualTo(numberOfCars);
    }

    @DisplayName("위치가 +1되는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"car1,car2,car3>car1", "car1,car2,car3>car2"}, delimiter = '>')
    public void movePositionTest(String carsNames, String carName) {
        RacingCars racingCars = carService.generateCars(carsNames);
        carService.moveCar(carName);
        assertThat(racingCars.getPosition(carName)).isEqualTo(MOVED_POSITION_ONCE);
    }
}
