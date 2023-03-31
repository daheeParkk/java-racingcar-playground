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
import static racingCarGameTest.CarServiceTest.MOVED_POSITION_ONCE;

public class RacingServiceTest {

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

    @DisplayName("난수가 4 이상이면 위치가 증가하는 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"car1,car2,car3", "car1,car2,car3,car4,car5"})
    public void moveCarsOrNotTest() {
        RacingCars racingCars = carService.generateCars(carsNames);
        randomNumber.setSeed(0);
        racingService.moveCarsOrNot();

        for (int i=0; i<racingCars.getNumberOfCars(); i++){
            if(randomNumber.nextInt(9) >= 4) {
                assertThat(racingCars.getPosition(i)).isEqualTo(MOVED_POSITION_ONCE);
            }
        }
    }
}
