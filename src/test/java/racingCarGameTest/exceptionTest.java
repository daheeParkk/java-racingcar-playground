package racingCarGameTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingCarGame.exception.CharacterLimitException;
import racingCarGame.service.CarService;

import static org.assertj.core.api.Assertions.*;

public class exceptionTest {

    private static CarService carService;

    @BeforeAll
    public static void generateService() {
        carService = new CarService();
    }

    @DisplayName("자동차 이름이 5글자를 초과할 경우")
    @ParameterizedTest
    @ValueSource(strings = {"abcde", "abcdef"})
    public void characterLimitException(String carsNames) {

        assertThatThrownBy(() -> carService.generateCars(carsNames)).isInstanceOf(CharacterLimitException.class);
    }
}
