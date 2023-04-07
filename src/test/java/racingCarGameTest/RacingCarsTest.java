package racingCarGameTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingCarGame.domain.RacingCars;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {

    private static final int MOVED_POSITION_ONCE = 1;
    private static final int MOVED_POSITION_ZERO = 0;

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
        RacingCars racingCars = RacingCars.from(carsNames);
        racingCars.moveCar(carName);
        assertThat(racingCars.getPositionByName(carName)).isEqualTo(MOVED_POSITION_ONCE);
    }

    @DisplayName("위치 값만큼 '-'를 만드는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"car1,car2,car3>car1>3>---", "a,b,c,d>a>5>-----"}, delimiter = '>')
    public void makeStick(String carsNames, String testCar, int numberOfMoves, String result) {
        RacingCars racingCars = RacingCars.from(carsNames);

        for (int i = 0; i < numberOfMoves; i++) {
            racingCars.moveCar(testCar);
        }
        assertThat(racingCars.getStick(testCar)).isEqualTo(result);
    }

    @DisplayName("가장 큰 위치 값을 구하는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"car1,car2,car3>car1>5", "car1,car2>car1>3"}, delimiter = '>')
    public void findMaxPositionTest(String carsNames, String car1, int numberOfMoves) {
        RacingCars racingCars = RacingCars.from(carsNames);

        for (int i = 0; i < numberOfMoves; i++) {
            racingCars.moveCar(car1);
        }
        assertThat(racingCars.findMaxPosition()).isEqualTo(numberOfMoves);
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
        RacingCars racingCars = RacingCars.from(carsNames);
        FailToMeetCondition failToMeetCondition = new FailToMeetCondition();

        for (int i=0; i<racingCars.getNumberOfCars(); i++) {
            int randomNumber = failToMeetCondition.generateRandomNumber();
            racingCars.tryMoveCars(i, randomNumber);
        }
        IntStream.range(0, racingCars.getNumberOfCars())
                .forEach(i -> assertThat(racingCars.getPositionByIndex(i)).isEqualTo(MOVED_POSITION_ZERO));
    }

    @DisplayName("난수가 4이상일 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"car1,car2,car3", "car1,car2,car3,car4,car5"})
    public void satisfyConditionTest(String carsNames) {
        RacingCars racingCars = RacingCars.from(carsNames);
        SatisfyCondition satisfyCondition = new SatisfyCondition();

        for (int i=0; i<racingCars.getNumberOfCars(); i++) {
            int randomNumber = satisfyCondition.generateRandomNumber();
            racingCars.tryMoveCars(i, randomNumber);
        }
        IntStream.range(0, racingCars.getNumberOfCars())
                .forEach(i -> assertThat(racingCars.getPositionByIndex(i)).isEqualTo(MOVED_POSITION_ONCE));
    }
}
