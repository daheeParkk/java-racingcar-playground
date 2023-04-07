package racingCarGameTest;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingCarGame.domain.RacingCars;
import racingCarGame.service.CarService;
import racingCarGame.service.RacingService;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingServiceTest {

    private static final int MOVED_POSITION_ZERO = 0;
    private static final int MOVED_POSITION_ONCE = 1;

    private static RacingService racingService;
    private static CarService carService;

    @BeforeAll
    public static void generateService() {
        racingService = new RacingService();
        carService = new CarService();
    }

    @DisplayName("위치 값이 가장 큰 차를 반환하는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"car1,car2,car3>car1", "car1,car2,car3>car2"}, delimiter = '>')
    public void findWinningCarTest(String carsNames, String testCar) {
        RacingCars racingCars = RacingCars.from(carsNames);

        racingCars.moveCar(testCar);
        int maxPosition = racingCars.findMaxPosition();
        List<String> winningCars = racingCars.findWinningCar(maxPosition);

        assertThat(winningCars.get(0)).isEqualTo(testCar);
    }

    @DisplayName("난수가 4보다 작을 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"car1,car2,car3", "car1,car2,car3,car4,car5"})
    public void failToMeetConditionTest(String carsNames) {
        RacingCars racingCars = carService.generateCars(carsNames);
        FailToMeetCondition failToMeetCondition = new FailToMeetCondition();
        int randomNumber = failToMeetCondition.generateRandomNumber();

        racingCars.tryMoveCars(randomNumber);

        IntStream.range(0, racingCars.getNumberOfCars())
                .forEach(i -> assertThat(racingCars.getPositionByIndex(i)).isEqualTo(MOVED_POSITION_ZERO));
    }

    @DisplayName("난수가 4이상일 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"car1,car2,car3", "car1,car2,car3,car4,car5"})
    public void satisfyConditionTest(String carsNames) {
        RacingCars racingCars = carService.generateCars(carsNames);
        SatisfyCondition satisfyCondition = new SatisfyCondition();
        int randomNumber = satisfyCondition.generateRandomNumber();

        racingCars.tryMoveCars(randomNumber);

        IntStream.range(0, racingCars.getNumberOfCars())
                .forEach(i -> assertThat(racingCars.getPositionByIndex(i)).isEqualTo(MOVED_POSITION_ONCE));
    }

}
